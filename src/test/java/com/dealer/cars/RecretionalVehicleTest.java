package com.dealer.cars;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Test class for RecretionalVehicle
 * @author Prabhjot Aulakh, Safin Haque
 */
@SuppressWarnings("unused")
public class RecretionalVehicleTest {
    @Test
    public void constructor_no_errors() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
    }

    @Test
    public void constructor_empty_model() {
        Car car = new RecreationalVehicle("", 2023, "orange", 3000, 5, 3, true);
    }

    @Test
    public void constructor_blank_model() {
        Car car = new RecreationalVehicle("   ", 2023, "orange", 3000, 5, 3, true);
    }

    @Test
    public void constructor_null_model() {
        Car car = new RecreationalVehicle(null, 2023, "orange", 3000, 5, 3, true);
    }

    @Test
    public void constructor_empty_color() {
        Car car = new RecreationalVehicle("model", 2023, "", 3000, 5, 3, true);
    }

    @Test
    public void constructor_blank_color() {
        Car car = new RecreationalVehicle("model", 2023, "   ", 3000, 5, 3, true);
    }

    @Test
    public void constructor_null_color() {
        Car car = new RecreationalVehicle("model", 2023, null, 3000, 5, 3, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_passengers() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, -1, 3, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_passengers() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 0, 3, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void negative_beds() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, -1, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void zero_beds() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 0, true);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_negative_passengers() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        ((RecreationalVehicle)car).setMaxPassengers(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_zero_passengers() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        ((RecreationalVehicle)car).setMaxPassengers(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_negative_beds() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        ((RecreationalVehicle)car).setNumberOfBeds(-1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_zero_beds() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        ((RecreationalVehicle)car).setNumberOfBeds(0);
    }

    @Test
    public void getters() {
        Car car = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        assertEquals(5, ((RecreationalVehicle)car).getMaxPassengers());
        assertEquals(3, ((RecreationalVehicle)car).getNumberOfBeds());
        assertTrue(((RecreationalVehicle)car).isHasKitchen());
    }

    @Test
    public void isEqual() {
        Car car1 = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        Car car2 = new RecreationalVehicle("model", 2023, "orange",  3000, 5, 3, true);
        assertTrue(car1.equals(car2));
    }

    @Test
    public void notEqual() {
        Car car1 = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, true);
        Car car2 = new RecreationalVehicle("model", 2023, "orange", 3000, 5, 3, false);
        assertFalse(car1.equals(car2));
    }
}
