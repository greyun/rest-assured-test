package com.greyun.restassured.api;

import org.junit.jupiter.api.Test;
import org.springframework.http.MediaType;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;


class EmployControllerTest {
    @Test
    void getEmploys() {
        given().standaloneSetup(new EmployController())
                .param("name", "greyun")
                .contentType(MediaType.APPLICATION_JSON)
                .body("{\"name\":\"greyun\",\"age\":30}")
                .log().all()
                .when()
                .get("/employs")
                .then()
                .statusCode(200);
    }
}