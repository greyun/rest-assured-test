package com.greyun.restassured.api;

import com.greyun.restassured.api.dto.Employ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.MediaType;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.mock;


class EmployControllerTest {
    private EmployService employService;

    @BeforeEach
    void setUp() {
        employService = mock(EmployService.class);
    }

    @Test
    void getEmploys() {
        BDDMockito.given(employService.getEmploys())
                .willReturn(List.of(
                        new Employ("greyun", 1234L),
                        new Employ("pablo", 5678L)
                ));

        given().standaloneSetup(new EmployController(employService))
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