package app.userinterface.text.subtask;

public class Main {
	public static void main(String[] args) {
		String title = "CRUD";
		String[] options = { "Listar Invent�rios", "Buscar Invent�rio", "Cadastrar Invent�rio", "Editar Invent�rio",
				"Remover Invent�rio" };

		Interface userinterface = new Interface(title, options);

		userinterface.menu();
	}
}
