package com.sateekot.assignment002.service;

import com.sateekot.assignment002.model.CarDetailsRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020.
 * Test class.
 */
@SpringBootTest
public class CarInventoryServiceImplTest {

    @Autowired
    private CarInventoryService carInventoryService;

    @Test
    public void testInsert() {
        CarDetailsRequest carDetailsRequest = new CarDetailsRequest(111, "Volvo", 2020, 50000.0);
        String result = carInventoryService.addCar(carDetailsRequest);
        assertEquals("New car successfully added to your inventory!", result);
    }

    @Test
    public void testSearch() {
        CarDetailsRequest carDetailsRequest = new CarDetailsRequest(111, "Volvo", 2020, 50000.0);
        carInventoryService.addCar(carDetailsRequest);
        CarDetailsRequest carDetailsFromDB = carInventoryService.search(111);
        assertEquals("Volvo",carDetailsFromDB.getModelName());
    }

    @Test
    public void testList() {
        CarDetailsRequest carDetailsRequest = new CarDetailsRequest(111, "Volvo", 2020, 50000.0);
        carInventoryService.addCar(carDetailsRequest);
        CarDetailsRequest carDetailsRequest1 = new CarDetailsRequest(112, "BMW", 2020, 40000.0);
        carInventoryService.addCar(carDetailsRequest1);

        List<CarDetailsRequest> carDetailsRequestList = carInventoryService.list();
        assertEquals(2, carDetailsRequestList.size());
    }
}
