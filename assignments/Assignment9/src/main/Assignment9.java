package main;
import scenes.ABridgeScene;
import util.annotations.Tags;

//@PropertyNames({"myTestInput", "editor1", "editor2", "aLine"})
@Tags({ "Move Class" })
public class Assignment9 {
	
	public static void main (String[] args) {
		
		// Creates a new Bridge Scene and calls the testing method within it.
		ABridgeScene newScene = new ABridgeScene();
		newScene.testingMethod();
		
	}
	
}
