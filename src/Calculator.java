
public class Calculator {

	private String setDelimeters(String numbers) {
		if(numbers.matches("//.+\\n.+")) {
			String delimiters = numbers.split("\\n", 2)[0].substring(2);
			if(delimiters.matches("\\[.+\\]+")) {
				String tempDelimiters = "";
				for(String delimiter : delimiters.split("\\[")) {
					if(!delimiter.contentEquals("")) {
						delimiter = delimiter.replaceAll("\\*", "\\\\*");
						tempDelimiters = tempDelimiters.concat("|(" + delimiter.substring(0, delimiter.length()-1) + ")");
					}
				}
				delimiters = tempDelimiters.substring(1,tempDelimiters.length());
			}
			return delimiters;
		}
		return ",|\\n";
	}
	
	int Add(String numbers) throws Exception {
		int result = 0;	
		boolean doThrow = false;  
		String negatives = "";
		
		String delimiters = setDelimeters(numbers);
		if(numbers.matches("//.+\\n.+")) {
			numbers = numbers.split("\\n", 2)[1];
		}

		for(String number : numbers.split(delimiters)) {
			try {
				if(number.matches("-[0-9]+")) {
					doThrow = true;
					negatives = negatives.concat(" " + number);
				}else if(Integer.valueOf(number) < 1000) {
					result += Integer.valueOf(number);
				}
			}catch(java.lang.NumberFormatException e) {}
		}
		
		if(doThrow == true) {
			throw new ArithmeticException("negatives not allowed" + negatives);
		}
		
		return result;
	} 
	

	
	
}