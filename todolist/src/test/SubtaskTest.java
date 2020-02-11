package test;

import app.todolist.item.task.Task;
import app.todolist.item.task.subtask.Subtask;

public class SubtaskTest {

	public static void main(String[] args) {
		Task task = new Task("tarefa", 1);
		Subtask subtask = new Subtask(task, "minha subtask", 2);

		System.out.println(subtask);
	}

}
