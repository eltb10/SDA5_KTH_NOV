package todolist3;

 
import org.junit.*;
import static org.junit.Assert.assertEquals;


public class TestJunit {
	@Test
	public void testSetup() {
		String str = "testing junit";
		assertEquals("testing junit",str);
	}

}
