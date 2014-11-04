package linesAndShapes;
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

	public ALine (int initX, int initY, double initRadius, double initAngle) {
		x = initX;
		y = initY;
		radius = (int) initRadius;
		angle = (int) initAngle;
		rotate((int)angle);
	}
	
	@Tags({"rotate"})
	public void rotate (int newAngle) {
		setAngle(newAngle);
		width = (int) (Math.sin(angle)*radius);
		height = (int) (Math.cos(angle)*radius);
	}
	
	public double getRadius() { return radius; }
	
	public double getAngle() { return angle; }
	public void setAngle(int newAngle) { angle = newAngle; }
	
	public int getX() { return x; }
	public void setX(int newX) { x = newX; }
	
	public int getY() {return y;}
	public void setY(int newY) { y = newY; }
	
	public int getWidth() { return width; }
	public void setWidth(int newWidth) { width = newWidth; }
	
	public int getHeight() { return height; }
	public void setHeight(int newHeight) { height = newHeight; }

}