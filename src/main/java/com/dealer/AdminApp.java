package com.dealer;

import com.dealer.data.loaders.FileLoader;

public class AdminApp {
    public static void main(String[] args) {
        Manager manager = new Manager(new FileLoader());
        manager.run();
    }
}
