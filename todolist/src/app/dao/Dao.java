package app.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * 
 * @author Josafa
 *
 */
public abstract class Dao {
	private EntityManagerFactory factory;
	protected EntityManager manager;

	public void openSession() {
		this.factory = Persistence.createEntityManagerFactory("todolist");
		this.manager = factory.createEntityManager();
	}

	public void closeSession() {
		this.manager.close();
		this.factory.close();
	}
}
