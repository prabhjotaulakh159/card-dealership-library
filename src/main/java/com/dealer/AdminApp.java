package com.dealer;

import com.dealer.data.loaders.FileLoader;
import com.dealer.managers.AdminManager;
import com.dealer.managers.Manager;

public class AdminApp {
    public static void main(String[] args) {
        Manager admin = new AdminManager(new FileLoader());
        admin.run();
    }
}
