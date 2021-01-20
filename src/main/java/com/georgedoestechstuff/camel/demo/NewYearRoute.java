package com.georgedoestechstuff.camel.demo;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

import static org.apache.camel.LoggingLevel.INFO;

public class NewYearRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:foo?period=100000")
                .routeId("NEW YEAR ROUTE")
                .log(INFO, this.log, "Hello!")
                .delay(2000)
                .log(INFO, this.log, "Just wanted to wish you good people Happy New Year!")
                .delay(2000)
                .log(INFO, this.log, "Stay safe.")
                .delay(2000)
                .log(INFO, this.log, "Enjoy life.")
                .delay(2000)
                .log(INFO, this.log, "Learn a lot.")
                .delay(2000)
                .log(INFO, this.log, "Love even more")
                .delay(2000)
                .log(INFO, this.log, "Cheers!")
                .log(INFO, this.log, "George / Djordje");

    }

}
