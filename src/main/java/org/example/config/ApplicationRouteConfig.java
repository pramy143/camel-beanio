/*
package org.example.config;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.example.model.Student;
import org.example.processor.CsvFileProcessor;
import org.example.processor.SimpleFileProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
public class ApplicationRouteConfig extends RouteBuilder {

	@Autowired
	private SimpleFileProcessor simpleFileProcessor;

	@Autowired
	private CsvFileProcessor csvFileProcessor;

	@Autowired DataSource dataSource;

	@Override
	public void configure() throws Exception {

		from("sql:select * from student?dataSource=myDataSource?outputType=SelectList&outputClass=Student")
			.marshal(new BindyCsvDataFormat(Student.class))
		.to("file:C:/input/simple-file");

		// To read csv file and save in db using sql component
		from("file:c:/input/csv-file?noop=true;move=.camel&consumer.delay=1s&idempotent=true")
				.split(body().tokenize("\n")).streaming().unmarshal().csv()
				.beanRef("studentFieldSetMapper", "dataMapper")
				.to("sql:insert into  student (first_name,last_name,phone_num,updated_time_stamp) values(:#first_name,:#last_name,:#phone_num,:#updated_time_stamp)?dataSource=myDataSource");
	}

}*/
