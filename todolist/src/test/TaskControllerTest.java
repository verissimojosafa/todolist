package test;

import app.controller.TaskController;
import app.inventory.item.task.Task;

public class TaskControllerTest {
	public static void main(String[] args) {
		TaskController controller = new TaskController();
		
		Task task = new Task("tarefa", 10);
		
		controller.store(task);
		
	}
}
