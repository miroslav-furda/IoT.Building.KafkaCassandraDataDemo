package com.codexa.demo.ckc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

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
			return;
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
				cmdRunner.writeGeneratedCoapData(Integer.valueOf(args[1])); // NPE if null not important
				break;
			}
			default : {
				System.out.println("Wrong input arguments : try (kafka, cassandra, coap) ");
			}
		}
	}
}
