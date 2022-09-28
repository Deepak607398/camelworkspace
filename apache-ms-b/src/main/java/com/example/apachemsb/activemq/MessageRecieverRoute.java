package com.example.apachemsb.activemq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MessageRecieverRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:route-activemq-queue").to("log:reciever-mesages-activemq");

	}

}
