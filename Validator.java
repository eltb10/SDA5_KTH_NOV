package todolist3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validator 
{
	private static Scanner scanner = new Scanner(System.in).useDelimiter("\n");
	

	public static int validateInt(int min, int max) {
		Scanner scanner = new Scanner(System.in);
		while (true) {
			try {
				System.out.println("Enter a number");
				int index = scanner.nextInt();

				if (index >= min && index <= max) {
					System.out.println("Index is inside size of list");
					return index;
				} else {
					System.out.println("please enter a value from " + min +" to " + max);
				} // 
			} catch (Exception e) {
				System.out.println("please enter a correct format");
			}
		}
	}
	
	
	public static LocalDate validateDate() 
	{
		String dateString;
		LocalDate date = null;
		DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		do {
			try {
				dateString = scanner.nextLine();
				date = LocalDate.parse(dateString, dateFormat);
				
			} catch (Exception e) {
				System.out.println("please enter the correct format : dd/MM/yyyy" + "");
			}
		} while (date.compareTo(LocalDate.now()) < 0);
		return date;
	}
	
	
	public static LocalDate getDateValidator()
	{
		System.out.println("please enter the correct date format dd/MM/yyyy");
		boolean isDueDate = false;
		LocalDate date = null;
		do {
			Scanner scan = null;
			String userInput = scan.nextLine();
			try {
				DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy  ");
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
	
	
	
}
