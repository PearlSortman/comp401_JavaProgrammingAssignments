package graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import bus.uigen.OEFrame;
import bus.uigen.ObjectEditor;
import scannerBean.ScannerBean;
import table.ACommandInterpreter;
import table.Table;
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
		
		newScanner = new ScannerBean();
		
		avatarTable.put("arthur", arthur);
		avatarTable.put("galahad", galahad);
		avatarTable.put("lancelot", lancelot);
		avatarTable.put("robin", robin);
		avatarTable.put("guard", guard);
		
	}
	
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
	
	// this method is used to animate the scene with several scenarios.
	public void testingMethod() {
		
		avatarEditor = ObjectEditor.edit(this);
		avatarEditor.hideMainPanel();
		avatarEditor.setLocation(0, 0);
		//avatarEditor.getDrawComponent().setBackground(new Color(90, 90, 90));
		avatarEditor.setSize(1400, 800);
		
		approach(arthur);
		ThreadSupport.sleep(1000);

		newTest = new ACommandInterpreter(this, newScanner);
		newTest.setCommandInput("move arthur 50 100 ");
		newTest.setCommandInput("say arthur \"Test quote.\" ");
		
		newTest.setCommandInput("move galahad 60 400 ");
		ThreadSupport.sleep(1000);
		newTest.setCommandInput("say galahad \"I am galahad.\" ");
		ThreadSupport.sleep(1000);
		
		newTest.setCommandInput("move lancelot 100 100 ");
		ThreadSupport.sleep(1000);
		newTest.setCommandInput("say lancelot \"TESTINGGGGG!!!\" ");
		ThreadSupport.sleep(1000);
		
		newTest.setCommandInput("move robin 200 0 ");
		ThreadSupport.sleep(1000);
		newTest.setCommandInput("say robin \"Hello good friends :)\" ");
		ThreadSupport.sleep(1000);

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
		
		knightTurn = newTest.getTurn();
		if (occupied) {
			if (knightTurn == false) {
				guard.getText().setText(spokenText);
				//avatarEditor.refresh();
				ThreadSupport.sleep(5000);
				guard.getText().setText("");
				//avatarEditor.refresh();
			}	
			else if (knightTurn == true) {
				currentAvatar = (AnAvatar) newTest.getAvatar();
				currentAvatar.getText().setText(spokenText);
				//avatarEditor.refresh();
				ThreadSupport.sleep(5000);
				currentAvatar.getText().setText("");
				//avatarEditor.refresh();
			}
			
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
				avatarEditor.refresh();
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
	public OEFrame getAvatarEditor() { return avatarEditor; }
	public boolean getOccupied() { return occupied; }
	public boolean getPass() { return pass; }
	public boolean getKnightTurn() { return knightTurn; }
//	public boolean setKnightTurn(boolean turn) {
//		turn = knightTurn;
//		return knightTurn;
//	}
	@Visible(false)
	public Table getAvatarTable() { return avatarTable; }

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub
	}
	
}
