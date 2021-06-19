package com.ani.rest.restdemos.controller;

import com.ani.rest.restdemos.domain.Device;
import com.ani.rest.restdemos.response.AppRes;
import com.ani.rest.restdemos.service.DeviceService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor
@RequestMapping(value = "/device")
@RestController
public class DeviceController {

    // TDD - Test Driven Development

    private final DeviceService service; // constructor injection

    @PostMapping  // http://localhost:8080/device/ -> POST
    public AppRes save(
            @Valid @RequestBody Device device
    ){
        service.saveDevice(device);
        return new AppRes("device added to channel", "success");
    }

    @GetMapping // http://localhost:8080/device/ -> GET
    public List<Device> all() {
        return service.all();
    }

    /*@ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }*/
}
