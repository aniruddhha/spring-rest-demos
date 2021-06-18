package com.ani.rest.restdemos.controller;

import com.ani.rest.restdemos.domain.Car;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CarController.class)
public class CarControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper mapper;

    @Test
    @DisplayName("Car - Saving the car")
    void testCarSaving() throws Exception {
        final Car car = new Car("bb", 45.26);

        mvc.perform(
                MockMvcRequestBuilders.post("/car/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(car))
        ).andExpect(
                MockMvcResultMatchers.status().isBadRequest()
        );
    }

    @Test
    @DisplayName("Car - Saving the car - checking response")
    void testSaveCarResponse() throws Exception {
        final Car car = new Car("bb", 45.26);

        mvc.perform(
                MockMvcRequestBuilders.post("/car/")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(car))
        ).andExpect(
                MockMvcResultMatchers
                        .jsonPath("sts")
                        .value("success")
        );
    }

    @Test
    @DisplayName("Car - Delete Car")
    void testDeleteCar() throws Exception {
        mvc.perform(
                MockMvcRequestBuilders.delete("/car/").queryParam("carId", "1")
        ).andExpect(
                MockMvcResultMatchers
                        .jsonPath("sts")
                        .value("deleted")
        );
    }
}
