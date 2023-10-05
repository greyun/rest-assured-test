package com.greyun.restassured.api.dto;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class EmployRequest {
    private String name;
    private Long age;
}
