import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

class Calculator_Tests {

	@Test
	void testAdd() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(0, calc.Add(""));
		assertEquals(3, calc.Add("3"));
		assertEquals(4, calc.Add("4"));
		assertEquals(9, calc.Add("3,6"));
		assertEquals(12, calc.Add("8,4"));
	}

	@Test
	void testAddUnknown() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3"));
		assertEquals(10, calc.Add("4,6"));
		assertEquals(18, calc.Add("3,6,8,1"));
		assertEquals(20, calc.Add("8,4,3,2,1,1,1"));
	}
	
	@Test
	void testAddNotNumber() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3,er"));
		assertEquals(0, calc.Add("a"));
	}
	
	@Test
	void testAddNewLine() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3"));
		assertEquals(10, calc.Add("4\n6"));
		assertEquals(18, calc.Add("3,6\n8,1"));
		assertEquals(20, calc.Add("8,4,3\n2,1\n1,1"));
	}
	
	@Test
	void testAddDelimiter() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("//k\n3"));
		assertEquals(10, calc.Add("//;\n4;6"));
		assertEquals(10, calc.Add("//;s\n4;s6"));
	}
	
	@Test
	void testAddNegative() throws Exception {
		Calculator calc = new Calculator();
		try {
			calc.Add("-3");
			fail();
		}catch(ArithmeticException e){
			assertEquals("negatives not allowed -3",e.getMessage());
		}
		
		try {
			calc.Add("-3,5,-6");
			fail();
		}catch(ArithmeticException e){
			assertEquals("negatives not allowed -3 -6",e.getMessage());
		}
	}
	
	@Test
	void testAddBigger() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3,1000"));
		assertEquals(10, calc.Add("4,1003,6"));
		assertEquals(18, calc.Add("3,6,2452,8,1"));
		assertEquals(19, calc.Add("8,4,3,2,1030,1,1"));
	}
	
	@Test
	void testAddDelimiterBrackets() throws Exception{
		Calculator calc = new Calculator();
		assertEquals(16, calc.Add("//[***][fg]\n1***5fg5***2***3"));
		assertEquals(10, calc.Add("//[;]\n4;6"));
		
	}
}
