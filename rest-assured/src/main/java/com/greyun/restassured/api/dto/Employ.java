package com.greyun.restassured.api.dto;

import lombok.Getter;

@Getter
public class Employ {
    private final String name;
    private final Long departmentId;

    public Employ(String name, Long departmentId) {
        this.name = name;
        this.departmentId = departmentId;
    }
}
