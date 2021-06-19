package com.ani.rest.restdemos.service;

import com.ani.rest.restdemos.domain.Device;
import com.ani.rest.restdemos.repository.DeviceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class DeviceService {

    private final DeviceRepository repository;

    public void saveDevice(Device device) {
        repository.save(device);
    }

    public List<Device> all() {
        return repository.findAll();
    }
}
