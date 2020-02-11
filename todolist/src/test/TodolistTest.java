package test;

import app.todolist.Todolist;
import app.todolist.item.task.ITaskCRUD;
import app.todolist.item.task.subtask.ISubtaskCRUD;

public class TodolistTest {
	public static void main(String[] args) {
		Todolist todolist = new Todolist("Minha Lista 2.0", 2);
		/**
		 * CRUD
		 * 
		 * #C - OK
		 * 
		 * #R - OK
		 * 
		 * #U - OK
		 * 
		 * #D - OK
		 */
		todolist.addItem("Nome do item 1", "tarefa do item 1", 3);
		todolist.addItem("Nome do item 2", "tarefa do item 2", 2);

		ITaskCRUD taskCRUD = todolist.getTaskCRUD("item 1");
		taskCRUD.updateTask("tarefazassa", 4);

		ISubtaskCRUD subtaskCRUD = todolist.getSubTaskCRUD("item 1");
		subtaskCRUD.addSubtask("Minha subtarefa", 3);
		subtaskCRUD.addSubtask("Minha subtarefaaafasda", 2);

		subtaskCRUD = todolist.getSubTaskCRUD("item 2");
		subtaskCRUD.addSubtask("eitataa", 1);

		String task = taskCRUD.retrieveTask();

		String item = todolist.retrieveItem("item 1");

		todolist.updateItem("item 1", "Meu item", 1);

		todolist.deleteItem("item 2");

		System.out.println(todolist);
	}
}
