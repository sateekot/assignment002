package com.sateekot.assignment002.controller;

import com.sateekot.assignment002.exception.BusinessServiceException;
import com.sateekot.assignment002.model.CarDetailsRequest;
import com.sateekot.assignment002.service.CarInventoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * CarInventoryController is a controller which exposes endpoints to add/search Cars from/in the inventory.
 */
@RestController
public class CarInventoryController {
    private static final Logger LOGGER = LoggerFactory.getLogger(CarInventoryController.class);

    @Autowired
    private CarInventoryService carInventoryService;

    @RequestMapping(path = "/insert", method = RequestMethod.POST)
    public String addCar(@RequestBody CarDetailsRequest carDetailsRequest) {
        LOGGER.info("Request received to add new car into inventory.");
        return carInventoryService.addCar(carDetailsRequest);
    }

    @RequestMapping(path = "/search", method = RequestMethod.GET)
    public CarDetailsRequest search(@RequestParam("Id") Integer carId) throws BusinessServiceException {
        LOGGER.info("Request received to get car details with id={}",carId);
        CarDetailsRequest carDetailsRequest = carInventoryService.search(carId);
        if(carDetailsRequest == null) {
          throw new BusinessServiceException("Car not found with id="+carId);
        } else {
            return carDetailsRequest;
        }
    }

    @RequestMapping(path = "/list", method = RequestMethod.GET)
    public List<CarDetailsRequest> list() {
        LOGGER.info("Received request to get all the cars information.");
        return carInventoryService.list();
    }
}
