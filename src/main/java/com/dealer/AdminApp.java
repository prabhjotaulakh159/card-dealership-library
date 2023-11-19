package com.dealer;

import com.dealer.data.loaders.FileLoader;
import com.dealer.data.loaders.IDataLoader;

public class AdminApp {
    public static void main(String[] args) {
        IDataLoader loader = new FileLoader();
        Manager manager = new Manager(loader);
        manager.runApp();
    }
}
