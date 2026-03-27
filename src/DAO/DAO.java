package DAO;
import java.sql.Connection;
import ConnexionSQL.Connexion;

// TODO: Auto-generated Javadoc
/**
 * The Class DAO.
 *
 * @param <T> the generic type
 */
public abstract class DAO<T> {
	  
  	/** The connect. */
  	protected Connection connect;
	  
  	/**
  	 * Instantiates a new dao.
  	 */
  	public DAO(){
	    this.connect = Connexion.getInstance();
	  }

	  /**
  	 * Méthode de création.
  	 *
  	 * @param obj the obj
  	 * @return boolean
  	 */
	  public abstract boolean create(T obj);
	  
  	/**
  	 * Méthode pour effacer.
  	 *
  	 * @param obj the obj
  	 * @return boolean
  	 */
	  public abstract boolean delete(T obj);

	  /**
  	 * Méthode de mise à jour.
  	 *
  	 * @param obj the obj
  	 * @return boolean
  	 */
	  public abstract boolean update(T obj);

	  /**
  	 * Méthode de recherche des informations.
  	 *
  	 * @param id the id
  	 * @return T
  	 */
	  public abstract T find(int id);
	}
