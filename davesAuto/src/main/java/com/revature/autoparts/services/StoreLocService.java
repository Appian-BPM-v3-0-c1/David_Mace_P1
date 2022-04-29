package com.revature.autoparts.services;

import com.revature.autoparts.daos.StoreLocDAO;
import com.revature.autoparts.daos.UserDAO;

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
