package com.dealer.data.filters.impl;

import java.util.ArrayList;
import java.util.List;

import com.dealer.data.filters.ICarFilter;
import com.dealer.models.cars.Car;
import com.dealer.models.cars.RecreationalVehicle;

/**
 * Implements ICarFilter to filter RV's that have kitchens
 * @author Prabhjot Aulakh, Safin Haque
 */
public class RVKitchenFilter implements ICarFilter {
    private boolean hasKitchen;

    /**
     * Constructor
     * @param hasKitchen Whether or not we want rv's with kitchen
     */
    public RVKitchenFilter(boolean hasKitchen) {
        this.hasKitchen = hasKitchen;
    }

    @Override
    public List<Car> filterCars(List<Car> cars) {
        List<Car> recreationalWithKitchens = new ArrayList<Car>();
        if (this.hasKitchen) {
            for (Car car : cars) {
                RecreationalVehicle rv = (RecreationalVehicle) car;
                if (rv.isHasKitchen()) {
                    recreationalWithKitchens.add(rv);
                }
            }
        } else {
            for (Car car : cars) {
                RecreationalVehicle rv = (RecreationalVehicle) car;
                if (!rv.isHasKitchen()) {
                    recreationalWithKitchens.add(rv);
                }
            }
        }
        return recreationalWithKitchens; 
    }    
} 
