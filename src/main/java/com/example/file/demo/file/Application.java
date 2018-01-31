package com.example.file.demo.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

@SpringBootApplication
public class Application {

	public static void main(String[] args) throws IOException {
		ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder(Application.class).build()
				.run(args);

		System.out.println();

		ConfigurableEnvironment environment = applicationContext.getEnvironment();

		System.out.println(environment.getProperty("value1"));
		System.out.println(environment.getProperty("value2"));

		String inputPath = environment.getProperty("source");

		File file = new File(inputPath + "/input.txt");

		FileReader reader = new FileReader(file);

		BufferedReader reader2 = new BufferedReader(reader);
		String str = null;
		while ((str = reader2.readLine()) != null) {
			System.out.println(str);
		}
		reader2.close();

	}
}
