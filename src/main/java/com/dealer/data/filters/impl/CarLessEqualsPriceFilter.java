package com.dealer.data.filters.impl;

import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.VariousFilters;
import com.dealer.models.cars.Car;

public class CarLessEqualsPriceFilter extends VariousFilters implements ICarFilter{
    private int price;

    public CarLessEqualsPriceFilter(ListFilter filter, int price){
      super(filter);
      if(price<=0){
        throw new IllegalArgumentException("price is megative or zero");
      }
      this.price = price;
    }

    public List<Car> filterCars(List<Car> cars){

      for(int i=0;i<cars.size();i++){
        if(!(super.lessThanEqualsTo() && cars.get(i).getPrice() >= this.price)){
          cars.remove(i);
          i--;
        }
      }
      return cars;
    }
}
