package com.ebsco.folio.nortecprocessing;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class NortecProcessingApplication {

	public static void main(String[] args) {
		SpringApplication.run(NortecProcessingApplication.class, args);
	}

}
