package com.sateekot.assignment002.service;

import com.sateekot.assignment002.model.Car;
import com.sateekot.assignment002.model.CarDetailsRequest;
import com.sateekot.assignment002.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * CarInventoryServiceImpl provides apis for adding new car, searching for existing car.
 */
@Component
public class CarInventoryServiceImpl implements CarInventoryService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CarInventoryServiceImpl.class);

    @Autowired
    private CarRepository carRepository;

    /**
     * Adds new car to inventory
     * @param carDetailsRequest
     * @return String
     */
    @Override
    public String addCar(CarDetailsRequest carDetailsRequest) {
        try {
            Car car = new Car();
            BeanUtils.copyProperties(carDetailsRequest, car);
            carRepository.save(car);
            LOGGER.info("New car inserted successfully.");
        } catch (Exception ex) {
            LOGGER.error("Exception occurred while inserting new car into database. Exception details = {}",ex.getMessage());
        }
        return "New car successfully added to your inventory!";
    }

    /**
     * Gets car details from inventory
     * @param carId
     * @return Car/null.
     */
    @Override
    public CarDetailsRequest search(Integer carId) {
        try {
            Optional<Car> carDetails = carRepository.findById(carId);
            if(carDetails.isPresent()) {
                CarDetailsRequest carDetailsRequest = new CarDetailsRequest();
                BeanUtils.copyProperties(carDetails.get(), carDetailsRequest);
                return carDetailsRequest;
            }
        } catch(Exception ex) {
            LOGGER.error("Exception occurred while getting car details from database. Exception details = {}",ex.getMessage());
        }
        return null;
    }

    /**
     * Method to get all the cars information.
     * @return List<Car>
     */
    @Override
    public List<CarDetailsRequest> list() {
        List<Car> carList = carRepository.findAll();
        List<CarDetailsRequest> carDetailsRequestList = new ArrayList<>();
        for(int i = 0; i < carList.size(); i++) {
            CarDetailsRequest carDetailsRequest = new CarDetailsRequest();
            BeanUtils.copyProperties(carList.get(i), carDetailsRequest);
            carDetailsRequestList.add(carDetailsRequest);
        }
        return carDetailsRequestList;
    }
}