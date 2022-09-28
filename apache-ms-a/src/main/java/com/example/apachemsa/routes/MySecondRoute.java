package com.example.apachemsa.routes;

import java.time.LocalDateTime;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//@Component
public class MySecondRoute extends RouteBuilder {

	@Autowired
	private GetCurrentTimeBean getCurrentTimeBean;

	@Autowired
	private LogComponent logComponent;

	@Override
	public void configure() throws Exception {

		from("timer:first-timer")
		.log("${body}")
		.transform().constant("Hello World Message")
		.log("${body}")
		.bean(getCurrentTimeBean)
		.log("${body}")
		.bean(logComponent)
		.log("${body}")
		.to("log:first-timer");

	}

}

@Component
class GetCurrentTimeBean {

	public String getCurrentTime() {
		return "Current time is:" + LocalDateTime.now();
	}
}

@Component
class LogComponent {

	private Logger logger = LoggerFactory.getLogger(LogComponent.class);

	public void process(String message) {
		logger.info("LogComponent  {}", message);
	}
}
