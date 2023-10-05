package com.greyun.restassured.api;

import com.greyun.restassured.api.dto.Employ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployService {
    public List<Employ> getEmploys() {
        return List.of(
                new Employ("greyun", 1234L),
                new Employ("pablo", 5678L));
    }
}
