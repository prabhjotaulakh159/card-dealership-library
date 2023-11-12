package com.dealer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Date;

import com.dealer.models.Appointment;
import com.dealer.models.Location;
import com.dealer.models.cars.Car;
import com.dealer.models.people.Customer;
import com.dealer.models.people.Employee;

import org.junit.Test;

@SuppressWarnings("unused")
public class AppointmentTest {
 @Test
  public void constructor_no_errors(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_null_employee(){
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
     Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(null, c1, l1, date );
  }
  @Test(expected = IllegalArgumentException.class)
  public void constructor_null_location(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
     Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, null, date );
  }
  @Test(expected = IllegalArgumentException.class)
  public void constructor_null_customer(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
     Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, null, l1, date );
  }
  @Test(expected = IllegalArgumentException.class)
  public void constructor_null_date(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Appointment appointment= new Appointment(null, c1, l1, null );
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_invalid_month(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 15, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_invalid_day(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 6, 45);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_null_employee(){
     Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setEmployee(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_null_customer(){
     Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setCustomer(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_null_location(){
     Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setLocation(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_null_date(){
     Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setDate(null);
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_invalid_month(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setDate(new Date(2023, 20, 15));
  }

  @Test(expected = IllegalArgumentException.class)
  public void setter_invalid_day(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );
    appointment.setDate(new Date(2023, 7, 60));
  }

  @Test(expected = IllegalArgumentException.class)
  public void appointment_getters(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment= new Appointment(ep1, c1, l1, date );

    assertEquals(new Employee("John", "5145552222", 50000), appointment.getEmployee());
    assertEquals(new Customer("Macy", "4445557777"), appointment.getCustomer());
    assertEquals(new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>()), appointment.getLocation());
    assertEquals( new Date(2023, 5, 14), appointment.getDate());
  }

  @Test(expected = IllegalArgumentException.class)
  public void isEqual(){
    Employee ep1= new Employee("John", "5145552222", 50000);
    Customer c1= new Customer("Macy", "4445557777");
    Location l1= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date= new Date(2023, 5, 14);
    Appointment appointment1= new Appointment(ep1, c1, l1, date );

    Employee ep2= new Employee("John", "5145552222", 50000);
    Customer c2= new Customer("Macy", "4445557777");
    Location l2= new Location("123 avenue", "Tesla", new ArrayList<Car>(), new ArrayList<Employee>());
    Date date2= new Date(2023, 5, 14);
    Appointment appointment2= new Appointment(ep2, c2, l2, date2 );

    assertTrue(appointment1.equals(appointment2));
  }


}
