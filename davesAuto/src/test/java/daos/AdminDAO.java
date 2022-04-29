package daos;


import models.Admin;

import java.util.List;

public class AdminDAO implements CrudDAO<Admin> {
    @Override
    public int save(Admin obj) {
        return 0;
    }

    @Override
    public List<Admin> findAll() {
        return null;
    }

    @Override
    public Admin findById(int id) {
        return null;
    }

    @Override
    public List<Admin> findAllById() {
        return null;
    }

    @Override
    public boolean update(Admin updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }
}