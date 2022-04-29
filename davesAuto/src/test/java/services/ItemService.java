package services;

import daos.DeptDAO;
import daos.ItemDAO;

public class ItemService {
    private final ItemDAO itemDAO;
    private final DeptDAO deptDAO;

    public ItemService(ItemDAO itemDAO, DeptDAO deptDAO) {
        this.itemDAO = itemDAO;
        this.deptDAO = deptDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

    public DeptDAO getDeptDAO() {
        return deptDAO;

    }


}
