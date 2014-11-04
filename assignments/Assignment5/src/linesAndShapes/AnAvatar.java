package linesAndShapes;
import util.annotations.Tags;
import util.annotations.StructurePatternNames;
import util.annotations.StructurePattern;

@Tags({"Avatar"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AnAvatar implements AvatarInterface {
	
	int x, y;
	AVShape arms;
	AVShape legs;
	ALine body;
	AStringShape theText;
	AShapeImage image;
	
	@Tags({"connect"})
	public AnAvatar (String theTextString, String imageFileName, int initX, int initY, int initRadius, int initAngle) {
		x = initX;
		y = initY;
		theText = new AStringShape(theTextString, initX + 20, initY - 70);
		image = new AShapeImage(imageFileName, initX -45/2, initY - 60, 60, 45);
		arms = new AVShape(initX, initY + 10, initRadius, initAngle);
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
	
	// @Visable(false)
	public int getX(){ return x; }	
	public int getY(){ return y; }

}
