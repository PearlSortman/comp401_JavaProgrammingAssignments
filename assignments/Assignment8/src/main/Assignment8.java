package main;
import graphics.ABridgeScene;
import graphics.AConsoleSceneView;
import util.annotations.Tags;

//@PropertyNames({"myTestInput", "editor1", "editor2", "aLine"})
@Tags({ "Move Class" })
public class Assignment8 {
	
	public static void main (String[] args) {
		
		// Creates a new Bridge Scene and calls the testing method within it.
		ABridgeScene newScene = new ABridgeScene();
		@SuppressWarnings("unused")
		AConsoleSceneView view = new AConsoleSceneView(newScene);
		newScene.testingMethod();
		
	}
	
}
