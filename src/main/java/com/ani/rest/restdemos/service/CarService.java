package com.ani.rest.restdemos.service;

import com.ani.rest.restdemos.domain.Car;
import com.ani.rest.restdemos.repository.FsDAO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@ImportResource("classpath:beans.xml") // recommended way to import bean definitions
public class CarService {

    @Autowired // demanding bean
    private Car car;

    @Autowired
    private FsDAO fsRepository;

    @Autowired
    private String str;

    public void checkCar() {
        log.info(car.toString());
        log.info("String is "+str);
    }
}
