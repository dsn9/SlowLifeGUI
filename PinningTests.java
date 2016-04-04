import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.Test;

public class PinningTests {
	
    //toString() should return "X" if the first character in the 
    //String returned by getText() is "X", else it should return "."
    @Test
    public void toStringNoMatchTest() {
    	Cell testCell = new Cell();
    	testCell.setText("A");
    	assertEquals(testCell.toStringInefficient(), testCell.toString());
    }
    
    //toString() should return "X" if the first character in the 
    //String returned by getText() is "X", else it should return "."
    @Test
    public void toStringMatchTest() {
    	Cell testCell = new Cell();
    	testCell.setText("X");
    	assertEquals(testCell.toStringInefficient(), testCell.toString());
    }
    
    //The toString() method should throw a 
    //StringIndexOutOfBoundsException if getText()
    //returns an empty string.
    @Test
    public void toStringErrorTest() {

    	Cell testCell = new Cell();
    	testCell.setText("");
    	
    	boolean failEmptyStringOld = false;
    	boolean failEmptyStringNew = false;
    	
    	try {
    		testCell.toStringInefficient();
    	}
    	catch (StringIndexOutOfBoundsException e) {
    		failEmptyStringOld = true;
    	}
    	
    	try {
    		testCell.toString();
    	}
    	catch (StringIndexOutOfBoundsException e) {
    		failEmptyStringNew = true;
    	}   	
    	
    	assertTrue(failEmptyStringOld && failEmptyStringNew);
    }
    
    //Negative input values should cause a NumberFormatException.
    @Test
    public void convertToIntNegativeTest() {
    	MainPanel panel = new MainPanel(10);
    	boolean negativeExceptionOld = false;
    	boolean negativeExceptionNew = false;
    	
    	try {
    		panel.convertToIntInefficient(-1);
    	}
    	catch (NumberFormatException e) {
    		negativeExceptionOld = true;
    	}
    	
    	try {
    		panel.convertToInt(-1);
    	}
    	catch (NumberFormatException e) {
    		negativeExceptionNew = true;
    	}
    	assertTrue(negativeExceptionOld && negativeExceptionNew);
    }
    
    //convertToInt() should return the same integer passed in.
    //This test uses zero as an edge case.
    @Test
    public void convertToIntZeroTest() {
    	MainPanel panel = new MainPanel(10);
    	assertEquals(panel.convertToIntInefficient(0), panel.convertToInt(0));
    }
    
    //convertToInt() should return the same integer passed in.
    //This test uses Java's max int value as an edge case.
    @Test
    public void convertToIntMaxTest() {
    	MainPanel panel = new MainPanel(10);
    	assertEquals(panel.convertToIntInefficient(Integer.MAX_VALUE), panel.convertToInt(Integer.MAX_VALUE));
    }
}
