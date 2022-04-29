package daos;



import connection.DatabaseConnection;
import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements CrudDAO<User> {
    Connection con = DatabaseConnection.getCon();


    @Override
    public int save(User obj) {
        int n = 0;

        try {
            PreparedStatement ps = con.prepareStatement("INSERT INTO users (username, firstName, lastName, emailAddress, password, store_loc) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setString(1, obj.getUsername());
            ps.setString(2, obj.getFirstName());
            ps.setString(3, obj.getLastName());
            ps.setString(4, obj.getEmailAddress());
            ps.setString(5, obj.getPassword());
            ps.setInt(6, obj.getStoreLocId());

            n = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return n;
    }

    @Override
    public List<User> findAll() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setPassword(rs.getString("password"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setStoreLocId(rs.getInt("store_loc"));


                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


    @Override
    public User findById(int id) {
        User user = new User();
        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE id = ?");
            ps.setInt(1,id);

            ResultSet rs = ps.executeQuery();


            while(rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setPassword(rs.getString("password"));
                user.setStoreLocId(rs.getInt("store_loc"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public List<User> findAllById() {
        return null;
    }


    @Override
    public boolean update(User updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {

        return false;
    }

    public List<String> findAllUsernames() {
        List<String> username_list = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (username) FROM users");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                username_list.add(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return username_list;
    }

    public int getUserId(String username) {
        int id = 0;

        try {
            PreparedStatement ps = con.prepareStatement("SELECT (id) FROM users WHERE username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }


    public List<User> findByName(String username) {
        List<User> users = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE username LIKE ?");
            ps.setString(1, "%" + username + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setPassword(rs.getString("password"));
                user.setStoreLocId(rs.getInt("store_loc"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }


    public List<User> findByFirst(String firstName) {
        List<User> users = new ArrayList<>();


        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE firstName LIKE (?)");
            ps.setString(1, "%" + firstName + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setPassword(rs.getString("password"));
                user.setStoreLocId(rs.getInt("store_loc"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    public List<User> findByLast(String lastName) {
        List<User> users = new ArrayList<>();


        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM users WHERE lastName LIKE (?)");
            ps.setString(1, "%" + lastName + "%");

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmailAddress(rs.getString("emailAddress"));
                user.setPassword(rs.getString("password"));
                user.setStoreLocId(rs.getInt("store_loc"));

                users.add(user);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

}