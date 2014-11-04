package scenes;
import graphics.ACircleShape;
import graphics.ARectangleShape;
import graphics.AnAvatar;
import interpreter.ACommandInterpreter;

import java.awt.GridLayout;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import listenersAndObservers.APropertyListenerSupport;
import listenersAndObservers.AnObservablePainter;
import listenersAndObservers.PropertyListenerSupport;
import controllers.AControllerObject;
import collections.Table;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import scannerBean.ScannerBean;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;
import util.misc.ThreadSupport;

@PropertyNames({"arthur", "galahad", "guard", "lancelot", "robin", 
				"occupied", "pass", "knightTurn", "avatarEditor", 
				"circleOne", "gorgeTwo", "circleTwo", "gorgeOne", "bridge"})

@Tags({"Bridge Scene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ABridgeScene implements BridgeSceneInterface {
	
	//OEFrame avatarEditor;
	JFrame commandIntFrame = new JFrame("Command Interpreter Frame");
	JTextField textField = new JTextField();
	JButton button = new JButton("ENTER");
	AControllerObject controller;
	
	AnObservablePainter observablePainter;
	JFrame frame = new JFrame("Assignment9 View");
	
	OEFrame avatarEditor;
	
	ARectangleShape bridge, gorgeOne, gorgeTwo;
	ACircleShape circleOne, circleTwo;
	AnAvatar arthur, galahad, lancelot, robin, guard;
	AnAvatar currentAvatar;
	ACommandInterpreter newTest;
	Table avatarTable = new Table();
	ScannerBean newScanner;
	boolean occupied = false;
	boolean pass;
	boolean knightTurn = false;
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	// this constructor establishes the 5 avatars, the bridge, the gorge, and any color fills.
	public ABridgeScene() {
		
		bridge = new ARectangleShape(850, 525, 300, 50);
		gorgeOne = new ARectangleShape(850, 0, 300, 525);
		gorgeTwo = new ARectangleShape(850, 575, 300, 200);
		circleOne = new ACircleShape(700, 500, 100, 100);
		circleTwo = new ACircleShape(550, 500, 100, 100);
		
		arthur = new AnAvatar("", "arthur.jpg", 100, 100, 60, 1);
		galahad = new AnAvatar("", "galahad.jpg", 300, 100, 60, 1);
		lancelot = new AnAvatar("", "lancelot.jpg", 100, 400, 60, 1);
		robin = new AnAvatar("", "robin.jpg", 250, 350, 60, 1);
		guard = new AnAvatar("", "guard.jpg", 750, 475, 60, 1);
		
		newScanner = new ScannerBean();
		
		avatarTable.put("arthur", arthur);
		avatarTable.put("galahad", galahad);
		avatarTable.put("lancelot", lancelot);
		avatarTable.put("robin", robin);
		avatarTable.put("guard", guard);
		
		avatarEditor = ObjectEditor.edit(this);
		avatarEditor.hideMainPanel();
		avatarEditor.setLocation(0, 0);
		avatarEditor.setSize(1400, 800);
	
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
	
	// this method is used to animate the scene with several scenarios.
	public void testingMethod() {
	  
		newTest = new ACommandInterpreter(this, newScanner);
		
		controller = new AControllerObject(newTest, textField, button);
		controller.setModel(newTest);
		commandIntFrame.setLayout(new GridLayout(2,1));
		commandIntFrame.add(textField);
		commandIntFrame.add(button);
		commandIntFrame.setSize(400, 400);
		commandIntFrame.setLocation(0, 0);
		commandIntFrame.setVisible(true);
		
		observablePainter = new AnObservablePainter(this);
		frame.add(observablePainter);
		frame.setSize(900, 800);
		frame.setLocation(400, 0);
		frame.setVisible(true);

		//Demo!!!!
		approach(arthur);
//		ThreadSupport.sleep(1000);
//		newTest.setCommandInput("move arthur 50 100 ");
//		newTest.setCommandInput("say \"Test quote.\" ");

	}
	
	@Tags({"Approach"})
	public void approach (AnAvatar avatar) {
		currentAvatar = avatar;
		int currentX = avatar.getX();
		int currentY = avatar.getY();
		// getting x and y from the knight's circle then x+50 and y-25 to get the knight to stand within that circle.
		int circleX = (circleTwo.getX() + 50);
		int circleY = (circleTwo.getY() - 25);
		// moves the avatar x and y distance determined by current position and desired position.
		int moveX = (circleX - currentX)/10;
		int moveY = (circleY - currentY)/10;
		
		// if the circle is not already occupied, then the passed in avatar will move to that spot.
		if (occupied == false) {
			for (int i=0; i<20; i++) {
				// Moves arms and legs to the down position of marching.
				avatar.getArms().getLeftLine().rotate(0);
				avatar.getArms().getRightLine().rotate(0);
				avatar.getLegs().getLeftLine().rotate(0);
				avatar.getLegs().getRightLine().rotate(0);
				ThreadSupport.sleep(200);
				
				// Moves arms and legs back to the v-shape position of marching.
				avatar.getArms().getLeftLine().rotate((int) ((5*Math.PI)/2));
				avatar.getArms().getRightLine().rotate((int) ((-5*Math.PI)/2));
				avatar.getLegs().getLeftLine().rotate((int) ((5*Math.PI)/2));
				avatar.getLegs().getRightLine().rotate((int) ((-5*Math.PI)/2));
				ThreadSupport.sleep(200);
				
				// Moves avatar on step closer to the circle.
				avatar.moveAvatar(moveX, moveY);
				ThreadSupport.sleep(50);
				i++;
			}
		
			// After the for loop runs successfully moving an avatar to the circle, that circle is now occupied.
			occupied = true;
			knightTurn = false;
		}
		
	}
	
	@Tags({"Say"})
	public void say (String spokenText) {
		
//		currentAvatar = (AnAvatar) newTest.getCurrentAvatar();
//		knightTurn = newTest.getTurn();
		occupied = true;

		if (knightTurn == false) {
			guard.getText().setText(spokenText);
//			ThreadSupport.sleep(5000);				
//			guard.getText().setText("");
		}	
		else if (knightTurn == true) {
//			currentAvatar = (AnAvatar) newTest.getAvatar();
			currentAvatar.getText().setText(spokenText);
//			ThreadSupport.sleep(5000);
//			currentAvatar.getText().setText("");
		}
				
		// Now that some avatar has spoken, it is now the opposite avatars 
		knightTurn = !knightTurn;	
	}
	
	@Tags({"Passed"})
	public void passed (AnAvatar avatar) {
		if (knightTurn == true && occupied == true) {
			for (int i=0; i<50; i++) {
				avatar.moveAvatar(i, 0);
				//avatarEditor.refresh();
				i++;
			}
			occupied = false;
		}
							
	}
	
	@Tags({"Failed"})
	public void failed (AnAvatar avatar) {
		if (knightTurn == true) {
			for (int i=0; i<35; i++) {
				avatar.moveAvatar(i, i/2);
				//avatarEditor.refresh();
				i++;
			}
			occupied =  false;
		}
		
		else if (knightTurn == false) {
			for (int i=0; i<35; i++) {
				guard.moveAvatar(i, i/2);
				//avatarEditor.refresh();
				i++;
			}
			occupied =  false;
		}
	}
	
	public ARectangleShape getBridge() { return bridge; }
	public ARectangleShape getGorgeOne() { return gorgeOne; }
	public ARectangleShape getGorgeTwo() { return gorgeTwo; }
	public ACircleShape getCircleOne() { return circleOne; }
	public ACircleShape getCircleTwo() { return circleTwo; }
	public AnAvatar getArthur() { return arthur; }
	public AnAvatar getGalahad() { return galahad; }
	public AnAvatar getGuard() { return guard; }
	public AnAvatar getLancelot() { return lancelot; }
	public AnAvatar getRobin() { return robin; }
	//public OEFrame getAvatarEditor() { return avatarEditor; }
	public boolean getOccupied() { return occupied; }
	public boolean getPass() { return pass; }
	public boolean getKnightTurn() { return knightTurn; }
	
	@Visible(false)
	public Table getAvatarTable() { return avatarTable; }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
	}
	
}
