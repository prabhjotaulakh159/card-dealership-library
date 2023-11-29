package com.dealer.data.sorters.impl;

import com.dealer.data.models.cars.Car;
import com.dealer.data.models.cars.ElectricCar;
import com.dealer.data.sorters.AbstractCarSorter;
import com.dealer.data.sorters.Order;

/**
 * Sorts electric cars by charger type 
 * @author Prabhjot Aulakh, Safin Haque
 */
public class CarChargerTypeSorter extends AbstractCarSorter {
    /**
     * Constructor
     * @param order Ascending or descending order for sorting
     */
    public CarChargerTypeSorter(Order order) {
        super(order);
    }

    @Override
    public int compare(Car o1, Car o2) {
        ElectricCar ec1 = (ElectricCar) o1;
        ElectricCar ec2 = (ElectricCar) o2;
        return super.isAscending() ? ec1.getChargerType().compareToIgnoreCase(ec2.getChargerType()) : ec2.getChargerType().compareToIgnoreCase(ec1.getChargerType());
    }
}
