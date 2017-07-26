package com.codexa.demo.datacassandrakafkademo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataCassandraKafkaDemoApplication implements CommandLineRunner {


	@Autowired
	private CmdRunner cmdRunner;

	public static void main(String[] args) {
		SpringApplication.run(DataCassandraKafkaDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		if (args.length <= 0) {
			System.out.println("First input argument is required : try (kafka, cassandra, coap) ");
			System.exit(0);
		}

		String operation = args[0].toLowerCase();
		switch (operation) {
			case "kafka" : {
				System.out.println("kafka started ...");
				cmdRunner.writeToKafka();
				break;
			}
			case "cassandra" : {
				System.out.println("cassandra started ...");
				cmdRunner.writeToCassandra();
				break;
			}
			case "coap" : {
				System.out.println("coap started ...");
				cmdRunner.generateCoapData();
				break;
			}
			default : {
				System.out.println("Wrong input arguments : try (kafka, cassandra, coap) ");
				System.exit(0);
			}
		}
	}
}
