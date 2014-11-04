package main;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import linesAndShapes.TheBridgeScene;
import scannerBean.ScannerBean;
import util.annotations.Tags;
//import util.annotations.PropertyNames;
import util.misc.ThreadSupport;

//@PropertyNames({"myTestInput", "editor1", "editor2", "aLine"})
@Tags({"Move Class"})
public class Assignment6 {
	
	public static void main (String[] args) {
		
		// Scans test strings and displays them in the ObjectEditor window.
		ScannerBean myTestInput = new ScannerBean();
		OEFrame editor1 = ObjectEditor.edit(myTestInput);
		editor1.setSize(500, 500);
		
		myTestInput.setMyTestInput("+ { MOvE APpROach 090 { saY \"hello!\" } cALL defIne - proceedAll");
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
				
		
		// Creates a new Bridge Scene and calls the testing method within it.
		TheBridgeScene newScene = new TheBridgeScene();
		newScene.testingMethod();
	}	
	
}	
