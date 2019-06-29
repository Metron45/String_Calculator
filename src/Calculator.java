
public class Calculator {
	
	int Add(String numbers) throws Exception {
		int result = 0;
		String delimiters = ",|\\n";
		boolean doThrow = false; 
		String negatives = "";
		
		if(numbers.matches("//.+\\n.+")) {
			delimiters = numbers.split("\\n", 2)[0].substring(2);
			if(delimiters.matches("\\[.+\\]")) {
				String tempDelimiters = "";
				for(String delimiter : delimiters.split("\\[")) {
					tempDelimiters.concat("|(" + delimiter.substring(0, delimiters.length()-1) + ")");
				}
				delimiters = tempDelimiters.substring(1, delimiters.length());
			}
			numbers = numbers.split("\\n", 2)[1];
		}

		for(String number : numbers.split(delimiters)) {
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