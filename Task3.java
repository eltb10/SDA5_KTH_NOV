package todolist3;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

import todolist2.override;

public class Task3 implements Serializable{
	
	private static final String DATE_FORMAT = null;
	private String title;
	private LocalDate date;
	private boolean isDone;
	private String project;
	
	
	
	public Task3(String title, String project , LocalDate date) 
	{
		this.title = title;
		this.project = project;
		this.date = date;
		this.isDone = false;
	}
	
	
	
	public Task3() {
		// TODO Auto-generated constructor stub
	}



	public String getTitle() {
		return title;
	}



	public void setTitle(String title) {
		this.title = title;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}

   

	public static String getDateFormat() {
		return DATE_FORMAT;
	}



	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public void changeStatus() 
	{
		if(isDone == true)
			isDone = false;
		else
			isDone = true;
	}

	public String getStatus() 
	{
		if(isDone == true)
			return "done";
		else
			return "unDone";
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	public boolean isDone() {
		return isDone;
	}
	
	public String getProject() {
		return project;
	}
	public void setProject() {
		System.out.println("Enter Project");
		Scanner scanner = new Scanner(System.in);
		project=scanner.nextLine();
		
	}
	
	
	public void markasDone() {
		isDone =true;
	}
	public void update() {
		
		setTitle(project);
		getDate();
		setProject();
		
	}
	


	public LocalDate getDateValidator() {
			System.out.println("please enter the correct date format dd/MM/yyyy");
			boolean isDueDate = false;
			LocalDate date = null;
			do {
				Scanner scan = null;
				String userInput = scan.nextLine();
				try {
					DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					date = LocalDate.parse(userInput, dateFormat);
					System.out.println(date);
					isDueDate = true;
					if (date.isBefore(LocalDate.now())) throw new IllegalArgumentException("wrong date is entered");
					} catch (IllegalArgumentException e) {

			               System.out.println("date cannot be before today");

			               isDueDate = false;
			           } catch (DateTimeParseException exc) {
			               // TODO Auto-generated catch block
			               System.out.println("correct date format is \"dd/MM/yyyy\"");
			           }

			       } while (!isDueDate);
			return date;
			      
			 
			
			
		}	
		
		
		
				
		
	
	
	
	
	@override
	public String toString() {
		
		String s= "Title: "  + getTitle() + ", Date :" + getDate() + ", Project :" + getProject() + ", Completed :" + isDone + "\n";
		return s;
				
		
		
	}



	public static String size() {
		// TODO Auto-generated method stub
		return null;
	}



	

}
