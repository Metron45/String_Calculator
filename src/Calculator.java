
public class Calculator {
	
	int Add(String numbers) throws Exception {
		int result = 0;
		String delimiter = ",|\\n";
		boolean doThrow = false; 
		String negatives = "";
		
		if(numbers.matches("//.+\\n.+")) {
			delimiter = numbers.split("\\n", 2)[0].substring(2);
			numbers = numbers.split("\\n", 2)[1];
		}

		for(String number : numbers.split(delimiter)) {
			try {
				result += Integer.valueOf(number);
			}catch(java.lang.NumberFormatException e) {
				if(number.matches("-[0-9]+")) {
					doThrow = true;
					negatives.concat(" " + number);
				}
			}
		}
		
		if(doThrow == true) {
			throw new Exception("negatives not allowed" + negatives);
		}
		
		return result;
	} 
}