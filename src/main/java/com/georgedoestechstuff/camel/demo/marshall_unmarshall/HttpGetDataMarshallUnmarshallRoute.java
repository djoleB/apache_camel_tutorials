package com.georgedoestechstuff.camel.demo.marshall_unmarshall;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;

import static org.apache.camel.LoggingLevel.INFO;

public class HttpGetDataMarshallUnmarshallRoute extends RouteBuilder {

    @Override
    public void configure() {

        JacksonDataFormat addressesDataFormat = new JacksonDataFormat(Addresses.class);
        addressesDataFormat.setPrettyPrint(true);

        from("direct:http")
                .log(INFO, this.log, "This will be second message!")
                .to("https://fakerapi.it/api/v1/addresses?_quantity=1")
                .unmarshal(addressesDataFormat)
                .log(INFO, this.log,"Deserialized Data: ${body}")
                .marshal(addressesDataFormat)
                .log(INFO, this.log, "Serialized Data: ${body}");

    }

}
