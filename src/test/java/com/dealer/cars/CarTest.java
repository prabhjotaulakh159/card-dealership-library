package com.dealer.cars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Test;

import com.dealer.models.Location;
import com.dealer.models.Promotion;
import com.dealer.models.cars.Car;

/**
 * Test class for Car
 * @author Prabhjot Aulakh, Safin Haque
 */
@SuppressWarnings("unused")
public class CarTest {
    @Test
    public void constructor_no_errors() {
        Car car = new Car("model", 2023, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_null_model() {
        Car car = new Car(
            null, 2023, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_empty_model() {
        Car car = new Car(
            "", 2023, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constructor_year_before_1999() {
        Car car = new Car(
            "model", 1998, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constuctor_null_color() {
        Car car = new Car(
            "model", 2023, null, null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constuctor_empty_color() {
        Car car = new Car(
            "model", 2023, "", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constuctor_null_location() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void constuctor_negative_price() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_model_null() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setModel(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_model_empty() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setModel("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_color_null() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setColor(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_color_empty() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setColor("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_price_negative() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setPrice(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_year_before_1999() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setYear(1998);
    }

    @Test
    public void getters() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        assertEquals("model", car.getModel());
        assertEquals(2023, car.getYear());
        assertEquals("orange", car.getColor());
        assertEquals(null, car.getPromotion());
        assertEquals(1000, car.getPrice());
    }

    @Test
    public void setters() {
        Car car = new Car(
            "model", 2023, "orange", null, 1000);
        car.setModel("new");
        car.setYear(2025);
        car.setColor("red");
        car.setPromotion(null);
        car.setPrice(2000);
    }

    @Test 
    public void isEqual() {
        Car car1 = new Car(
            "model", 2023, "orange", null, 1000);
        Car car2 = new Car(
            "model", 2023, "orange", null, 1000);
        assertTrue(car1.equals(car2));
    }

    @Test 
    public void notEqual() {
        Car car1 = new Car(
            "Mazda", 2023, "orange", null, 1000);
        Car car2 = new Car(
            "model", 2023, "orange", null, 1000);
        assertTrue(car1.equals(car2));
    }
}
