package app.inventory.item.task;

/**
 * 
 * @author Josafa
 *
 */
public interface ITaskCRUD {
	public boolean updateTask(String task, int priority);

	public String retrieveTask();
}
