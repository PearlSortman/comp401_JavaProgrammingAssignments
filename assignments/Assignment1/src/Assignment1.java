import java.util.Scanner;

public class Assignment1 {
	static int sum = 0;
	static int product = 1;
	
	public static void main(String[] args) {
		String myInputString = "";

		while (!myInputString.startsWith(".")) {
			myInputString = getNumberString();

			if (myInputString.startsWith(".")) {
				System.exit(0);
			}
			
			int startIndex = 0;
			int stopIndex = 0;
			
			String mySubstring = "";
			String numberList = "";
			
			while (stopIndex < myInputString.length()) {
				
				if (!Character.isDigit(myInputString.charAt(stopIndex))) {
					mySubstring = myInputString.substring(startIndex, stopIndex);
					startIndex = stopIndex + 1;
					int currentValue = Integer.parseInt(mySubstring);
					
					sum = sumCalculation(currentValue);
					product = product * currentValue;
					
					numberList = numberList + " " + currentValue;
				}
				
				stopIndex++;
			}

			System.out.print("Numbers:" + numberList);
			System.out.print(" ");
			System.out.print("Sum: " + sum);
			sum = 0;
			System.out.print(" ");
			System.out.println("Product: " + product);
			product = 1;
		}

	}
	
	public static String getNumberString() {
		Scanner myKeyboard = new Scanner(System.in);
		return myKeyboard.nextLine();	
	}
	
	static int sumCalculation(int currentValue) {
		sum = sum + currentValue;
		return sum;
	}
	
	static int productCalculation(int currentValue) {
		product = product * currentValue;
		return product;
	}
	
}
