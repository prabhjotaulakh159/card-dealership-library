package com.dealer;

import com.dealer.data.loaders.OracleLoader;
import com.dealer.managers.AdminManager;
import com.dealer.managers.AbstractManager;

public class AdminApp {
    public static void main(String[] args) {
        AbstractManager app = new AdminManager(new OracleLoader());
        app.run();
    }
}
