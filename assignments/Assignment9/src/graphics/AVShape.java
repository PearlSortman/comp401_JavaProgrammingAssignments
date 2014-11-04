package graphics;
//import util.annotations.PropertyNames;
import util.annotations.IsCompositeShape;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import graphicsInterfaces.VShapeInterface;

import java.awt.Color;

@IsCompositeShape(true)
@Tags({"Bridge Scene"})
//@PropertyNames({"x", "y", "leftLine", "rightLine"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class AVShape extends MyLocatable implements VShapeInterface {
	
	public ALine leftLine;
	public ALine rightLine;
	
	public Color getColor() { return Color.green; }
	
	public AVShape(int initX, int initY, int initRadius, int initAngle) {
		super(initX, initY);
		leftLine = new ALine(initX, initY, initRadius, initAngle);
		leftLine.rotate((int) ((5*Math.PI)/2));
		rightLine = new ALine(initX, initY, initRadius, initAngle);
		rightLine.rotate((int) ((-5*Math.PI)/2));
	}
	
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
