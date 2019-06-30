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
	void testAddNegative() throws Exception {
		Calculator calc = new Calculator();
		exception.expect(Exception.class);
		exception.expectMessage("negatives not allowed -3");
		calc.Add("-3");
	}
	
	@Test
	void testAddNegativeMultiple() throws Exception {
		Calculator calc = new Calculator();
		exception.expect(Exception.class);
		exception.expectMessage("negatives not allowed -3 -4");
		calc.Add("-3,-4");
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
			assertEquals(3, calc.Add("//[k][y]\n3"));
			assertEquals(15, calc.Add("//[;][d]\n4;6d5"));
			assertEquals(13, calc.Add("//[;s][sd]\n4;s6sd1sd2"));
			assertEquals(15, calc.Add("//[***][fg]\n1***fg5***2***3"));
			assertEquals(6, calc.Add("//[*][%]\\n1*2%3"));
			assertEquals(6, calc.Add("//[**][%*]\\n1**2%*3"));
			assertEquals(6, calc.Add("//[sd][%*]\\n1sd2%*3"));
		} catch(Exception e) {}
	}
}
