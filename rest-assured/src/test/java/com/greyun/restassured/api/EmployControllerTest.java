package com.greyun.restassured.api;

import com.greyun.restassured.api.dto.Employ;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


class EmployControllerTest {
    private EmployService employService;
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        employService = mock(EmployService.class);
        mockMvc = MockMvcBuilders.standaloneSetup(new EmployController(employService))
                .build();

        BDDMockito.given(employService.getEmploys())
                .willReturn(List.of(
                        new Employ("greyun", 1234L),
                        new Employ("pablo", 5678L)
                ));
    }

    @Test
    void getEmploys() {
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

    @Test
    void getEmploys_mockMvc() throws Exception {
        mockMvc.perform(
                get("/employs")
                        .param("name", "greyun")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"name\":\"greyun\",\"age\":30}"))
                .andDo(print())
                .andExpect(jsonPath("$[0].name").value("greyun"))
                .andExpect(jsonPath("$[0].departmentId").value(1234L));
    }
}