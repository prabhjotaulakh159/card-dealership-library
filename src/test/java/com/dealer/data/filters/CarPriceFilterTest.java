package com.dealer.data.filters;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.dealer.data.filters.impl.CarPricesFilter;
import com.dealer.models.cars.Car;

public class CarPriceFilterTest {
  

  @Test
  public void constructor_works(){
    CarPricesFilter filter = new CarPricesFilter(ListFilter.EQUALS, 50000);
  }

  @Test(expected = IllegalArgumentException.class)
  public void constructor_price_invalid(){
    CarPricesFilter filter = new CarPricesFilter(ListFilter.EQUALS, -50000);
  }

  @Test
  public void filter_is_equal_to_price(){
    List<Car> cars = new ArrayList<Car>();
    CarPricesFilter filter = new CarPricesFilter(ListFilter.EQUALS, 20000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 20000));

    List<Car> filteredCars = filter.filterCars(cars);
    
    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(0).getPrice(), filteredCars.get(0).getPrice());
    assertEquals(cars.get(2).getPrice(), filteredCars.get(1).getPrice());
  }

  @Test
  public void filter_is_greaterthan(){
    List<Car> cars = new ArrayList<Car>();
    CarPricesFilter filter = new CarPricesFilter(ListFilter.GREATERTHAN, 20000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(1).getPrice(), filteredCars.get(0).getPrice());
    assertEquals(cars.get(2).getPrice(), filteredCars.get(1).getPrice());

  }

  @Test
  public void filter_is_greatherthanEqualsTo(){
    List<Car> cars = new ArrayList<Car>();
    CarPricesFilter filter = new CarPricesFilter(ListFilter.GREATEREQUALS, 20000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
     cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(3,filteredCars.size());
    assertEquals(cars.get(0).getPrice(), filteredCars.get(0).getPrice());
    assertEquals(cars.get(1).getPrice(), filteredCars.get(1).getPrice());
    assertEquals(cars.get(2).getPrice(), filteredCars.get(2).getPrice());
  }

  @Test
  public void filter_is_lessThan(){
     List<Car> cars = new ArrayList<Car>();
    CarPricesFilter filter = new CarPricesFilter(ListFilter.LESSTHAN, 20000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
    cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(1,filteredCars.size());
    assertEquals(cars.get(3).getPrice(), filteredCars.get(0).getPrice());
  }

  @Test
  public void filter_is_lessThanEqualsTo(){
     List<Car> cars = new ArrayList<Car>();
    CarPricesFilter filter = new CarPricesFilter(ListFilter.LESSEQUALS, 20000);
    cars.add(new Car("Toyota", 2005, "orange", 20000));
    cars.add(new Car("Mazda", 2007, "orange", 35000));
    cars.add(new Car("Mitsubishi", 2000, "orange", 40000));
    cars.add(new Car("Mitsubishi", 1999, "orange", 15000));

    List<Car> filteredCars = filter.filterCars(cars);

    assertEquals(2,filteredCars.size());
    assertEquals(cars.get(3).getPrice(), filteredCars.get(1).getPrice());
    assertEquals(cars.get(0).getPrice(), filteredCars.get(0).getPrice());
  }
}
