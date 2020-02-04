package test;

import app.inventory.item.task.Task;

public class TaskTest {
	public static void main(String[] args) {
		Task task = new Task("Minha tarefa principal", 1);

		task.addSubtask("Minha tarefa secundária", 3);
		task.addSubtask("Minha outra tarefa secundária", 2);

		task.updateSubtask("Minha outra", "nova", 1);
		task.deleteSubtask("nova");

		System.out.println(task.retrieveSubtask("nova"));
	}
}
