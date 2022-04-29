package services;

import daos.StoreLocDAO;
import daos.UserDAO;

public class StoreLocService {
    private final StoreLocDAO storeLocDAO;
    private final UserDAO userDAO;

    public StoreLocService(StoreLocDAO storeLocDAO, UserDAO userDAO) {
        this.storeLocDAO = storeLocDAO;
        this.userDAO = userDAO;
    }

    public StoreLocDAO storeLocDAO() {
        return storeLocDAO;
    }

    public UserDAO userDAO() {
        return userDAO;
    }
}
