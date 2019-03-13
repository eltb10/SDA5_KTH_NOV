package todolist3;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.soap.Node;

import org.w3c.dom.css.Counter;

public class TaskList implements Serializable

{
	private ArrayList<Task> tasks;
	// private static final long serialVersionUID = 1L;
	private Scanner scanner;

	public static final String filePath = "database.txt";

	public TaskList() {
		load();
		scanner = new Scanner(System.in);
	}

	public void remove(Task t) {
		tasks.remove(t);

	}

	public void add() {

		// Task3 t = new Task3();
		// tasks.add(t);

		System.out.print("Please enter the task title\n");
		String title = scanner.nextLine();

		System.out.print("Please enter the task project\n");
		String project = scanner.nextLine();

		System.out.print("Please enter the task date with format:dd/MM/yyyy\n");
		LocalDate date = Validator.validateDate();

		Task tt = new Task(title, project, date);
		tasks.add(tt);

	}

	

	public void filterByProject() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Project");
		String project = scanner.nextLine();
		List<Task> l = tasks.stream().filter(x -> x.getProject().equals(project)).collect(Collectors.toList());

		System.out.println(l);

	}

	public void sortByDate() {
		// Scanner scanner = new Scanner(System.in);
		// System.out.println("Enter Date");
		// String date= scanner.nextLine();
		@SuppressWarnings("unlikely-arg-type")
		// List<Task3> k = tasks.stream().filter(x
		// ->x.getDate().equals(date)).collect(Collectors.toList());
		List<Task> k = tasks.stream().sorted(Comparator.comparing(Task::getDate)).collect(Collectors.toList());
		printWithIndex();
		//System.out.println(k);

	}


	/*
	 * 
	 * This is a save method
	 * 
	 */
	public boolean save() {

		boolean success = false;
		try {
			FileOutputStream fos = new FileOutputStream(new File(filePath));
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			ois.writeObject(tasks);

			success = true;
		} catch (Exception e) {
			// System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return success;
	}

	@SuppressWarnings("unchecked")
	public void load() {

		File f = new File("database.txt");
		if (f.exists())
		{
			boolean success = false;

			try {
				FileInputStream fis = new FileInputStream(new File(filePath));
				ObjectInputStream ois = new ObjectInputStream(fis);
				tasks = (ArrayList<Task>) ois.readObject();
				ois.close();
				success = true;
			} catch (EOFException e) {
				System.out.println("the file is empty");
			} catch (Exception e) {
				e.printStackTrace();

			}
			if (success == true) {
				System.out.println("Load is successful");
			}
			else
				System.out.println("Load is unsuccessful");

		}
		else 
		{
			tasks = new ArrayList<Task>();
			System.out.println(tasks);
		}

	}

	public void removeTask() {
		System.out.println("Enter name of task");
		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		Iterator<Task> iterator = tasks.iterator();
		while (iterator.hasNext()) {

			Task task = iterator.next();
			if (task.getTitle().equals(name)) {
				iterator.remove();
				save();
			}
		}
	}

	public void printWithIndex() 
	{
		for(int i = 0; i <tasks.size(); i++)
			System.out.println(i + ") " + tasks.get(i));
	}
	
	public void editTask() {
		printWithIndex();
		//TODO ask user about index
		int index = Validator.validateInt(0, tasks.size());
		System.out.println("Enter the name of task to edit");
		System.out.println("what do you want to update> 1-title, 2-project 3-date");
		String tt = "sgfsdf";
		tasks.get(index).setTitle(tt);
		

		Scanner scanner = new Scanner(System.in);
		String name = scanner.nextLine();
		System.out.println("Enter the new name of the task ");
		String newName = scanner.nextLine();
		
		
		Iterator<Task> iterator = tasks.iterator();
		while (iterator.hasNext()) {
			Task task = iterator.next();
			if (task.getTitle().equals(name)) {
				task.setTitle(newName);
				save();
			}
		}
	}

	public void showList() 
	{
		System.out.println(tasks);
		printSize();
	}
	
	public void printSize() {
		System.out.println("There are in total " + tasks.size() + "tasks in the list");

	}


	public void toggleTaskDone() {
		if (tasks.size() <= 0) {
			System.out.println("Nothing to toggle, tasks list is empty");
		}

		int index = Validator.validateInt(0, tasks.size());

		String status = tasks.get(index).getStatus();
		System.out.println("this task is =  " + status);

		System.out.println("do you want to change the status? (y/n)");
		String instruction = scanner.nextLine();

		if (instruction.toLowerCase().equals("y"))
			tasks.get(index).toggle();
		else if (instruction.toLowerCase().equals("n")) {
		}
		// do nothing
		else {
			System.out.println("please write y or n");
		}

	}

	
	// check showdate,remove task,edit task

}
