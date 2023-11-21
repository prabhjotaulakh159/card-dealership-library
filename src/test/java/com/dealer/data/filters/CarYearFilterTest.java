package com.dealer.data.filters;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CarYearFilter;
import com.dealer.models.cars.Car;

@SuppressWarnings("unused")
public class CarYearFilterTest {

  @Test
  public void constructor_works(){
    CarYearFilter filter= new CarYearFilter(ListFilter.EQUALS, 2000);
  }

   @Test(expected = IllegalArgumentException.class)
  public void constructor_price_invalid(){
    CarYearFilter filter = new CarYearFilter(ListFilter.EQUALS, 1995);
  }

  @Test
  public void filter_is_equal_to_price(){
    List<Car> cars = new ArrayList<Car>();
    CarYearFilter filter = new CarYearFilter(ListFilter.EQUALS, 2005);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2005, "orange", 20000));

    List<Car> filteredCars = filter.filterCars(cars);
    
    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(0).getYear(), filteredCars.get(0).getYear());
    assertEquals(cars.get(2).getYear(), filteredCars.get(1).getYear());
  }

  @Test
  public void filter_is_greaterthan(){
    List<Car> cars = new ArrayList<Car>();
    CarYearFilter filter = new CarYearFilter(ListFilter.GREATERTHAN, 2000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(0).getYear(), filteredCars.get(0).getYear());
    assertEquals(cars.get(1).getYear(), filteredCars.get(1).getYear());

  }

  @Test
  public void filter_is_greatherthanEqualsTo(){
    List<Car> cars = new ArrayList<Car>();
    CarYearFilter filter = new CarYearFilter(ListFilter.GREATEREQUALS, 2000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
     cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(3,filteredCars.size());
    assertEquals(cars.get(0).getYear(), filteredCars.get(0).getYear());
    assertEquals(cars.get(1).getYear(), filteredCars.get(1).getYear());
    assertEquals(cars.get(2).getYear(), filteredCars.get(2).getYear());
  }

  @Test
  public void filter_is_lessThan(){
     List<Car> cars = new ArrayList<Car>();
    CarYearFilter filter = new CarYearFilter(ListFilter.LESSTHAN, 2005);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
    cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(2).getYear(), filteredCars.get(0).getYear());
    assertEquals(cars.get(3).getYear(), filteredCars.get(1).getYear());
  }

  @Test
  public void filter_is_lessThanEqualsTo(){
     List<Car> cars = new ArrayList<Car>();
    CarYearFilter filter = new CarYearFilter(ListFilter.LESSEQUALS, 2000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
    cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(2).getYear(), filteredCars.get(0).getYear());
    assertEquals(cars.get(3).getYear(), filteredCars.get(1).getYear());
  }

  
}
