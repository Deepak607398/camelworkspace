package com.example.apachemsb.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.springframework.stereotype.Component;

@Component
public class FileRouterReceiver extends RouteBuilder {

	@Override
	public void configure() throws Exception {
		from("activemq:file-queue").unmarshal().json(JsonLibrary.Jackson, FxConverter.class)
				.to("log:recieving-mesages-activemq");

	}

}
