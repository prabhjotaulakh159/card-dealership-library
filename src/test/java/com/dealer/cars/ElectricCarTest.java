package com.dealer.cars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

/**
 * Test class for ElectricCar
 * @author Prabhjot Aulakh, Safin Haque
 */
@SuppressWarnings("unused")
public class ElectricCarTest {
    @Test
    public void constructor_no_errors() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_voltage() {
        Car car = new ElectricCar("model", 2023, "orange",3000, -1, "USA-23C");  
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_voltage() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 0, "USA-23C");  
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_charger_type() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 0, null);  
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_charger_type() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 0, "");  
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_negative_voltage() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        ((ElectricCar)car).setVoltage(-1); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_zero_voltage() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        ((ElectricCar)car).setVoltage(0); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_null_charger() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        ((ElectricCar)car).setChargerType(null); 
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_empty_charger() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        ((ElectricCar)car).setChargerType(""); 
    }

    @Test
    public void getters() {
        Car car = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        assertEquals(500, ((ElectricCar)car).getVoltage()); 
        assertEquals("USA-23C", ((ElectricCar)car).getChargerType());
    }

    @Test
    public void isEqual() {
        Car car1 = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        Car car2 = new ElectricCar("model", 2023, "orange",  3000, 500, "USA-23C");
        assertTrue(car1.equals(car2));
    }

    @Test
    public void notEqual() {
        Car car1 = new ElectricCar("model", 2023, "orange", 3000, 500, "USA-23C");
        Car car2 = new ElectricCar("model", 2023, "orange", 3000, 300, "USA-23C");
        assertFalse(car1.equals(car2));
    }
}
