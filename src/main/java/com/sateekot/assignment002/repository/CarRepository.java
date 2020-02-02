package com.sateekot.assignment002.repository;

import com.sateekot.assignment002.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository with all JPA operations.
 */
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

}
