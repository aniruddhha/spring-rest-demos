package com.ani.rest.restdemos.controller;

import com.ani.rest.restdemos.domain.Car;
import com.ani.rest.restdemos.dto.CarDevice;
import com.ani.rest.restdemos.response.AppRes;
import com.ani.rest.restdemos.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping // saving new car
    public AppRes save(@RequestBody Car car) {
        return new AppRes("Car Saved", "success");
    }

    @GetMapping("/{carId}") // getting car by id - path variable
    public Car findOne(@PathVariable Integer carId) {
        return new Car("abc", 45d);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE, //what kind of data I accept
            produces = MediaType.APPLICATION_JSON_VALUE // what kind of data I return
    ) // updating car
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

    @RequestMapping(value = "/all/{letter}", method = RequestMethod.GET) // fetching all cars - https://domain.com/api/car/all/a - good
    public List<Car> findAllCarsByFirstLetter(@PathVariable String letter) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("hh", 78d));
        return cars;
    }

    @PostMapping("/mixed")
    public void cardDevice(@RequestBody CarDevice cd) {
        log.info(cd.toString());
    }
}
