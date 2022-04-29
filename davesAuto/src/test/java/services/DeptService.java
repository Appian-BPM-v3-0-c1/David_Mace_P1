package services;

import daos.DeptDAO;
import daos.ItemDAO;

public class DeptService {
    private final DeptDAO deptDAO;
    private final ItemDAO itemDAO;

    public DeptService(DeptDAO deptDAO, ItemDAO itemDAO) {
        this.deptDAO = deptDAO;
        this.itemDAO = itemDAO;
    }


    public DeptDAO getDeptDAO() {
        return deptDAO;
    }

    public ItemDAO getItemDAO() {
        return itemDAO;
    }

}