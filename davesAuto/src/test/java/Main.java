import connection.DatabaseConnection;
import daos.StoreLocDAO;
import daos.UserDAO;
import models.StoreLoc;
import models.User;
import services.StoreLocService;
import ui.MainMenu;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Connection con = DatabaseConnection.getCon();
        System.out.println(con);

        new MainMenu(new User(), new StoreLoc(), new StoreLocService(new StoreLocDAO(), new UserDAO())).start();
    }
}
