package Assignment2;

import java.util.Scanner;

public class Assignment2_Pt1 {

	public static void main(String[] args) {

		try {
			new Assignment2_Pt1().run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void run() throws Exception {

		Scanner myKeyboard = new Scanner(System.in);
		String myInputString = myKeyboard.nextLine();

		while (!myInputString.startsWith(".")) {

			int startIndex = 0;
			int stopIndex = 0;

			String mySubstring = "";

			boolean isQuote = false;

			while (++stopIndex < myInputString.length()) {

				if (startIndex >= myInputString.length()) {
					break;
				}

				if (myInputString.charAt(startIndex) == '"' || isQuote) {

					isQuote = true;

					if (stopIndex + 1 < myInputString.length() && myInputString.charAt(stopIndex + 1) == '"') {
						mySubstring = myInputString.substring(startIndex + 1, stopIndex + 1);
						System.out.println("quoted string: " + mySubstring);
						isQuote = false;
						startIndex = stopIndex + 2;
					}
				} else if (Character.isDigit(myInputString.charAt(startIndex))) {

					if (!Character.isDigit(myInputString.charAt(stopIndex))) {
						mySubstring = myInputString.substring(startIndex, stopIndex);
						int currentValue = Integer.parseInt(mySubstring);
						startIndex = stopIndex + 1;
						System.out.println("number: " + currentValue);
					}
				} else if (Character.isLetter(myInputString.charAt(startIndex))) {

					if (!Character.isLetter(myInputString.charAt(stopIndex))) {
						mySubstring = myInputString.substring(startIndex, stopIndex + 1);
						startIndex = stopIndex + 1;
						System.out.println("word: " + mySubstring);
					}
				} else if (myInputString.charAt(stopIndex) == ' ') {
					startIndex++;
				}
			}
			myInputString = myKeyboard.nextLine();
		}
	}
}

class ScannerBean {

	public ScannerBean(){
		
	}
	
	String editable;

	public String getEditable() {
		return editable;
	}

	public void setEditable(String editable) {
		this.editable = editable;
		
		int startIndex = 0;
		int stopIndex = 0;

		String mySubstring = "";

		boolean isQuote = false;

		while (++stopIndex < editable.length()) {

			if (startIndex >= editable.length()) {
				break;
			}

			if (editable.charAt(startIndex) == '"' || isQuote) {

				isQuote = true;

				if (stopIndex + 1 < editable.length() && editable.charAt(stopIndex + 1) == '"') {
					mySubstring = editable.substring(startIndex + 1, stopIndex + 1);
					System.out.println("quoted string: " + mySubstring);
					isQuote = false;
					startIndex = stopIndex + 2;
				}
			} else if (Character.isDigit(editable.charAt(startIndex))) {

				if (!Character.isDigit(editable.charAt(stopIndex))) {
					mySubstring = editable.substring(startIndex, stopIndex);
					int currentValue = Integer.parseInt(mySubstring);
					startIndex = stopIndex + 1;
					System.out.println("number: " + currentValue);
				}
			} else if (Character.isLetter(editable.charAt(startIndex))) {

				if (!Character.isLetter(editable.charAt(stopIndex))) {
					mySubstring = editable.substring(startIndex, stopIndex + 1);
					startIndex = stopIndex + 1;
					System.out.println("word: " + mySubstring);
				}
			} else if (editable.charAt(stopIndex) == ' ') {
				startIndex++;
			}
		}

	}
}