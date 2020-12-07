package com.georgedoestechstuff.camel.demo.processors_lesson;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.http.HttpMethod;

import static org.apache.camel.Exchange.HTTP_METHOD;
import static org.springframework.http.HttpMethod.POST;

@Slf4j
public class ProcessorsRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:footimer?period=500000")
                .setHeader(HTTP_METHOD).constant(HttpMethod.GET)
                .log("HttpMethod: ${header."+ HTTP_METHOD +"}")
                .process(exchange -> {

                     log.info("We are in processor!");
                    exchange.getIn().setHeader(HTTP_METHOD, POST);
                    exchange.getIn().setHeader("dummy", "true");
                    exchange.getIn().setBody("Test Payload!");
                })
                .log("HttpMethod: ${header."+ HTTP_METHOD +"}")
                .to("https://httpreq.com/rough-firefly-e0wkisno/record");

    }
}
