package org.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.InvalidPayloadException;
import org.example.model.Employee;
import org.example.model.Employees;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.SystemException;

import java.util.List;

@Component
public class FileReaderHandler {

    @Handler
    public void handler(Exchange groupExchange) throws InvalidPayloadException {
        groupExchange.getIn().getBody();
        System.out.println("chicking whether its working !");
    }
}
