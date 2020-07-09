/*
package org.example.config;

import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.impl.SimpleRegistry;

import org.example.model.StudentFieldSetMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class ApacheCamelConfig {

	@Autowired
	private ApplicationRouteConfig applicationRouteConfig;

	@Autowired StudentFieldSetMapper studentFieldSetMapper;

	@Autowired DataSource myDataSource;
	
	 
	
	@Bean
	public CamelContext routeConfig() {
		SimpleRegistry simpleRegistry = new SimpleRegistry();
		simpleRegistry.put("studentFieldSetMapper", studentFieldSetMapper);
		simpleRegistry.put("myDataSource", myDataSource);

		CamelContext ctx = new DefaultCamelContext(simpleRegistry);
		try {
			ctx.addRoutes(applicationRouteConfig);
			ctx.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ctx;
	}

}*/
