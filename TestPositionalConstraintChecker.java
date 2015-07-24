import static org.junit.Assert.*;

import java.util.TreeMap;

import org.junit.Test;

public class TestPositionalConstraintChecker {

	@Test
	public void testConstraintChecker() {
		TreeMap<Integer,String> testarray = new TreeMap<Integer,String>();
		   testarray.put(1, "hi");
		   testarray.put(2,"hello");
		   testarray.put(3,"hell");
		   
		   String constraint = "h1i2";
		   TreeMap<Integer,String>testmap = new TreeMap<Integer,String>();
		   testmap.put(1,"hi");
		   assertEquals(testmap,PositionalConstraintChecker.ConstraintChecker(testarray, constraint));
		   constraint = "h1i2l3";
		   assertEquals(testmap,PositionalConstraintChecker.ConstraintChecker(testarray, constraint));
		   
	}

}
