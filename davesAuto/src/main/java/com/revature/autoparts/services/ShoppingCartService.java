package com.revature.autoparts.services;

import com.revature.autoparts.daos.ItemDAO;
import com.revature.autoparts.daos.ShoppingCartDAO;

public class ShoppingCartService {
    private final ShoppingCartDAO shoppingCartDAO;
    private final ItemDAO itemDAO;

    public ShoppingCartService(ShoppingCartDAO shoppingCartDAO, ItemDAO itemDAO) {
        this.shoppingCartDAO = shoppingCartDAO;
        this.itemDAO = itemDAO;
    }


    public ShoppingCartDAO getShoppingCartDAO() {
        return shoppingCartDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

}
