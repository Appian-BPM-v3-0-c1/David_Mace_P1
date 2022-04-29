package com.revature.autoparts;

import com.revature.autoparts.connection.DatabaseConnection;
import com.revature.autoparts.daos.StoreLocDAO;
import com.revature.autoparts.daos.UserDAO;
import com.revature.autoparts.models.StoreLoc;
import com.revature.autoparts.models.User;
import com.revature.autoparts.services.StoreLocService;
import com.revature.autoparts.services.UserService;
import com.revature.autoparts.ui.MainMenu;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = DatabaseConnection.getCon();
        System.out.println(con);

        new MainMenu(new User(), new StoreLoc(), new StoreLocService(new StoreLocDAO(), new UserDAO())).start();
    }
}
