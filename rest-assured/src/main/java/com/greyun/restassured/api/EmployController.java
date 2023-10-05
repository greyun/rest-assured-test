package com.greyun.restassured.api;

import com.greyun.restassured.api.dto.Employ;
import com.greyun.restassured.api.dto.EmployRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class EmployController {
    @GetMapping("/employs")
    public List<Employ> getEmploys(@RequestParam("name") String name, @RequestBody EmployRequest request) {
        log.info("name: {}, request: {}", name, request);
        return List.of(
                new Employ("greyun", 1234L),
                new Employ("pablo", 5678L));
    }
}
