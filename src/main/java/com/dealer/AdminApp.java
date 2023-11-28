package com.dealer;

import com.dealer.data.loaders.FileLoader;
import com.dealer.managers.AdminManager;
import com.dealer.managers.AbstractManager;

public class AdminApp {
    public static void main(String[] args) {
        AbstractManager app = new AdminManager(new FileLoader());
        app.run();
    }
}
