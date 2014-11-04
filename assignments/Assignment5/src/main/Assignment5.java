package main;
import linesAndShapes.TheBridgeScene;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.Tags;
import util.annotations.PropertyNames;
import util.misc.ThreadSupport;

@PropertyNames({"myTestInput", "editor1", "editor2", "aLine"})
@Tags({"Move Class"})
public class Assignment5 {
	
	public static void main (String[] args) {
		
		TheBridgeScene newScene = new TheBridgeScene();
		OEFrame avatarEditor = ObjectEditor.edit(newScene);
		avatarEditor.setSize(800, 800);
		
		// Rotate left arm.
		newScene.getArthur().getArms().getLeftLine().rotate(100);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		newScene.getArthur().getArms().getLeftLine().rotate(60);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		newScene.getArthur().getArms().getLeftLine().rotate(-45);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);

		// Rotate right arm.
		newScene.getArthur().getArms().getRightLine().rotate(100);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		newScene.getArthur().getArms().getRightLine().rotate(60);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		newScene.getArthur().getArms().getRightLine().rotate(45);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		
		// Move avatars.
		newScene.getArthur().moveAvatar(200, 150);
		avatarEditor.refresh();
		ThreadSupport.sleep(1000);
		newScene.getGuard().moveAvatar(100, -50);
		avatarEditor.refresh();

	}
	
}
