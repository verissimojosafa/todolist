package app.userinterface.text.subtask;

public class Main {
	public static void main(String[] args) {
		String title = "CRUD";
		String[] options = { "Listar Inventários", "Buscar Inventário", "Cadastrar Inventário", "Editar Inventário",
				"Remover Inventário" };

		Interface userinterface = new Interface(title, options);

		userinterface.menu();
	}
}
