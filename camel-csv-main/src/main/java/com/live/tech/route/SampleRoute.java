package com.live.tech.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.apache.camel.dataformat.bindy.csv.BindyCsvDataFormat;
import org.apache.camel.model.dataformat.JsonLibrary;
import org.apache.camel.spi.DataFormat;
import org.springframework.stereotype.Component;

import com.live.tech.SampleUser;

@Component
public class SampleRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        DataFormat bind = new BindyCsvDataFormat(SampleUser.class);
        JacksonDataFormat jacksonDataFormat = new JacksonDataFormat(SampleUser.class);
        jacksonDataFormat.useList();
        jacksonDataFormat.setUnmarshalType(SampleUser.class);

        from("file:src/main/resources/repo?noop=true")
                .log("Data received from CSV file")
                .unmarshal(bind)
                .marshal().json(JsonLibrary.Jackson, true)
                .convertBodyTo(String.class)
                .log("${body}")
                .to("direct:nextQueue")
                .log("Data moved to next route");

        from("direct:nextQueue")
                .log("Data recieved from above route")
//                .unmarshal(jacksonDataFormat)
//                .marshal().bindy(BindyType.Csv,SampleUser.class)
                .to("file:src/main/resources/repo?fileName=newSampleData.json")
                .log("Successfully created CSV");

    }
}
