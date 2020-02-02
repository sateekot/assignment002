package com.sateekot.assignment002.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * DTO to hold request details.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarDetailsRequest {
    private Integer carId;
    private String modelName;
    private Integer manufactureYear;
    private Double price;
}
