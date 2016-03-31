import static org.junit.Assert.*;
import java.util.*;
import org.junit.*;
import org.junit.Test;

public class PinningTests {
	
	public int _r = 1000;
	private int _maxSize = 10000;
	public String getText = "";
	
	//The original convertToInt() method.
    public int convertToIntOld(int x) {
	   int c = 0;
	   String padding = "0";
        
	   while (c < _r) {
	       String l = new String("0");
	       padding += l;
	       c++;
	   } 
	
	   String n = padding + String.valueOf(x);
        
	   int q = Integer.parseInt(n);
        
	   return q;
    }
    
    //The refactored convertToInt() method.
    public int convertToIntNew(int x) {
        if (x < 0) 
            throw new NumberFormatException("This is not a valid input.");
        
        return x;
    }
    
    public String getText() {
    	return getText;
    }
    
    public void setText(String text) {
    	getText = text;
    }
    
    //The original toString() method.
    public String toStringOld() {
	   String toReturn = new String("");
	   String currentState = getText();
	   for (int j = 0; j < _maxSize; j++) {
	       toReturn += currentState;
	   }
	   if (toReturn.substring(0,1).equals("X")) {
	       return toReturn.substring(0,1);
	   } else {
		   return ".";
	   }
	}
    
    //The refactored toString() method.
    public String toStringNew() {
        if (getText().substring(0,1).equals("X"))
            return "X";
        else
            return ".";
    }
    
    //This text should return "X" if the first character in the 
    //String returned by getText() is "X", else it should return "."
    //It should cause a StringIndexOutOfBoundsException if getText()
    //returns an empty string.
    @Test
    public void toStringTest() {
    	setText("X");
    	assertEquals(toStringOld(), toStringNew());
    	setText("XYZ");
    	assertEquals(toStringOld(), toStringNew());
    	setText("A");
    	assertEquals(toStringOld(), toStringNew());
    	setText("ABC");
    	assertEquals(toStringOld(), toStringNew());
  
    	boolean failEmptyStringOld = false;
    	boolean failEmptyStringNew = false;
    	setText("");
    	
    	//The method originally throws a StringIndexOutOfBoundsException
    	//if getText() returns an empty string 	
    	try {
    		toStringOld();
    	}
    	catch (StringIndexOutOfBoundsException e) {
    		failEmptyStringOld = true;
    	}
    	
    	//The refactored method should also throw a StringIndexOutOfBoundsException
    	//if getText() returns an empty string 	
    	try {
    		toStringNew();
    	}
    	catch (StringIndexOutOfBoundsException e) {
    		failEmptyStringNew = true;
    	}   	
    	
    	assertTrue(failEmptyStringOld && failEmptyStringNew);
    }
    
    //Both of these methods should return the same integer passed in.
    //Negative values should cause a NumberFormatException.
    @Test
    public void convertToIntTest() {
    	assertEquals(convertToIntOld(0), convertToIntNew(0));
    	assertEquals(convertToIntOld(Integer.MAX_VALUE), convertToIntNew(Integer.MAX_VALUE));
    	
    	boolean negativeExceptionOld = false;
    	boolean negativeExceptionNew = false;
    	
    	//The original method fails if we pass in a negative integer.
    	try {
    		convertToIntOld(-1);
    	}
    	catch (NumberFormatException e) {
    		negativeExceptionOld = true;
    	}
    	
    	//The refactored method should fail if we pass in a negative integer.
    	try {
    		convertToIntNew(-1);
    	}
    	catch (NumberFormatException e) {
    		negativeExceptionNew = true;
    	}
    	assertTrue(negativeExceptionOld && negativeExceptionNew);
    }
}
