package com.example.apachemsa.routes;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class FileRouter extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("file:files/json").log("${body}").to("activemq:file-queue");
	}
}