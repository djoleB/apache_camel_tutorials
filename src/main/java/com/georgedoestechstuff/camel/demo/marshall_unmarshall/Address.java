package com.georgedoestechstuff.camel.demo.marshall_unmarshall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;

    @NotNull
    @Size(min = 5, max = 150)
    private String streetName;

    @NotNull
    @DecimalMin(value = "1")
    private Integer buildingNumber;

    @NotNull
    @Size(min = 2, max = 150)
    private String city;

    @NotNull
    @DecimalMin(value = "10000")
    private Integer zipcode;

    @NotNull
    @Size(min = 2, max = 150)
    private String country;

    private String county_code;
    private float latitude;
    private float longitude;

}