package graphics;
//import util.annotations.PropertyNames;
import graphicsInterfaces.AvatarInterface;
import util.annotations.Tags;
import util.annotations.StructurePatternNames;
import util.annotations.StructurePattern;

@Tags({"Avatar"})
//@PropertyNames({"x", "y", "arms,", "legs", "body", "theText", "image"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AnAvatar extends MyLocatable implements AvatarInterface {

	AVShape arms;
	AVShape legs;
	ALine body;
	AStringShape theText;
	AShapeImage image;
	
	@Tags({"connect"})
	public AnAvatar (String theTextString, String imageFileName, int initX, int initY, int initRadius, int initAngle) {
		super(initX, initY);
		theText = new AStringShape(theTextString, initX + 20, initY - 90);
		image = new AShapeImage(imageFileName, initX -45/2, initY - 60, 60, 45);
		arms = new AVShape(initX, initY + 10, initRadius -20, initAngle);
		legs = new AVShape(initX, initY + initRadius, initRadius, initAngle);
		body = new ALine(initX, initY, initRadius, 0);
	}
	
	public void moveTheText(int newX, int newY) {
		theText.setX(theText.getX()+newX);
		theText.setY(theText.getY()+newY);
	}
	
	public void moveImage(int newX, int newY) {
		image.setX(image.getX()+newX);
		image.setY(image.getY()+newY);
	}
	
	public void moveArms(int newX, int newY) {
		arms.setX(arms.getX()+newX);
		arms.setY(arms.getY()+newY);
	}
	
	public void moveLegs(int newX, int newY) {
		legs.setX(legs.getX()+newX);
		legs.setY(legs.getY()+newY);
	}
	
	public void moveBody(int newX, int newY) {
		body.setX(body.getX()+newX);
		body.setY(body.getY()+newY);
	}
	
	@Tags({"move"})
	public void moveAvatar (int newX, int newY) {
		moveTheText(newX, newY);
		moveImage(newX, newY);
		moveArms(newX, newY);
		moveLegs(newX, newY);
		moveBody(newX, newY);
	}

	public AVShape getArms() { return arms; }
	public AVShape getLegs() { return legs; }
	public ALine getBody() { return body; }
	public AShapeImage getImage() { return image; }
	public AStringShape getText(){return theText;}
	public void setTheText(AStringShape newText) {
		theText = newText;
	}
	
}
