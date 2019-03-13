package todolist3;

import java.util.Scanner;

public class Controller 
{
	private TaskList taskList;
	
	public Controller() 
	
	{
		taskList = new TaskList();
	}
	
	//TODO move the save and load to another class, move validation to another class
	//TODO the validation class will have 2 methods at least to validate date and user number input
	public void start() 
	{
		while (true) {
			System.out.println("Welcome to ToDoLy");
			System.out.println("You have X tasks todo and Y tasks are done!");
			System.out.println("Pick an option:\n");
			System.out.println("(1) Show Task List");
			System.out.println("(2) Add new  Task ");
			System.out.println("(3) Save and Exit");
			System.out.println("(4) Filter by Project");
			System.out.println("(5) Show by Date");
			System.out.println("(6) Remove task  ");
			System.out.println("(7) Edit task  ");
			System.out.println("(8) Toggle task  ");

			//Scanner scanner = new Scanner(System.in);
			int choice = Validator.validateInt(1, 8);
			switch (choice) {
			case 1:
				System.out.println("Choice 1 selected  \n");
				taskList.showList();
				break;
			case 2:
				System.out.println("Choice 2 selected\n");
				taskList.add();
				break;

			case 3:
				System.out.println("Choice 3 selected\n");
				System.out.println("Exit");
				taskList.save();
				System.exit(0);

			case 4:
				System.out.println("Choice 4 selected\n");
				taskList.filterByProject();
				break;
			case 5:
				System.out.println("Choice 5 selected\n");
				taskList.sortByDate();
				break;

			case 6:
				System.out.println("Choice 6 selected\n");
				taskList.removeTask();
				break;

			case 7:
				System.out.println("Choice 7 selected\n");
				taskList.editTask();
				// toggleTaskDone();
				break;
			case 8:
				System.out.println("Choice 8 selected\n");
				taskList.toggleTaskDone();

				break;

			default:
				System.out.println("Unrecognized command");

			}
		}
	}
}
