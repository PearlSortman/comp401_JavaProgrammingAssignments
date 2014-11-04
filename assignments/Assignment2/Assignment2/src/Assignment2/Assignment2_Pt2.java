package Assignment2;

import java.util.Scanner;

public class Assignment2_Pt2 {

	public static void main(String[] args) {

		try {
			new Assignment2_Pt2().run();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	void run() throws Exception {

		Scanner myKeyboard = new Scanner(System.in);
		String myInputString = myKeyboard.nextLine();

		while (!myInputString.startsWith(".")) {

			ScannerBean scannerBean = new ScannerBean();
			scannerBean.setEditable(myInputString);
			
			myInputString = myKeyboard.nextLine();
		}
	}
}