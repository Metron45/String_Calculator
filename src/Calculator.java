
public class Calculator {
	
	int Add(String numbers) {
		int result = 0;
		for(String number : numbers.split(",|\\n")) {
			try {
				result += Integer.valueOf(number);
			}catch(java.lang.NumberFormatException e) {}
		}
		return result;
	} 
	
}
