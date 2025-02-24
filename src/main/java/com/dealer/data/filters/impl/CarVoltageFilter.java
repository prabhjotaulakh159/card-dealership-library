package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.data.filters.ListFilter;
import com.dealer.data.filters.NumberFilters;
import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;

/**
 * This class implements the ICarFilter interface to filter cars by voltage
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarVoltageFilter extends NumberFilters implements ICarFilter {
    private int voltage;

    /**
     * Constructor
     * @param filter How we wanna filter the voltage
     * @param voltage The voltage amount to filter cars by
     */
    public CarVoltageFilter(ListFilter filter, int voltage){
        super(filter);
        if (voltage <= 0) {
            throw new IllegalArgumentException("Voltage must be greater than 0");
        }
        this.voltage = voltage;
    }

    @Override
    public List<Car> filterCars(List<Car> cars){
        List<Car> electricCarList= new ArrayList<Car>();
        if (super.equalsTo()) {
            for (Car car : cars){
                if((car instanceof ElectricCar) && ((ElectricCar) car).getVoltage() == this.voltage) {
                    electricCarList.add(car);
                }
            }
        } else if(super.greaterThan()){
            for (Car car : cars){
                if((car instanceof ElectricCar) && ((ElectricCar) car).getVoltage() > this.voltage) {
                    electricCarList.add(car);
                }
            }
        } else if(super.lessThan()){
            for(Car car : cars){
                if((car instanceof ElectricCar) && ((ElectricCar) car).getVoltage() < this.voltage) {
                    electricCarList.add(car);
                }
            }
        } else if(super.greaterThanEqualsTo()){
            for (Car car : cars){
                if((car instanceof ElectricCar) && ((ElectricCar) car).getVoltage() >= this.voltage){
                    electricCarList.add(car);
                }
            }
        } else if(super.lessThanEqualsTo()){
            for(Car car : cars){
                if((car instanceof ElectricCar) && ((ElectricCar) car).getVoltage() <= this.voltage){
                    electricCarList.add(car);
                }
            }
        }
        return electricCarList;
    }
}
