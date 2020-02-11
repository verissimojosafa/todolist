package test;

import app.todolist.item.Item;
import app.todolist.item.task.subtask.ISubtaskCRUD;

public class ItemTest {
	public static void main(String[] args) {
		Item item = new Item("Nome do item", "Nome da tarefa principal", 3);
		ISubtaskCRUD subtaskCRUD = item.getSubtaskCRUD();
//
//		item.updateTask("nova", 1);
//
		subtaskCRUD.addSubtask("asdsad", 2);
		subtaskCRUD.addSubtask("jojii", 2);

//		subtaskCRUD.deleteSubtask("j");

		subtaskCRUD.updateSubtask("asd", "ajustada", 1);

//		System.out.println(subtaskCRUD.retrieveAllSubtasks());

		System.out.println(item.toString());
	}
}
