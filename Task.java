<<<<<<< HEAD
package todolist3;

 

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;



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
	

	@Override
	public String toString() {
		
		String s= " Title: "  + getTitle() + ", Date : " + getDate() + ", Project : " + getProject() + ", Completed : " + isDone + "\n";
		return s;
						
	}



	




=======
package todolist3;

 

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Scanner;



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
	

	@Override
	public String toString() {
		
		String s= " Title: "  + getTitle() + ", Date : " + getDate() + ", Project : " + getProject() + ", Completed : " + isDone + "\n";
		return s;
						
	}

>>>>>>> f321f340b1ec568020d5e4ffd9d0113d85a8c300
}