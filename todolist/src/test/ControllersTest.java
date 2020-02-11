package test;

import app.controller.ItemController;
import app.controller.SubtaskController;
import app.controller.TaskController;
import app.controller.TodolistController;
import app.todolist.item.task.Task;
import app.todolist.item.task.subtask.Subtask;

public class ControllersTest {
	public static void main(String[] args) {
		TodolistController todolistController = new TodolistController();
		ItemController itemController = new ItemController();
		TaskController taskController = new TaskController();
		SubtaskController subtaskController = new SubtaskController();

		Task task = taskController.retrieve(15);

		/**
		 * CRUD
		 * 
		 * Create
		 * 
		 * Retrieve
		 * 
		 * Retrieve All
		 * 
		 * Update
		 * 
		 * Delete
		 */
		Subtask subtask = new Subtask(task, "velha subtarefa", 1);

		subtaskController.delete(20);

	}
}
