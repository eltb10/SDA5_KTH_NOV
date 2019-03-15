package todolist3;

import static org.junit.Assert.assertEquals;

import java.io.StringWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class ListTest {
	
	@Test
	public void testAdd() {
		
	    String testTitle= "T8";
	    String testProject= "P8";
	    LocalDate testLocalDate= LocalDate.now();
	    boolean testIsDone= true;
	    
		Task task = new Task();
		task.setProject(testProject);
		task.setTitle(testTitle);
		task.setDate(testLocalDate);
		task.setDone(testIsDone);
		
		Assert.assertNotNull(task);
		Assert.assertEquals(testTitle, task.getTitle());
		Assert.assertEquals(testProject,task.getProject());
		Assert.assertEquals(testLocalDate, task.getDate());
		Assert.assertEquals(testIsDone, task.isDone());
	
	}
	@Test
	public void testToString() {
	    String result = " Title: code, Date : 2019-12-12, Project : project, Completed : false"
	    		+ "\n";
	    Task myInstance = new Task("code", "project" , LocalDate.parse("2019-12-12"));
		assertEquals(myInstance.toString(), result);

	}
		
		
}
		
	
