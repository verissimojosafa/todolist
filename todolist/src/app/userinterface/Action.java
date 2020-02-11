package app.userinterface;

public class Action {
	private final int CREATE_ACTION = 1;
	private final int RETRIEVE_ACTION = 2;
	private final int RETRIEVEALL_ACTION = 3;
	private final int UPDATE_ACTION = 4;
	private final int DELETE_ACTION = 5;

	private final int MIN_ACTION = CREATE_ACTION;
	private final int MAX_ACTION = DELETE_ACTION;

	private int action;

	public Action() {
		this.action = -1;
	}

	private boolean issetAction() {
		if (this.action != -1) {
			return true;
		} else {
			return false;
		}
	}

	public boolean setAction(int action) {
		if (this.doValidAction(action)) {
			this.action = action;

			return true;
		} else {
			return false;

		}
	}

	public String doAction() {
		if (issetAction()) {
			if (this.action == this.CREATE_ACTION) {
				return "create";

			} else if (this.action == this.RETRIEVE_ACTION) {
				return "retrieve";

			} else if (this.action == this.RETRIEVEALL_ACTION) {
				return "retrieve all";

			} else if (this.action == this.UPDATE_ACTION) {
				return "update";

			} else if (this.action == this.DELETE_ACTION) {
				return "delete";

			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	public boolean doValidAction(int action) {
		if (action >= this.MIN_ACTION && action <= this.MAX_ACTION) {
			return true;

		} else {
			return false;

		}
	}

	public void showActions(String entity) {
		System.out.println(this.CREATE_ACTION + ". Criar " + entity);
		System.out.println(this.RETRIEVE_ACTION + ". Buscar " + entity);
		System.out.println(this.RETRIEVEALL_ACTION + ". Listar " + entity);
		System.out.println(this.UPDATE_ACTION + ". Atualizar " + entity);
		System.out.println(this.DELETE_ACTION + ". Deletar " + entity);
	}
}
