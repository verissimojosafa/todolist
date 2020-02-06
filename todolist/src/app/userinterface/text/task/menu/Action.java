package app.userinterface.text.task.menu;

import java.util.List;
import java.util.Scanner;

import app.controller.TaskController;
import app.inventory.item.task.Task;
import app.userinterface.text.task.form.TaskForm;

public class Action {
	private int[] actions;

	private int actionCreate;
	private int actionRetrieveAll;
	private int actionRetrieve;
	private int actionUpdate;
	private int actionDelete;

	private TaskForm taskForm;
	private TaskController taskController;

	public Action(Menu menu) {
		this.taskController = new TaskController();
		this.taskForm = new TaskForm();
		this.setActions(menu);
	}

	private void setActions(Menu menu) {
		String[] options = menu.getOptions();
		int[] validOptions = menu.getValidOptions();

		this.actions = validOptions;

		for (int validOption : validOptions) {
			String option = options[validOption];

			if (option.indexOf("Cadastrar") != -1) {
				this.actionCreate = validOption;

			} else if (option.indexOf("Listar") != -1) {
				this.actionRetrieveAll = validOption;

			} else if (option.indexOf("Buscar") != -1) {
				this.actionRetrieve = validOption;

			} else if (option.indexOf("Editar") != -1) {
				this.actionUpdate = validOption;

			} else if (option.indexOf("Remover") != -1) {
				this.actionDelete = validOption;

			}
		}
	}

	public int getAction(String errorMessage) {

		Scanner intScanner = new Scanner(System.in);

		int action = 0;
		while (true) {
			action = intScanner.nextInt();

			boolean isActionValid = doValidAction(action);

			if (isActionValid) {
				break;
			}

			System.out.println(errorMessage);
		}

		return action;
	}

	private boolean doValidAction(int target) {
		for (int action : actions) {
			if (action == target) {
				return true;
			}
		}

		return false;
	}

	public void doAction(int action) {
		if (action == this.actionCreate) {
			this.doCreate();

		} else if (action == this.actionRetrieveAll) {
			this.doRetrieveAll();

		} else if (action == this.actionRetrieve) {
			this.doRetrieve();

		} else if (action == this.actionUpdate) {
			this.doUpdate();

		} else if (action == this.actionDelete) {
			this.doDelete();

		}
	}

	private Task doCreate() {
		taskForm.setFields();
		Task task = taskForm.getTask();
		task = taskController.store(task);

		return task;
	}

	private void doRetrieveAll() {
		List<Task> tasks = taskController.retrieveAll();

		for (Task task : tasks) {
			System.out.println(task);
		}
	}

	public void doDelete() {
		int id = taskForm.getId();
		taskController.delete(id);
	}

	public void doUpdate() {
		int id = taskForm.setUpdateFields();
		Task task = taskForm.getTask();

		taskController.update(id, task.getTask(), task.getPriority());
	}

	public void doRetrieve() {
		String text = taskForm.getText();
		List<Task> inventories = taskController.retrieve(text);

		for (Task task : inventories) {
			System.out.println(task);
		}
	}
}
