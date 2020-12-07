package com.georgedoestechstuff.camel.demo.create_route;

import org.apache.camel.builder.RouteBuilder;

import static org.apache.camel.LoggingLevel.INFO;

public class ExampleRoute extends RouteBuilder {

    @Override
    public void configure() {

        //https://fakerapi.it/api/v1/addresses?_quantity=1

        from("timer:foo?period=500000")
                .routeId("Main Route")
                .log(INFO, this.log, "This will be first message ever!")
                .to("direct:http");


    }
}
