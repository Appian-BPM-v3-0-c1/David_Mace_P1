package services;

import daos.ItemDAO;
import daos.ShoppingCartDAO;

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
