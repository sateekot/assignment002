package com.sateekot.assignment002.service;

import com.sateekot.assignment002.model.Car;
import com.sateekot.assignment002.model.CarDetailsRequest;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * CarInventoryService is a interface with all operations.
 */
@Component
public interface CarInventoryService {
    String addCar(CarDetailsRequest carDetailsRequest);
    CarDetailsRequest search(Integer carId);
    List<CarDetailsRequest> list();

    // Implement in future.
    default boolean updateCar(Car car) {return false; }
}
