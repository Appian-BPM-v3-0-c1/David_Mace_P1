package com.revature.autoparts.daos;

import com.revature.autoparts.connection.DatabaseConnection;
import com.revature.autoparts.models.ShoppingCart;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartDAO implements CrudDAO<ShoppingCart> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(ShoppingCart obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO shopping_cart (quantity, item_id, customer_id) VALUES (?, ?, ?)");
            ps.setInt(1, obj.getQuantity());
            ps.setInt(2, obj.getItem_id());
            ps.setInt(3, obj.getCustomer_id());

            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }

    @Override
    public List<ShoppingCart> findAll() {
        return null;
    }


    @Override
    public ShoppingCart findById(int id) {
        return null;
    }

    @Override
    public List<ShoppingCart> findAllById() {
        return null;
    }

    @Override
    public boolean update(ShoppingCart updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(int id) {

        try {
            PreparedStatement ps = con.prepareStatement("DELETE FROM shopping_cart WHERE customer_id = ?");
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<ShoppingCart> findByID(int id) {
        List<ShoppingCart> scList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM shopping_cart WHERE customer_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                ShoppingCart cart = new ShoppingCart();

                cart.setId(rs.getInt("id"));
                cart.setQuantity(rs.getInt("quantity"));
                cart.setItem_id(rs.getInt("item_id"));
                cart.setCustomer_id(rs.getInt("customer_id"));

                scList.add(cart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return scList;
    }

}
