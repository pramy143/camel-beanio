package org.example.route;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.beanio.BeanIODataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.spi.DataFormat;
import org.example.processor.EmployeeFileProcessor;
import org.example.processor.FileReaderHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class EmployeeParsingRoute extends RouteBuilder {

	DataFormat employeeDataformat = new BeanIODataFormat("mapping/employee_mapping.xml", "employeeStream");

	@Autowired
	private FileReaderHandler fileReaderHandler;

	@Override
	public void configure() throws Exception {

		/*from("sql:select * from emplyees?dataSource=myDataSource?outputType=SelectList&outputClass=Student")
			.unmarshal(employeeDataformat)
			.process(new EmployeeFileProcessor());*/

		from("file:C:/camel-learning/employee?noop=true")
		.unmarshal(employeeDataformat)
		.process(new EmployeeFileProcessor())
		.end();

	}

	public static void main(String[] args) {
		CamelContext camelContext = new DefaultCamelContext();
		try {
			camelContext.addRoutes(new EmployeeParsingRoute());

			camelContext.start();

			Thread.sleep(10000);
			camelContext.stop();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}