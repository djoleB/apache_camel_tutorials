package com.georgedoestechstuff.camel.demo.rabbitmq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class RabbitMqProducerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:foo?period=100000")
                .routeId("RabbitMqProducer")
                .setBody().constant("{\"some\":\"field\"}")
                .log("Trying to send : ${body}")
                .to("rabbitmq:testExchange?autoDelete=false&declare=false&connectionFactory=#rabbitConnectionFactory")
                .log("Message Sent!");

    }
}
