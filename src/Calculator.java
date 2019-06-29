
public class Calculator {
	
	int Add(String numbers) throws Exception {
		int result = 0;
		String delimiter = ",|\\n";
		boolean doThrow = false; 
		String negatives = "";
		
		if(numbers.matches("//.+\\n.+")) {
			delimiter = numbers.split("\\n", 2)[0].substring(2);
			if(delimiter.matches("\\[.+\\]")) {
				delimiter = delimiter.substring(1, delimiter.length()-1);
			}
			numbers = numbers.split("\\n", 2)[1];
		}

		for(String number : numbers.split(delimiter)) {
			try {
				if(Integer.valueOf(number) < 1000) {
					result += Integer.valueOf(number);
				}
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