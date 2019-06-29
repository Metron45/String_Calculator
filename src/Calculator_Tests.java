import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Calculator_Tests {

	@Test
	void test_add() {
		Calculator calc = new Calculator();
		assertEquals(0, calc.Add(""));
		assertEquals(3, calc.Add("3"));
		assertEquals(4, calc.Add("4"));
		assertEquals(9, calc.Add("3,6"));
		assertEquals(12, calc.Add("8,4"));
	}

}
