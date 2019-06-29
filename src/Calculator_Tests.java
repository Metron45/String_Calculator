import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Calculator_Tests {

	@Test
	void testAdd() {
		Calculator calc = new Calculator();
		assertEquals(0, calc.Add(""));
		assertEquals(3, calc.Add("3"));
		assertEquals(4, calc.Add("4"));
		assertEquals(9, calc.Add("3,6"));
		assertEquals(12, calc.Add("8,4"));
	}

	@Test
	void testAddUnknown() {
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3"));
		assertEquals(10, calc.Add("4,6"));
		assertEquals(18, calc.Add("3,6,8,1"));
		assertEquals(20, calc.Add("8,4,3,2,1,1,1"));
	}
	
	@Test
	void testAddNotNumber() {
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3,er"));
		assertEquals(0, calc.Add("a"));
	}
	
	@Test
	void testAddNewLine() {
		Calculator calc = new Calculator();
		assertEquals(3, calc.Add("3"));
		assertEquals(10, calc.Add("4\n6"));
		assertEquals(18, calc.Add("3,6\n8,1"));
		assertEquals(20, calc.Add("8,4,3\n2,1\n1,1"));
	}
}
