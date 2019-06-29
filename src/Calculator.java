
public class Calculator {
	
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		System.out.println(calc.Add(""));
		System.out.println(calc.Add("2,3"));
		System.out.println(calc.Add("4,5,6,7,7"));
	}
	
	int Add(String numbers) {
		int result = 0;
		for(String number : numbers.split(",")) {
			try {
				result += Integer.valueOf(number);
			}catch(java.lang.NumberFormatException e) {}
		}
		return result;
	} 
	
}
