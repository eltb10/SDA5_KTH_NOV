package todolist3;

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
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.xml.soap.Node;

import org.w3c.dom.css.Counter;

import todolist2.Task;
import todolist2.ToDoList2;

public class ToDoList3 implements Serializable

{
ArrayList<Task3> tasks = new ArrayList<>();
Scanner scanner = new Scanner(System.in);


public static final String filePath = "fileName";
	
	

public void remove(Task3 t)
{
		tasks.remove(t);
		
		
		
	}
	public void add() {
		
		//Task3 t = new Task3();
		//tasks.add(t);
	
			System.out.print("Please enter the task title\n");
			String title = scanner.nextLine();
			
			System.out.print("Please enter the task project\n");
			String project = scanner.nextLine();
			
			System.out.print("Please enter the task date with format:dd/MM/yyyy\n");
			LocalDate date = validateDate();
			
			Task3 tt = new Task3(title, project, date);
			tasks.add(tt);

			
	
	}
	
	
	public LocalDate validateDate() 
	{
		String dateString;
		LocalDate date = null;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do
		{
			try 
			{
				dateString = scanner.nextLine();
				date = LocalDate.parse(dateString, dateFormat);
			} catch(Exception e) 
			{
				System.out.println("please enter the correct format : dd/MM/yyyy"
						+ "");
			}
		}while(date.compareTo(LocalDate.now()) < 0);
		return date;
	}
		

	public void filterByProject() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Project");
		String project = scanner.nextLine();
		List<Task3> l = tasks.stream().filter(x ->x.getProject().equals(project)).collect(Collectors.toList());
		
		System.out.println(l);
		
	}
	
	public void sortByDate() {
		//Scanner scanner = new Scanner(System.in);
		//System.out.println("Enter Date");
		//String date= scanner.nextLine();
		@SuppressWarnings("unlikely-arg-type")
		//List<Task3> k = tasks.stream().filter(x ->x.getDate().equals(date)).collect(Collectors.toList());
		List <Task3> k = tasks.stream().sorted(Comparator.comparing(Task3::getDate)).collect(Collectors.toList());
       
		System.out.println(k);
		
	}
  
	public void menu() {
		
		System.out.println("(1) Show Task List\n");
		System.out.println("(2)Add new  Task \n");
		System.out.println("(3) Exit");
		System.out.println("(4) Filter by Project\n");
		System.out.println("(5)  Show by Date\n");
		
		Scanner scanner = new Scanner(System.in);
		
		int choice = scanner.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Choice 1 selected  \n");
			System.out.println(tasks);
			menu();
			break;
		case 2 :
			System.out.println("Choice 2 selected\n");
			add();
			menu();
			break;
			
		case 3 :
			System.out.println("Choice 3 selected\n");
			System.out.println("Exit");
			save();
			System.exit(0);
			
		case 4 :
			System.out.println("Choice 4 selected\n");
			filterByProject();
			menu();
			break;
		case 5 :
			System.out.println("Choice 5 selected\n");
			sortByDate();
			menu();
			break;
			
		
		}
	}
	
	public boolean  save() {
		
		boolean success = false;
		try {
			FileOutputStream fos= new FileOutputStream (filePath);
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			ois.writeObject(tasks);
			
			
			success = true;
		}catch(Exception e) {
			//System.out.println(e.getMessage());
			e.printStackTrace();
		}
		return success;
	}
	
	public void load() {
		boolean success = false;
		
		try{
			FileInputStream fis = new FileInputStream(filePath);
			ObjectInputStream ois = new ObjectInputStream(fis);
			tasks = (ArrayList<Task3>) ois.readObject();
			ois.close();
			success = true; 
			} catch (Exception e){
				e.printStackTrace();
	        }
		if (success == true) {
			System.out.println("Load is successful");
	        }
		
		}
	
	
	
	public static void main(String[] args)  {
			
			
		ToDoList3 toDoList = new ToDoList3(); 
			toDoList.load();
		toDoList.menu();
		
			
			
	}
	
			
			
			
			

			
	
		  

}
