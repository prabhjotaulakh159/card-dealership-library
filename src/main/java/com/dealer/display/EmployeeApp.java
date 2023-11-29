package com.dealer.display;

import com.dealer.business.EmployeeManager;
import com.dealer.business.Manager;
import com.dealer.data.Source;

public class EmployeeApp {
    public static void main(String[] args) {
        Manager app = new EmployeeManager(Source.CSV);
        app.run();
    }
}
