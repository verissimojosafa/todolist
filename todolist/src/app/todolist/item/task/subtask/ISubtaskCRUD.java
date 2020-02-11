package app.todolist.item.task.subtask;

/**
 * 
 * @author Josafa
 *
 */
public interface ISubtaskCRUD {
	public boolean addSubtask(String task, int priority);

	public boolean updateSubtask(String text, String subTask, int priority);

	public String retrieveSubtask(String text);

	public String retrieveAllSubtasks();

	public boolean deleteSubtask(String text);
}
