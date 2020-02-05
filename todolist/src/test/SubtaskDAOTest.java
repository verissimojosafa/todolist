package test;

import app.controller.SubtaskController;
import app.inventory.item.task.Task;
import app.inventory.item.task.subtask.Subtask;

public class SubtaskDAOTest {
	public static void main(String[] args) {
		SubtaskController subtaskController = new SubtaskController();

		Task task = new Task("tarefa", 2);
		Subtask subtask = new Subtask(task, "subtarefa", 3);

		subtaskController.store(subtask);
		System.out.println(subtask);
	}
}
