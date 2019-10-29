package co.grandcircus;

public class Task {

	private String name;
	private String description;
	private String dueDate;
	private boolean done;

	public Task() {
		super();
	}

	public Task(String name, String description, String dueDate, boolean done) {
		super();
		this.name = name;
		this.description = description;
		this.dueDate = dueDate;
		this.done = done;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
	}

	public boolean getDone() {
		return done;
	}

	public void setDone(boolean done) {
		this.done = done;
	}

	@Override
	public String toString() {
		return "Task: name = " + name + ", description = " + description + ", due date = " + dueDate + ", done = " + done;
	}

}
