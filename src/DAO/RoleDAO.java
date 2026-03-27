package DAO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;

import POJO.Role;

public class RoleDAO extends DAO<Role>{

	Connection con;

    public RoleDAO() {
        this.con = connect;
    }
	@Override
	public boolean create(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Role obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Role find(int id) {
		// TODO Auto-generated method stub
		return null;
	}
	public Role findById(String idRole) {
        String sql = "SELECT * FROM role WHERE idRole = '" + idRole + "'";
        try (Statement statement = con.createStatement()) {
            ResultSet resultat = statement.executeQuery(sql);
            if (resultat.next()) {
                return new Role(
                    resultat.getString("idRole"),
                    resultat.getString("libelle")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


}
