package com.ani.rest.restdemos.dto;

import com.ani.rest.restdemos.domain.Car;
import com.ani.rest.restdemos.domain.Device;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CarDevice {
    private Car car;
    private Device device;
}
