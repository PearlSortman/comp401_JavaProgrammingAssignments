package main;
import util.misc.ThreadSupport;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.Tags;
import util.annotations.PropertyNames;

@PropertyNames({"myTestInput", "editor1", "editor2", "aLine"})
@Tags({"Move Class"})
public class Assignment4 {
	
	public static void main (String[] args) {
	
		// Scans test strings and displays them in the ObjectEditor window.
		ScannerBean myTestInput = new ScannerBean();
		OEFrame editor1 = ObjectEditor.edit(myTestInput);
		editor1.setSize(500, 500);
		myTestInput.setMyTestInput("+ { MOvE 090 { saY \"hello!\" } cALL defIne - proceedAll");
		myTestInput.scan();
		editor1.refresh();
		ThreadSupport.sleep(5000);
		myTestInput.setMyTestInput("\"QUOTED String\" redO repeat rotateLEFTarm TeST { hi mOVe } 00800 ");
		myTestInput.scan();
		editor1.refresh();
		ThreadSupport.sleep(5000);
		myTestInput.setMyTestInput("helLO } UNDo sleeP Thread \"teSTING\" 08776 - { 0022 } MOvE ");
		myTestInput.scan();
		editor1.refresh();
		ThreadSupport.sleep(5000);
		myTestInput.setMyTestInput("00070 REPeaT rotateRightARM 022 { wait \"Quote\" sAY } wordS + ");
		myTestInput.scan();
		editor1.refresh();
		ThreadSupport.sleep(5000);
		
		// Defines a new line with specific dimensions and displays on ObjectEditor in a new frame.
		LineInterface aLine = new ALine(100, 100, 100, 100, 0, 0);
		OEFrame editor2 = ObjectEditor.edit(aLine);
		editor2.setSize(1000,300);
		
		// Rotates line using for loop.
		for(int i = 0;i < 500; i++) {
			ThreadSupport.sleep(50);
			aLine.setX(i);
			aLine.setAngle(i);
			editor2.refresh();
		}
	
	}
	
}
