package com.dealer.data.filters.impl;

import com.dealer.data.filters.VariousFilters;
import com.dealer.models.cars.Car;

import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;

public class CarLessThanPriceFilter extends VariousFilters implements ICarFilter {
    private int price;

    public CarLessThanPriceFilter(ListFilter filter, int price){
      super(filter);
      if(price<=0){
        throw new IllegalArgumentException("orice is negative or zero");
      }
      this.price=price;
    }

     public List<Car> filterCars(List<Car> cars){

      for(int i=0;i<cars.size();i++){
        if(!(super.lessThan() && cars.get(i).getPrice() < this.price)){
          cars.remove(i);
          i--;
        }
      }
      return cars;
    }
}
