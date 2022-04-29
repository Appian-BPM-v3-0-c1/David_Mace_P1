package daos;

import connection.DatabaseConnection;
import models.StoreLoc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StoreLocDAO implements CrudDAO<StoreLoc> {
    Connection con = DatabaseConnection.getCon();

    @Override
    public int save(StoreLoc obj) {
        return 0;
    }

    @Override
    public List<StoreLoc> findAll() {
        List<StoreLoc> locList = new ArrayList<>();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM store_location");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                StoreLoc storeLoc = new StoreLoc();

                storeLoc.setLocId(rs.getInt("locId"));
                storeLoc.setAddress(rs.getString("address"));
                storeLoc.setCity(rs.getString("city"));
                storeLoc.setState(rs.getString("state"));
                storeLoc.setCountry(rs.getString("country"));

                locList.add(storeLoc);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locList;
    }

    @Override
    public StoreLoc findById(int id) {
        return null;
    }

    @Override
    public List<StoreLoc> findAllById() {
        return null;
    }

    @Override
    public boolean update(StoreLoc updatedObj) {
        return false;
    }

    @Override
    public boolean removeById(String id) {
        return false;
    }

    public List<StoreLoc> findByStoreLoc(int locId) {
        List<StoreLoc> locList = new ArrayList();

        try {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM store_location WHERE locId = ?");
            ps.setInt(1, locId);

            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                StoreLoc storeLoc = new StoreLoc();

                storeLoc.setId(rs.getInt("id"));
                storeLoc.setLocId(rs.getInt("locId"));
                storeLoc.setAddress(rs.getString("address"));
                storeLoc.setCity(rs.getString("city"));
                storeLoc.setState(rs.getString("state"));
                storeLoc.setCountry(rs.getString("country"));

                locList.add(storeLoc);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return locList;
    }
}
