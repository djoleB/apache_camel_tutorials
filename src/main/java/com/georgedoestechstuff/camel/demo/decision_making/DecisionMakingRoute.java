package com.georgedoestechstuff.camel.demo.decision_making;

import org.apache.camel.Predicate;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class DecisionMakingRoute extends RouteBuilder {

    @Override
    public void configure() {

        Predicate isFirst = header("dummy").isEqualTo(1);
        Predicate isSecond = header("dummy").isEqualTo(2);

        from("timer:foo?period=100000")
                .id("DecisionMakingRoute")
                .setHeader("dummy").constant(1)
                .choice()
                    .when(isFirst)
                        .log("FirstCondition")
                        .to("direct:test1")
                    .when(isSecond)
                        .log("SecondCondition")
                    .otherwise()
                        .log("Otherwise")
                .endChoice();

        from("direct:test1")
                .log("AnotherRoute");

    }
}
