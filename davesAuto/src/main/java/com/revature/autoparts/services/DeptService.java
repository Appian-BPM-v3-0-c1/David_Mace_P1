package com.revature.autoparts.services;

import com.revature.autoparts.daos.DeptDAO;
import com.revature.autoparts.daos.ItemDAO;

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