package org.example.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.example.model.Employee;
import org.example.model.Employees;

import java.util.List;

public class EmployeeFileProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {

		List<List<Employee>> data = (List<List<Employee>>) exchange.getIn().getBody();
		System.out.println(data);
		System.out.println(data.get(0));
		Employees emplyee = (Employees) data.get(1);
		System.out.println("total lines: "+data.get(1));
		System.out.println("total lines: "+data.get(2));
		System.out.println("total lines: "+data.size());

		// iterate over each line
		for( Employee line : emplyee.getEmployee()) {
			System.out.println("Total columns: "+line.getLastName());
			System.out.println(line.getFirstName()); // first column
		}
		
	}

}