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

public class Task implements Serializable{
	
	private static final String DATE_FORMAT = null;
	private String title;
	private LocalDate date;
	private boolean isDone;
	private String project;
	private static final long serialVersionUID=1L;
	
	
	
	public Task(String title, String project , LocalDate date) 
	{
		this.title = title;
		this.project = project;
		this.date = date;
		this.isDone = false;
	}
	
	
	
	public Task() {
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
	
	public void toggle()
	{
		isDone=!isDone;
	}
	
	public void markasDone() {
		isDone =true;
	}
	public void update() {
		
		setTitle(project);
		getDate();
		setProject();
		
	}
	

	@override
	public String toString() {
		
		String s= "Title: "  + getTitle() + ", Date :" + getDate() + ", Project :" + getProject() + ", Completed :" + isDone + "\n";
		return s;
						
	}

}
