package app.todolist.item;

/**
 * 
 * @author Josafa
 *
 */
public interface IItemCRUD {
	public boolean addItem(String name, String task, int priority);

	public boolean updateItem(String text, String name, int priority);

	public String retrieveItem(String text);

	public String retrieveAllItem();

	public boolean deleteItem(String text);
}
