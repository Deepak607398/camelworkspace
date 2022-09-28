package com.example.apachemsa.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MyFirstRoute extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		// from is the starting point of the route or producer
		// to is the end point
		// timer and log are the camel keywords
		// transform() Adds a processor which sets the body on the OUT message
		from("timer:couter-timer").transform().constant("Current time is:" + LocalDateTime.now())
				.to("log:couter-timer");

	}

}
