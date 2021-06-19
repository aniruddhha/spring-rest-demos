package com.ani.rest.restdemos.repository;

import com.ani.rest.restdemos.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceRepository extends JpaRepository<Device, Long> {
}
