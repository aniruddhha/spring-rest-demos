package com.ani.rest.restdemos;

import com.ani.rest.restdemos.domain.Car;
import com.ani.rest.restdemos.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


// write test case for every single class ( every single line)
@SpringBootApplication
public class RestDemosApplication {

	public static void main(String[] args) {

		final Logger logger = LoggerFactory.getLogger(RestDemosApplication.class);

		ApplicationContext ctx = SpringApplication.run(RestDemosApplication.class, args);
		CarService service = ctx.getBean(CarService.class);
		service.checkCar();

		ApplicationContext context =  new ClassPathXmlApplicationContext("beans.xml");
		Car car = context.getBean(Car.class);
		logger.info("Car Created as below");
		System.out.println(car.toString());
	}
}
