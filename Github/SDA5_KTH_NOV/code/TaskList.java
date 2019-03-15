package todolist3;

 



import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TaskList implements Serializable

{
	private ArrayList<Task> tasks;
	private static final long serialVersionUID = 1L;
	private Scanner scanner;

	public static final String filePath = "database2.txt";

	public TaskList() {
		tasks = FileHandler.load();
		
		scanner = new Scanner(System.in);
	}

	public void remove(Task t) {
		tasks.remove(t);

	}

	public void add() {

		System.out.print("Please enter the task title \n");
		String title = scanner.nextLine();

		System.out.print("Please enter the task project\n");
		String project = scanner.nextLine();

		System.out.print("Please enter the task date with format:dd/MM/yyyy  \n");
		LocalDate date = Validator.validateDate();
		//LocalDate  date= Validator.getDateValidator();
		Task tt = new Task(title, project, date);
		if (tasks == null) {
			System.out.println("It is NULL");
		}
		tasks.add(tt);

	}

	

	public void filterByProject() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Project");
		String project = scanner.nextLine();
		List<Task> l = tasks.stream().filter(x -> x.getProject().equals(project)).collect(Collectors.toList());
		//printWithIndex();

		System.out.println(l);

	}

	public void sortByDate() {
		@SuppressWarnings("unlikely-arg-type")
		List<Task> k = tasks.stream().sorted(Comparator.comparing(Task::getDate)).collect(Collectors.toList());
		printWithIndex();
		//System.out.println(k);

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
		printSize();
		for(Task task : tasks) {
			System.out.println("Title :" + "" + task.getTitle() + " " + "Project :" + "" + task.getProject() + " " + "Title :" + "" + task.getDate().toString() + " " + "Status :" + "" + task.getStatus());
		}
		
		//printWithIndex();
		
	}
	
	public void printSize() {
		System.out.println("\nThere are in total " + tasks.size() + " tasks in the list \n");

	}


	public void toggleTaskDone() {
		if (tasks.size() <= 0) {
			System.out.println(" Nothing to toggle, tasks list is empty");
		}

		int index = Validator.validateInt(0, tasks.size());

		String status = tasks.get(index).getStatus();
		System.out.println("this task is =  " + status);

		System.out.println(" do you want to change the status? (y/n)");
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

	public void save() {
		FileHandler.save(tasks);
	}


}