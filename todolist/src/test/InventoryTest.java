package test;

import app.inventory.Inventory;
import app.inventory.item.task.ITaskCRUD;
import app.inventory.item.task.subtask.ISubtaskCRUD;

public class InventoryTest {
	public static void main(String[] args) {
		Inventory inventory = new Inventory("Minha Lista 2.0", 2);
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
		inventory.addItem("Nome do item 1", "tarefa do item 1", 3);
		inventory.addItem("Nome do item 2", "tarefa do item 2", 2);

		ITaskCRUD taskCRUD = inventory.getTaskCRUD("item 1");
		taskCRUD.updateTask("tarefazassa", 4);

		ISubtaskCRUD subtaskCRUD = inventory.getSubTaskCRUD("item 1");
		subtaskCRUD.addSubtask("Minha subtarefa", 3);
		subtaskCRUD.addSubtask("Minha subtarefaaafasda", 2);

		subtaskCRUD = inventory.getSubTaskCRUD("item 2");
		subtaskCRUD.addSubtask("eitataa", 1);

		String task = taskCRUD.retrieveTask();

		String item = inventory.retrieveItem("item 1");

		inventory.updateItem("item 1", "Meu item", 1);

//		inventory.deleteItem("item 2");

		System.out.println(inventory);
	}
}
