package com.sateekot.assignment002.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @author SateeshKumar Kota
 * @date 02-02-2020
 * Entity class.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Car implements Serializable {
    @Id
    private Integer carId;
    private String modelName;
    private Integer manufactureYear;
    private Double price;
}
