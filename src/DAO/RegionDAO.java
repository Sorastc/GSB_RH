package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import POJO.Region;

public class RegionDAO extends DAO<Region> {

    Connection con;

    public RegionDAO() {
        this.con = connect;
    }

    @Override
    public boolean create(Region obj) { return false; }

    @Override
    public boolean delete(Region obj) { return false; }

    @Override
    public boolean update(Region obj) { return false; }

    @Override
    public Region find(int id) {
        String sql = "SELECT * FROM region WHERE region_id = " + id;
        try (java.sql.Statement statement = con.createStatement()) {
            ResultSet rs = statement.executeQuery(sql);
            if (rs.next()) {
                return new Region(rs.getInt("region_id"), rs.getString("region_nom"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Retourne toutes les régions triées par nom. */
    public ArrayList<Region> findAll() {
        ArrayList<Region> liste = new ArrayList<>();
        String sql = "SELECT region_id, region_nom FROM region ORDER BY region_nom";
        try (java.sql.Statement st = con.createStatement()) {
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                liste.add(new Region(rs.getInt("region_id"), rs.getString("region_nom")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return liste;
    }
}