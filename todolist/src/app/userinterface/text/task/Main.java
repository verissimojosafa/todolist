package app.userinterface.text.task;

public class Main {
	public static void main(String[] args) {
		String title = "CRUD";
		String[] options = { "Listar Tarefas", "Buscar Tarefa", "Cadastrar Tarefa", "Editar Tarefa", "Remover Tarefa" };

		Interface userinterface = new Interface(title, options);

		userinterface.menu();
	}
}
