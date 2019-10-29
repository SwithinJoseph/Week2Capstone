package co.grandcircus;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class TaskList {

	public static void main(String[] args) {

		Scanner scnr = new Scanner(System.in);

		int userInput;
		int counter = 0;
		Task task = new Task();
		List<Task> newTask = new ArrayList<>();

		System.out.println("Welcome to the Task Manager!");
		do {

			displayList();

			userInput = Validator.getIntBetween(scnr, "\nWhat would you like to do? ", 1, 5);

			if (userInput == 1) {

				System.out.println("Done?    Due Date:    Team Member Name:    Description:  ");
				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));

			} else if (userInput == 2) {

				System.out.println("ADD TASK\n");
				String userName = Validator.getString(scnr, "Name: ");
				task.setName(userName);

				String taskDescrip = Validator.getString(scnr, "Task Description: ");
				task.setDescription(taskDescrip);

				String dueDate = Validator.getStringMatchingRegex(scnr, "Due Date: (mm/dd/yyyy)",
						("([0-9]{2})/([0-9]{2})/([0-9]{4})"));
				task.setDueDate(dueDate);

				boolean taskComplete = false;
				task.setDone(taskComplete);
				task.getDone();

				newTask.add(new Task(userName, taskDescrip, dueDate, taskComplete));
				counter++;
				System.out.println("\nTask added!");

			} else if (userInput == 3) {

				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));
				int deleteTask = Validator.getIntBetween(scnr, "Which task would you like to delete?", 1,
						newTask.size());
				deleteTask = deleteTask - 1;
				String confirmDelete = Validator.getString(scnr, "\nAre you sure you want to delete this task? (y/n)");
				if ((confirmDelete.equalsIgnoreCase("yes")) || (confirmDelete.equalsIgnoreCase("y"))) {
					newTask.remove(deleteTask);
					System.out.println("\nTask was deleted");

				} else {

				}

			} else if (userInput == 4) {

				for (int i = 0; i < newTask.size(); i++)
					System.out.println(newTask.get(i));
				int askTaskComplete = Validator.getIntBetween(scnr, "What task do you want to mark complete?", 1,
						newTask.size());
				String taskComplete = Validator.getString(scnr,
						"\nAre you sure you want to mark this task complete? (y/n)");
				if ((taskComplete.equalsIgnoreCase("y")) || (taskComplete.equalsIgnoreCase("yes"))) {
					task = newTask.get(askTaskComplete - 1);
					task.setDone(true);
					System.out.println("\nTask marked completed.");

				}
			} else if (userInput == 5) {
				String cont = Validator.getString(scnr, "Are you sure you want to exit? (y/n)");
				if ((cont.equalsIgnoreCase("y")) || (cont.equalsIgnoreCase("yes"))) {
					break;
				} else {

				}
			}

		} while (userInput < 1 || userInput > 5);

		System.out.println("Have a great day!");
	}

	public static void displayList() {
		System.out.println("\n1. List tasks");
		System.out.println("2. Add task");
		System.out.println("3. Delete task");
		System.out.println("4. Mark task complete");
		System.out.println("5. Quit");
	}

}
