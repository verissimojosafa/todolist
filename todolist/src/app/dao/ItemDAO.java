package app.dao;

import java.util.List;

import javax.persistence.Query;

import app.todolist.item.Item;

/**
 * 
 * @author JOSAF� VER�SSIMO
 *
 */
public class ItemDAO extends Dao {

	public Item store(Item item) {
		super.openSession();

		super.manager.getTransaction().begin();
		super.manager.persist(item);
		super.manager.getTransaction().commit();

		super.closeSession();

		return item;
	}

	public List<Item> retrieveAll() {
		super.openSession();

		super.manager.getTransaction().begin();
		Query select = super.manager.createQuery("SELECT items from Item items");
		List<Item> items = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return items;
	}

	public void update(Long id, String name) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query query = super.manager.createQuery("UPDATE Item SET name = '" + name + "' WHERE id = " + id);
		int updateCount = query.executeUpdate();

		super.manager.getTransaction().commit();

		super.manager.close();
	}

	public void delete(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query deleteSubtaskQuery = super.manager.createNativeQuery(
				"delete from subtasks where task_id in (select task_id from items where id = " + id + ")");
		deleteSubtaskQuery.executeUpdate();

		Query deleteTaskQuery = super.manager
				.createNativeQuery("delete from tasks where id in (select task_id from items where id = " + id + ")");
		deleteTaskQuery.executeUpdate();

		Query deleteItemQuery = super.manager.createNativeQuery("delete from items where id = " + id);
		deleteItemQuery.executeUpdate();

		super.manager.getTransaction().commit();

		super.closeSession();
	}

	public List<Item> retrieve(String text) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT items from Item items where name like '%" + text + "%'");
		List<Item> items = select.getResultList();

		super.manager.getTransaction().commit();

		super.closeSession();

		return items;
	}

	public Item retrieve(Long id) {
		super.openSession();

		super.manager.getTransaction().begin();

		Query select = super.manager.createQuery("SELECT items from Item items WHERE id = " + id);
		Item item = (Item) select.getSingleResult();

		super.manager.getTransaction().commit();

		super.closeSession();

		return item;
	}
}
