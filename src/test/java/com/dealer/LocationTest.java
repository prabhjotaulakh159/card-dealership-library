package com.dealer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.models.Location;
import com.dealer.models.cars.Car;
import com.dealer.models.people.Employee;

/**
 * Test class for location
 * @author Prabhjot Aulakh, Safin Haque
 */
@SuppressWarnings("unused")
public class LocationTest {
    @Test
    public void constructor_no_error() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_address() {
        Location location = new Location(null, "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_address() {
        Location location = new Location("", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_branch() {
        Location location = new Location("123 Brossard Street", null, new ArrayList<Car>(), new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void empty_branch() {
        Location location = new Location("123 Brossard Street", "", new ArrayList<Car>(), new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_cars() {
        Location location = new Location("123 Brossard Street", "Brossard Branch", null, new ArrayList<Employee>());
    }

    @Test(expected = IllegalArgumentException.class)
    public void null_employees() {
        Location location = new Location("123 Brossard Street", "Brossard Branch", new ArrayList<Car>(), null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_null_address() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setAddress(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_empty_address() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setAddress("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_null_branch() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setBranch(null);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void setter_empty_branch() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setBranch("");
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_null_cars() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setCars(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setter_null_employees() {
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", new ArrayList<Car>(), new ArrayList<Employee>());
        location.setEmployees(null);
    } 

    @Test
    public void getters() {
        List<Car> cars = new ArrayList<Car>();
        List<Employee> employees = new ArrayList<Employee>();
        Location location = new Location("123 Brossard Street, Brossard", "Brossard Branch", cars, employees);
        assertEquals("123 Brossard Street, Brossard", location.getAddress());
        assertEquals("Brossard Branch", location.getBranch());
        assertEquals(cars, location.getCars());
        assertEquals(employees, location.getEmployees());
    }
    
    @Test
    public void isEqual() {
        List<Car> cars = new ArrayList<Car>();
        List<Employee> employees = new ArrayList<Employee>();
        Location location1 = new Location("123 Brossard Street, Brossard", "Brossard Branch", cars, employees);
        Location location2 = new Location("123 Brossard Street, Brossard", "Brossard Branch", cars, employees);
        assertTrue(location1.equals(location2));
    }
}
