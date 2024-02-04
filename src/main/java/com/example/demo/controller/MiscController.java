package com.example.demo.controller;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.azure.messaging.servicebus.ServiceBusMessage;
import com.azure.messaging.servicebus.ServiceBusSenderClient;

@RestController
@RequestMapping("/msgbus")
public class MiscController {

	@Autowired
	private ServiceBusSenderClient senderClient;

	@GetMapping("/sendMsg")
	public String run() throws Exception {
		// send one message to the queue
		senderClient.sendMessage(new ServiceBusMessage("Hello, World!"));
		System.out.printf("Sent a message to the queue");
		senderClient.close();
		// wait the processor client to consume messages
		TimeUnit.SECONDS.sleep(10);
		return "Send successful";
	}
}