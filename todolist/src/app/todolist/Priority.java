package app.todolist;

public enum Priority {
	LOW(0), MEDIUM(1), HIGH(2);

	private int level;

	Priority(int level) {
		this.level = level;
	}

	public int getLevel() {
		return this.level;
	}
}
