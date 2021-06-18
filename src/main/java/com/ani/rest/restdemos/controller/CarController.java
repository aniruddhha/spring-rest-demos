package com.ani.rest.restdemos.controller;

import com.ani.rest.restdemos.domain.Car;
import com.ani.rest.restdemos.response.AppRes;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/car")
public class CarController {

    @PostMapping // saving new car
    public AppRes save(@RequestBody Car car) {
        return new AppRes("Car Saved", "success");
    }

    @GetMapping("/{carId}") // getting car by id - path variable
    public Car findOne(@PathVariable Integer carId) {
        return new Car("abc", 45d);
    }

    @PutMapping // updating car
    public AppRes update(@RequestBody Car car) {
        return new AppRes("Car Updated", "success");
    }

    @DeleteMapping // deleting car by id - query params
    public AppRes delete(@RequestParam Integer carId) {
        return new AppRes("Car Deleted", "deleted");
    }

    @GetMapping // fetching all cars
    public List<Car> findAll() {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hh", 78d));
        return cars;
    }
}
