package com.dealer.data.sorters.impl;

import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.ElectricCar;

/**
 * Sorts electric cars by voltage
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarVoltageSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarVoltageSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        ElectricCar e1 = (ElectricCar) o1;
        ElectricCar e2 = (ElectricCar) o2;
        return super.isAscending() ? e1.getVoltage() - e2.getVoltage() : e2.getVoltage() - e1.getVoltage();
    }
}
