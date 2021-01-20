package com.georgedoestechstuff.camel.demo.rabbitmq;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class RabbitMqConsumerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("rabbitmq:testExchange?queue=testQueue&autoDelete=false&declare=false&connectionFactory=#rabbitConnectionFactory" )
                .routeId("RabbitMqConsumer" )
                .log("Received body: ${body}" );
    }
}
