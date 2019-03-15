package todolist3;

 

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class FileHandler {
	private static final String filePath = "database2.txt";

	
	public static boolean save(ArrayList<Task> toWrite) {

		boolean success = false;
		  
		try {
			File file = new File("database2.txt");
		    // if file doesn't exists, then create it
		    if (!file.exists()) {
		      file.createNewFile();
		    }
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream ois = new ObjectOutputStream(fos);
			
			ois.writeObject(toWrite);
			
			
			ois.close();
			
			success = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return success;
	}

	
	public static ArrayList<Task> load() {

		File f = new File(filePath);
		ArrayList<Task> tasks = null;
		boolean success = false;
		if (f.exists())
		{
			

			try {
				FileInputStream fis = new FileInputStream(new File(filePath));
				ObjectInputStream ois = new ObjectInputStream(fis);
				tasks = (ArrayList<Task>) ois.readObject();
				ois.close();
			} catch (EOFException e) {
				System.out.println("EOF exception caught");
				success = true;
				System.out.println("the file is empty");
			} catch (Exception e) {
				System.out.println("another exception");
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
			
		}

	return tasks;
	}


}


