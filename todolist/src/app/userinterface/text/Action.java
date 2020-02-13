package app.userinterface.text;

public class Action {
	private final int CREATE_ACTION = 1;
	private final int RETRIEVE_ACTION = 2;
	private final int RETRIEVEALL_ACTION = 3;
	private final int UPDATE_ACTION = 4;
	private final int DELETE_ACTION = 5;

	private final int MIN_ACTION = CREATE_ACTION;
	private final int MAX_ACTION = DELETE_ACTION;

	private int actionNotAllowed;

	private int action;

	public Action() {
		this.action = -1;

		this.actionNotAllowed = -1;
	}

	public Action(int actionNotAllowed) {
		this.action = -1;

		this.actionNotAllowed = actionNotAllowed;
	}

	private boolean issetAction() {
		return this.action != -1;
	}

	public boolean setAction(int action) {
		if (this.doValidAction(action)) {
			this.action = action;

			return true;
		} else {
			return false;

		}
	}

	public String getMethod() {
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

	private boolean isAllowedAction(int action) {
		return action != this.actionNotAllowed;
	}

	public boolean doValidAction(int action) {
		if (action >= this.MIN_ACTION && action <= this.MAX_ACTION) {
			return this.isAllowedAction(action);

		} else {
			return false;

		}
	}

	private String getListActions(String entity) {
		String listActions = "";

		if (doValidAction(this.CREATE_ACTION)) {
			listActions += this.CREATE_ACTION + ". Criar " + entity + "\n";
		}

		if (doValidAction(this.RETRIEVE_ACTION)) {
			listActions += this.RETRIEVE_ACTION + ". Buscar " + entity + "\n";
		}

		if (doValidAction(this.RETRIEVEALL_ACTION)) {
			listActions += this.RETRIEVEALL_ACTION + ". Listar " + entity + "\n";
		}

		if (doValidAction(this.UPDATE_ACTION)) {
			listActions += this.UPDATE_ACTION + ". Atualizar " + entity + "\n";
		}

		if (doValidAction(this.DELETE_ACTION)) {
			listActions += this.DELETE_ACTION + ". Deletar " + entity + "\n";
		}

		return listActions;
	}

	public void showActions(String entity) {
		String listActions = this.getListActions(entity);

		System.out.println(listActions);
	}
}
