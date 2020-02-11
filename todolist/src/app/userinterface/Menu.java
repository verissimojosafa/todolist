package app.userinterface;

import app.userinterface.text.todolist.TodolistForm;

public abstract class Menu {
	private String entity;
	private Form form;
	protected Action action;

	public Menu(String entity) {
		this.form = new TodolistForm();
		this.action = new Action();

		this.entity = entity;
	}

	public void showMenu() {
		this.action.showActions(this.entity);

		int action = this.form.getAction();

		this.action.setAction(action);

		this.getMethod();
	}

	protected abstract void getMethod();
}
