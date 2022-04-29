package daos;

import connection.DatabaseConnection;
import models.OrderHistory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderHistoryDAO implements CrudDAO<OrderHistory> {
    Connection con = DatabaseConnection.getCon();

    @Override

    public int save(OrderHistory obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO order_history (date, customer_id, item_id, shop_loc) VALUES (?, ?, ?, ?)");
            ps.setString(1, obj.getDate());
            ps.setInt(2, obj.getCustomer_id());
            ps.setInt(3, obj.getItem_id());
            ps.setInt(4, obj.getShop_Loc());


            n = ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return n;
    }


    @Override
    public List<OrderHistory> findAll() {
        return null;
    }

    @Override
    public OrderHistory findById(int id) {

        return null;
    }

    @Override
    public List<OrderHistory> findAllById() {
        return null;
    }

    public List<OrderHistory> findByOHID(int id) {
        List<OrderHistory> ohList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM order_history WHERE customer_id = ?");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setId(rs.getInt("id"));
                orderHistory.setDate(rs.getString("date"));
                orderHistory.setCustomer_id(rs.getInt("customer_id"));
                orderHistory.setItem_id(rs.getInt("item_id"));
                orderHistory.setShop_Loc(rs.getInt("shop_loc"));

                ohList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ohList;
    }

    @Override
    public boolean update(OrderHistory updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<OrderHistory> findByDateAsc() {
        List<OrderHistory> ascList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM order_history ORDER BY date ASC");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setId(rs.getInt("id"));
                orderHistory.setShop_Loc(rs.getInt("shop_loc"));
                orderHistory.setDate(rs.getString("date"));
                orderHistory.setCustomer_id(rs.getInt("customer_id"));
                orderHistory.setItem_id(rs.getInt("item_id"));

                ascList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ascList;
    }

    public List<OrderHistory> findByDateDesc() {
        List<OrderHistory> descList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM order_history ORDER BY date DESC");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setId(rs.getInt("id"));
                orderHistory.setShop_Loc(rs.getInt("shop_loc"));
                orderHistory.setDate(rs.getString("date"));
                orderHistory.setCustomer_id(rs.getInt("customer_id"));
                orderHistory.setItem_id(rs.getInt("item_id"));

                descList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return descList;
    }

    public List<OrderHistory> findByStoreLoc(int store_loc) {
       List<OrderHistory> locList = new ArrayList<>();


        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM order_history WHERE shop_loc = ?");
            ps.setInt(1, store_loc);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderHistory orderHistory = new OrderHistory();

                orderHistory.setId(rs.getInt("id"));
                orderHistory.setDate(rs.getString("date"));
                orderHistory.setCustomer_id(rs.getInt("customer_id"));
                orderHistory.setItem_id(rs.getInt("item_id"));
                orderHistory.setShop_Loc(rs.getInt("shop_loc"));

                locList.add(orderHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locList;
    }

}