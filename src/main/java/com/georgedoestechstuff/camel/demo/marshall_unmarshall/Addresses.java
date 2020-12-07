package com.georgedoestechstuff.camel.demo.marshall_unmarshall;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Addresses {

    private String status;
    private int code;
    private int total;
    private List<Address> data;

}
