package com.dealer.data.filters.impl;

import com.dealer.data.filters.ListFilter;
import com.dealer.models.cars.Car;

import java.util.List;

import com.dealer.data.filters.VariousFilters;
import com.dealer.data.filters.ICarFilter;

public class CarGreaterThanPriceFilter extends VariousFilters implements ICarFilter {
      private int price;

  public CarGreaterThanPriceFilter(ListFilter filter, int price){
      super(filter);
      if(price <= 0){
        throw new IllegalArgumentException("Price is negative or Zero");
      }
      this.price=price;
  }

    public List<Car> filterCars(List<Car> cars){

      for(int i=0;i<cars.size();i++){
        if(!(super.greaterThan() && cars.get(i).getPrice() > this.price)){
          cars.remove(i);
          i--;
        }
      }
      return cars;
    }
}
