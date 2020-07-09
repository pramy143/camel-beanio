package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories("com.siddu")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    /*@Bean
    public CsvFileProcessor csvFileProcessor() {
        return new CsvFileProcessor();
    }*/

    /*@Bean
    public StudentFieldSetMapper studentFieldSetMapper() {
        return new StudentFieldSetMapper();
    }*/

}
