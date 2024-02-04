package com.example.demo;

import java.util.concurrent.TimeUnit;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

@SpringBootApplication
public class AzureBlobAccessDemoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AzureBlobAccessDemoApplication.class, args);
	}

	private final ServiceBusSenderClient senderClient;

	public AzureBlobAccessDemoApplication(ServiceBusSenderClient senderClient) {
		this.senderClient = senderClient;
	}

	@Override
	public void run(String... args) throws Exception {
		// send one message to the queue
		senderClient.sendMessage(new ServiceBusMessage("Hello, World!"));
		System.out.printf("Sent a message to the queue");
		senderClient.close();

		// wait the processor client to consume messages
		TimeUnit.SECONDS.sleep(10);
	}
}
