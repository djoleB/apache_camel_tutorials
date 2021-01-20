package com.georgedoestechstuff.camel.demo.http_component;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.http.base.HttpOperationFailedException;
import org.springframework.stereotype.Component;

import static org.apache.camel.Exchange.*;
import static org.springframework.http.HttpMethod.POST;

public class HttpRoute extends RouteBuilder {

    @Override
    public void configure() {

        onException(HttpOperationFailedException.class)
                .log("Error: ${exception}");

        from("timer:foo?period=100000")
                .setHeader(HTTP_URI).constant(" https://httpreq.com")
                .setHeader(HTTP_PATH).constant("/empty-field-vcj7t8m8/record/")
                .setHeader("some").constant("header")
                .setHeader(HTTP_METHOD).constant(POST)
                .setBody().constant("{\"some\":\"json\"}")
                .toD("${header." + HTTP_URI + "}")
                .log("BODY: ${body}")
                .log("Headers: ${headers}");

    }
}
