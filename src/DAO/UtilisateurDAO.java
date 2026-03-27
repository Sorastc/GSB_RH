package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import POJO.Utilisateur;

public class UtilisateurDAO extends DAO<Utilisateur> {
	static Connection con;

	public UtilisateurDAO() {
		this.con = connect;
	}

//	@Override
	public boolean create(Utilisateur user) {
		// Requête SQL avec les bons champs et des paramètres
		String sql = "INSERT INTO utilisateur VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			// Remplissage des paramètres à partir des attributs de la classe
			preparedStatement.setString(1, user.getIdUtilisateur());
			preparedStatement.setString(2, user.getNom());
			preparedStatement.setString(3, user.getPrenom());
			preparedStatement.setString(4, user.getRole().getIdRole());
			preparedStatement.setString(5, user.getAdressePo());
			preparedStatement.setString(6, user.getCp());
			preparedStatement.setString(7, user.getVille());
			preparedStatement.setString(8, user.getNumTel());
			preparedStatement.setString(9, user.getNumTelFixe());
			preparedStatement.setString(10, user.getEmail());
			preparedStatement.setString(11, user.getRegion().getNomRegion());
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}

	}

	public boolean delete(Utilisateur user) {
		String sql = "DELETE FROM utilisateur WHERE idUtilisateur = '" + user + "'";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getIdUtilisateur());
			int ligne = preparedStatement.executeUpdate();
			return ligne > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override

	public boolean update(Utilisateur user) {
		String sql = "UPDATE utilisateur SET nom = ?, prenom = ?, adresse = ?, "
				+ "cp = ?, ville = ?, region = ?, NumTel = ?, NumTelFixe = ?, email = ? WHERE idUtilisateur = '" + user
				+ "'";
		try (PreparedStatement preparedStatement = con.prepareStatement(sql)) {
			preparedStatement.setString(1, user.getNom());
			preparedStatement.setString(2, user.getPrenom());
			preparedStatement.setString(3, user.getAdressePo());
			preparedStatement.setString(4, user.getCp());
			preparedStatement.setString(5, user.getVille());
			preparedStatement.setInt(6, user.getRegion().getIdRegion());
			preparedStatement.setString(7, user.getNumTel());
			preparedStatement.setString(8, user.getNumTelFixe());
			preparedStatement.setString(9, user.getEmail());
			int ligne = preparedStatement.executeUpdate();
			return ligne > 0;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Utilisateur find(int id) {
		RoleDAO role = new RoleDAO();
		RegionDAO region = new RegionDAO();
		String sql = "SELECT * FROM utilisateur WHERE idUtilisateur = '" + id + "'";
		try (Statement statement = con.createStatement()) {
			ResultSet resultat = statement.executeQuery(sql);
			if (resultat.next()) {
				return new Utilisateur(resultat.getString("idUtilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), role.find(resultat.getInt("idRole")),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getString("NumTel"), resultat.getString("NumTelFixe"), resultat.getString("email"),
						region.find(resultat.getInt("idRegion")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Utilisateur> RecupTousLesUsers() {
		RoleDAO role = new RoleDAO();
		RegionDAO region = new RegionDAO();
		try {
			ArrayList<Utilisateur> listeUser = new ArrayList<>();

			Statement requete = (Statement) con.createStatement();
			ResultSet resultat = requete.executeQuery("select * from utilisateur");
			while (resultat.next()) {
				Utilisateur user = new Utilisateur(resultat.getString("idUtilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), role.findById(resultat.getString("idRole")),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getString("NumTel"), resultat.getString("NumTelFixe"), resultat.getString("email"),
						region.find(resultat.getInt("idRegion")));
				listeUser.add(user);
			}
			return listeUser;

		} catch (SQLException e) {
			System.out.println("problème d’accès à la base");
			e.printStackTrace();
		}
		return null;
	}

	public static String recupMdpByLogin(String login) {
		String sql = "SELECT mdp FROM utilisateur WHERE login = '" + login + "'";
		try (Statement statement = con.createStatement()) {
			ResultSet resultat = statement.executeQuery(sql);
			if (resultat.next()) {
				return resultat.getString("mdp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static Utilisateur recupUserByLogin(String login) {
		RoleDAO role = new RoleDAO();
		RegionDAO region = new RegionDAO();
		String sql = "SELECT * FROM utilisateur WHERE login = '" + login + "'";
		try (Statement statement = con.createStatement()) {
			ResultSet resultat = statement.executeQuery(sql);
			if (resultat.next()) {
				Utilisateur user = new Utilisateur(resultat.getString("idUtilisateur"), resultat.getString("nom"),
						resultat.getString("prenom"), role.findById(resultat.getString("idRole")),
						resultat.getString("adresse"), resultat.getString("cp"), resultat.getString("ville"),
						resultat.getString("NumTel"), resultat.getString("NumTelFixe"), resultat.getString("email"),
						region.find(resultat.getInt("idRegion")));
				return user;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
