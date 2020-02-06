package test;

import app.controller.InventoryController;
import app.controller.ItemController;
import app.controller.SubtaskController;
import app.controller.TaskController;
import app.inventory.Inventory;
import app.inventory.item.Item;
import app.inventory.item.task.Task;
import app.inventory.item.task.subtask.Subtask;

public class ControllersTest {
	public static void main(String[] args) {
		InventoryController inventoryController = new InventoryController();
		ItemController itemController = new ItemController();
		TaskController taskController = new TaskController();
		SubtaskController subtaskController = new SubtaskController();

		Inventory inventory = new Inventory("Meu inventario", 10);
		inventory = inventoryController.store(inventory);

		Item item = new Item("item name");
		item = itemController.store(item);

		Task task = new Task(item, "Tarefazassa", 10);
		task = taskController.store(task);

		Subtask subtask = new Subtask(task, "subtarefa", 10);
		subtask = subtaskController.store(subtask);
	}
}
