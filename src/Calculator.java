
public class Calculator {
	
	int Add(String numbers) {
		int result = 0;
		String delimiter = ",|\\n";
		
		if(numbers.matches("//.+\\n.+")) {
			delimiter = numbers.split("\\n", 2)[0].substring(2);
			numbers = numbers.split("\\n", 2)[1];
		}
		
		for(String number : numbers.split(delimiter)) {
			try {
				result += Integer.valueOf(number);
			}catch(java.lang.NumberFormatException e) {}
		}
		return result;
	} 
	
}
