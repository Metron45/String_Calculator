
public class Calculator {
	
	 public static void main(String[] args) {

	 }
	
	int Add(String numbers) {
		if(numbers.equals("")) {
			return 0;
		}else {
			String[] num = numbers.split(",");
			if(num.length == 1) {
				return Integer.valueOf(num[0]);
			}
			else if(num.length == 2) {
				return Integer.valueOf(num[0]) + Integer.valueOf(num[1]);
			}
		}
		return 0;
	}
}
