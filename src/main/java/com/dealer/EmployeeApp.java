package com.dealer;

import com.dealer.data.loaders.FileLoader;
import com.dealer.managers.AbstractManager;
import com.dealer.managers.EmployeeManager;

public class EmployeeApp {
    public static void main(String[] args) {
        AbstractManager app = new EmployeeManager(new FileLoader());
        app.run();
    }
}