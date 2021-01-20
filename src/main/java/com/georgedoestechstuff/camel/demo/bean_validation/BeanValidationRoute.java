package com.georgedoestechstuff.camel.demo.bean_validation;

import com.georgedoestechstuff.camel.demo.marshall_unmarshall.Address;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

public class BeanValidationRoute extends RouteBuilder {

    @Override
    public void configure() {

        Address address = Address.builder()
                .streetName("Kneza Milosa")
                .buildingNumber(1)
                .city("Belgrade")
                .zipcode(11000)
                .country("Serbia")
                .build();

        from("timer:foo?period=100000")
                .setBody().constant(address)
                .to("bean-validator:validateAddress");

    }
}
