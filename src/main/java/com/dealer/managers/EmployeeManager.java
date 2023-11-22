package com.dealer.managers;

import com.dealer.data.loaders.IDataLoader;

/**
 * Manager class for employees
 */
public class EmployeeManager extends AbstractManager {
    public EmployeeManager(IDataLoader dataLoader) {
        super(dataLoader);
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }
}
