package daos;

import connection.DatabaseConnection;
import models.Item;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemDAO implements CrudDAO<Item> {
    Connection con = DatabaseConnection.getCon();
    @Override
    public int save(Item obj) {
        return 0;
    }

    @Override
    public List<Item> findAll() {
        List<Item> itemList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Item item = new Item();

                item.setId(rs.getInt("id"));
                item.setItemName(rs.getString("name"));
                item.setStock(rs.getInt("stock"));
                item.setItemPrice(rs.getFloat("item_price"));
                item.setDeptId(rs.getInt("dept_id"));
                item.setquantity(rs.getInt("quantity"));

                itemList.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itemList;
    }

    @Override
    public Item findById(int id) {
        Item item = new Item();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE id = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                item.setId(rs.getInt("id"));
                item.setItemName(rs.getString("name"));
                item.setStock(rs.getInt("stock"));
                item.setDeptId(rs.getInt("dept_id"));
                item.setquantity(rs.getInt("quantity"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public List<Item> findAllById() {
        return null;
    }

    @Override
    public boolean update(Item updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<Item> findByName(String itemName) {
        List<Item> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE name LIKE ?");
            ps.setString(1, "%" + itemName + "%");

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Item item = new Item();

                item.setItemName(rs.getString("name"));
                item.setStock(rs.getInt("stock"));
                item.setItemPrice(rs.getFloat("item_price"));
                item.setDeptId(rs.getInt("dept_id"));
                item.setquantity(rs.getInt("quantity"));

                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public List<Item> viewByDept(int dept_Id) {
        List<Item> items = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM items WHERE dept_id = ?");
            ps.setInt(1,dept_Id);


            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Item item = new Item();

                item.setItemName(rs.getString("name"));
                item.setStock(rs.getInt("stock"));
                item.setItemPrice(rs.getFloat("item_price"));
                item.setDeptId(rs.getInt("dept_id"));
                item.setquantity(rs.getInt("quantity"));

                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return items;
    }

    public boolean removeById(int id, int stock) {
        Item item = new Item();

        try {
            PreparedStatement ps = con.prepareStatement("UPDATE items SET stock = stock - ? WHERE id = ?");
            ps.setInt(1, stock);
            ps.setInt(2, id);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }


}
