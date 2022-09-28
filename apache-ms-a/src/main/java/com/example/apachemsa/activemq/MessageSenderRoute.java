package com.example.apachemsa.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageSenderRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("timer:activemq-timer-route?period=10000").transform().constant("Hello from BehindJAVA").log("${body}")
				.to("activemq:route-activemq-queue");
	}

}
