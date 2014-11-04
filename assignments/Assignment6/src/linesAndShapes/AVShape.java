package linesAndShapes;
//import util.annotations.PropertyNames;
import util.annotations.IsCompositeShape;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import java.awt.Color;

@IsCompositeShape(true)
@Tags({"Bridge Scene"})
//@PropertyNames({"x", "y", "leftLine", "rightLine"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AVShape implements VShapeInterface {
	
	private LineInterface[] arrayLines = new LineInterface[2];
 	private int x, y;
	public ALine leftLine;
	public ALine rightLine;
	
	public Color getColor() { return Color.green; }
	
	public AVShape(int initX, int initY, int initRadius, int initAngle) {
		leftLine = new ALine(initX, initY, initRadius, initAngle);
		leftLine.rotate((int) ((5*Math.PI)/2));
		rightLine = new ALine(initX, initY, initRadius, initAngle);
		rightLine.rotate((int) ((-5*Math.PI)/2));
		x = initX;
		y = initY;
		arrayLines [0] = leftLine;
		arrayLines [1] = rightLine;
	}
	
	public LineInterface[] getVShapeArmsAndLegs() {
		return arrayLines;
	}
	
	public int getX() { return x; }
	public int getY() { return y; }
	public ALine getLeftLine() { return leftLine; }
	public ALine getRightLine() { return rightLine; }
	
	public void setX(int newX) { 
		leftLine.setX(newX);
		rightLine.setX(newX);
		x = newX; 
	}
	
	public void setY(int newY) { 
		leftLine.setY(newY);
		rightLine.setY(newY);
		y = newY; 
	}
	
}
