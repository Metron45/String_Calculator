import static org.junit.jupiter.api.Assertions.*;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class Calculator_Tests {

	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		try {
			assertEquals(0, calc.Add(""));
			assertEquals(3, calc.Add("3"));
			assertEquals(4, calc.Add("4"));
			assertEquals(9, calc.Add("3,6"));
			assertEquals(12, calc.Add("8,4"));
		} catch(Exception e) {}
	}

	@Test
	void testAddUnknown() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("3"));
			assertEquals(10, calc.Add("4,6"));
			assertEquals(18, calc.Add("3,6,8,1"));
			assertEquals(20, calc.Add("8,4,3,2,1,1,1"));
		} catch(Exception e) {}
	}
	
	@Test
	void testAddNotNumber() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("3,er"));
			assertEquals(0, calc.Add("a"));
		} catch(Exception e) {}
	}
	
	@Test
	void testAddNewLine() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("3"));
			assertEquals(10, calc.Add("4\n6"));
			assertEquals(18, calc.Add("3,6\n8,1"));
			assertEquals(20, calc.Add("8,4,3\n2,1\n1,1"));
		} catch(Exception e) {}

	}
	
	@Test
	void testAddDelimiter() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("//k\n3"));
			assertEquals(10, calc.Add("//;\n4;6"));
			assertEquals(10, calc.Add("//;s\n4;s6"));
		} catch(Exception e) {}
	}
	
	@Rule
	public final ExpectedException exception = ExpectedException.none();
	
	@Test
	void testAddNegative() {
		Calculator calc = new Calculator();
		exception.expect(Exception.class);
		try {
			calc.Add("//k\n-3");
		} catch(Exception e) {}
		try {
			calc.Add("//;s\n-4;s6");
		} catch(Exception e) {}
		try {
			calc.Add("-3");
		} catch(Exception e) {}
		try {
			calc.Add("-4,-6");
		} catch(Exception e) {}
		try {
			calc.Add("-8,4,-3,2,-1,1,1");
		} catch(Exception e) {}
	}
	
	@Test
	void testAddBigger() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("3,1000"));
			assertEquals(10, calc.Add("4,1003,6"));
			assertEquals(18, calc.Add("3,6,2452,8,1"));
			assertEquals(19, calc.Add("8,4,3,2,1030,1,1"));
		} catch(Exception e) {}
	}
	
	@Test
	void testAddDelimiterBrackets() {
		Calculator calc = new Calculator();
		try {
			assertEquals(3, calc.Add("//[k]\n3"));
			assertEquals(10, calc.Add("//[;]\n4;6"));
			assertEquals(10, calc.Add("//[;s]\n4;s6"));
			assertEquals(10, calc.Add("//[***]\n1***2***3"));
		} catch(Exception e) {}
	}
}
