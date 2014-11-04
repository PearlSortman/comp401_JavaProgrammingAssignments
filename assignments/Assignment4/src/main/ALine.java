package main;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"angle", "x", "y", "width", "height"})
@PropertyNames({"radius", "angle", "x", "y", "width", "height"})
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"Rotating Line"})
public class ALine implements LineInterface {

	double radius, angle;
	int x, y, width, height;

	@Tags({"rotate"})
	public ALine (int initialX, int initialY, int initialWidth, int initialHeight, double initialRadius, double initialAngle) {
		x = initialX;
		y = initialY;
		width = initialWidth;
		height = initialHeight;	
		radius = Math.sqrt(initialX*initialX + initialY*initialY);
		angle = Math.atan((double) initialY/initialX);
	}
	
	public double getAngle() {return angle;}
	public double getRadius() {return radius;}
	
	public int getX() {return x;}
	public void setX(int newX) {
		x = newX;
	}
	
	public int getY() {return y;}
	public void setY(int newY) {
		y = newY;
	}
	
	// Uses the width to set the radius and angle.
	public int getWidth() {
		return (int) (radius*Math.cos(angle));
	}
	public void setWidth(int newWidth) {
		width = newWidth;
	}
	
	// Uses the height to set the radius and angle.
	public int getHeight() {
		return (int) (radius*Math.sin(angle));
	}
	public void setHeight(int newHeight) {
		height = newHeight;
	}

	public void setAngle(int newAngle) {
		angle = newAngle;
	}

}