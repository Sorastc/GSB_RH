package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import POJO.Region;

// TODO: Auto-generated Javadoc
/**
 * The Class RegionDAO.
 * @author harich-s
 */
public class RegionDAO extends DAO<Region> {
	static Connection con;

	/**
	 * Création d'une région.
	 * 
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean create(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Suppression d'une région.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean delete(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Mise à jour d'une région.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean update(Region obj) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * Find.
	 *
	 * @param id the id
	 * @return the region
	 */
	@Override
	public Region find(int id) {
	    String sql = "SELECT * FROM region WHERE region_id = " + id;
	    try (java.sql.Statement statement = con.createStatement()) {
	        ResultSet resultat = statement.executeQuery(sql);
	        if (resultat.next()) {
	            return new Region(
	                resultat.getInt("region_id"),
	                resultat.getString("region_nom")
	            );
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}

}
