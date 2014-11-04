package linesAndShapes;
//import java.awt.Color;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import util.annotations.PropertyNames;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
//import util.misc.ThreadSupport;
import util.misc.ThreadSupport;

@PropertyNames({"arthur", "galahad", "guard", "lancelot", "robin", 
				"occupied", "pass", "knightTurn", "avatarEditor", 
				"circleOne", "gorgeTwo", "circleTwo", "gorgeOne", "bridge"})

@Tags({"Bridge Scene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class TheBridgeScene implements BridgeScene {
	
	// this constructor establishes the 5 avatars, the bridge, the gorge, and any color fills.
	public TheBridgeScene() {
		
		bridge = new ARectangleShape(850, 525, 300, 50);
//		bridge.setFilled(true);
//		bridge.setColor(Color.DARK_GRAY);
		gorgeOne = new ARectangleShape(850, 0, 300, 525);
//		gorgeOne.setFilled(true);
//		gorgeOne.setColor(Color.blue);
		gorgeTwo = new ARectangleShape(850, 575, 300, 200);
//		gorgeTwo.setFilled(true);
//		gorgeTwo.setColor(Color.blue);
		
		circleOne = new ACircleShape(700, 500, 100, 100);
//		circleOne.setFilled(true);
//		circleOne.setColor(Color.yellow);
		circleTwo = new ACircleShape(550, 500, 100, 100);
//		circleTwo.setFilled(true);
//		circleTwo.setColor(Color.orange);
		
		arthur = new AnAvatar("", "arthur.jpg", 100, 100, 60, 1);
		galahad = new AnAvatar("", "galahad.jpg", 300, 100, 60, 1);
		lancelot = new AnAvatar("", "lancelot.jpg", 100, 400, 60, 1);
		robin = new AnAvatar("", "robin.jpg", 250, 350, 60, 1);
		guard = new AnAvatar("", "guard.jpg", 750, 475, 60, 1);
		
	}
	
	OEFrame avatarEditor;
	ARectangleShape bridge, gorgeOne, gorgeTwo;
	ACircleShape circleOne, circleTwo;
	AnAvatar arthur, galahad, lancelot, robin, guard;
	boolean occupied = false;
	boolean pass;
	boolean knightTurn = false;
	
	// this method is used to animate the scene with several scenarios.
	public void testingMethod() {
		
		avatarEditor = ObjectEditor.edit(this);
		avatarEditor.hideMainPanel(); 
		avatarEditor.setLocation(0, 0);
		//avatarEditor.getDrawComponent().setBackground(new Color(90, 90, 90));
		avatarEditor.setSize(1400, 800);
		
		approach(arthur);
		knightTurn = false;
		say(arthur, "What is your quest?");
		say(arthur, "To pass this class!");
		say(arthur, "Okay, you pass.");
		pass = true;
		if (pass == true){ passed(arthur); } else if (pass == false) { failed(arthur); }

		approach(galahad);
		knightTurn = false;
		say(galahad, "Where are you going?");
		say(galahad, "I have no idea.");
		say(galahad, "What do you mean by that?");
		say(galahad, "Uhh...");
		say(galahad, "You fail!");
		pass = false;
		if (pass == true){ passed(galahad); } else if (pass == false) { failed(galahad); }
		
		approach(lancelot);
		knightTurn = false;
		say(lancelot, "How are you today?");
		say(lancelot, "I'm good, thanks.");
		say(lancelot, "You pass.");
		pass = true;
		if (pass == true){ passed(lancelot); } else if (pass == false) { failed(lancelot); }
		
		approach(robin);
		knightTurn = false;
		say(robin, "How old are you?");
		say(robin, "Twenty-One. How about you?");
		say(robin, "Ummmmm...");
		say(robin, "Fail!");
		pass = false;
		if (pass == true){ passed(robin); } else if (pass == false) { failed(robin); }
	}
	
	@Tags({"Approach"})
	public void approach (AnAvatar avatar) {
		int currentX = avatar.getX();
		int currentY = avatar.getY();
		int circleX = (circleTwo.getX() + 50);
		int circleY = (circleTwo.getY() - 25);
		int moveX = (circleX - currentX)/10;
		int moveY = (circleY - currentY)/10;
		
		if (occupied == false) {
			for (int i=0; i<20; i++) {
				avatar.getArms().getLeftLine().rotate(0);
				avatar.getArms().getRightLine().rotate(0);
				avatar.getLegs().getLeftLine().rotate(0);
				avatar.getLegs().getRightLine().rotate(0);
				avatarEditor.refresh();
				ThreadSupport.sleep(1);
				
				avatar.getArms().getLeftLine().rotate((int) ((5*Math.PI)/2));
				avatar.getArms().getRightLine().rotate((int) ((-5*Math.PI)/2));
				avatar.getLegs().getLeftLine().rotate((int) ((5*Math.PI)/2));
				avatar.getLegs().getRightLine().rotate((int) ((-5*Math.PI)/2));
				avatarEditor.refresh();
				
				avatar.moveAvatar(moveX, moveY);
				avatarEditor.refresh();
				i++;
			}
		occupied = true;
		}
		
	}
	
	@Tags({"Say"})
	public void say (AnAvatar avatar, String spokenText) {

		if (occupied) {
			if (knightTurn == false) {
				guard.getText().setText(spokenText);
				ThreadSupport.sleep(500);
				avatarEditor.refresh();
				ThreadSupport.sleep(1000);
				guard.getText().setText("");
				avatarEditor.refresh();
			}	
			else if (knightTurn == true) {
				avatar.getText().setText(spokenText);
				ThreadSupport.sleep(500);
				avatarEditor.refresh();
				ThreadSupport.sleep(1000);
				avatar.getText().setText("");
				avatarEditor.refresh();
			}
			
		}
		knightTurn = !knightTurn;	
	}
	
	@Tags({"Passed"})
	public void passed (AnAvatar avatar) {
		if (knightTurn == true && occupied == true) {
			for (int i=0; i<50; i++) {
				avatar.moveAvatar(i, 0);
				avatarEditor.refresh();
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
				avatarEditor.refresh();
				i++;
			}
			occupied =  false;
		}
		
		else if (knightTurn == false) {
			for (int i=0; i<35; i++) {
				guard.moveAvatar(i, i/2);
				avatarEditor.refresh();
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
	public OEFrame getAvatarEditor() { return avatarEditor; }
	public Boolean getOccupied() { return occupied; }
	public Boolean getPass() { return pass; }
	public Boolean getKnightTurn() { return knightTurn; }
	
}
