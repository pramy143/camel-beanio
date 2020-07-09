package org.example.route;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.example.processor.FileReaderHandler;
import org.example.processor.FileWriterHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeCamelRouteBuilder extends RouteBuilder {

    @Autowired
    private FileReaderHandler fileReaderHandler;

    @Autowired
    private FileWriterHandler fileWriterHandler;

    @Override
    public void configure() throws Exception {
        from("direct:testingBeanReader")
            .routeId("readContentFromBean")
            .process(new Processor() {
                @Override
                public void process(final Exchange exchange) throws Exception {
                    exchange.getIn(FileReaderHandler.class);
                }
            })
            .to("direct:testingBeanWriter")
            .bean(FileWriterHandler.class)
            .end();
    }

    public static void main(String[] args) {
        CamelContext camelContext = new DefaultCamelContext();
        try {
            camelContext.addRoutes(new EmployeeCamelRouteBuilder());

            camelContext.start();

            Thread.sleep(10000);
            camelContext.stop();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
