package graphics;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import java.awt.BasicStroke;
import java.awt.Stroke;

@EditablePropertyNames({ "x", "y", "width", "height" })
@PropertyNames({ "radius", "angle", "x", "y", "width", "height","stroke" })
@StructurePattern(StructurePatternNames.LINE_PATTERN)
@Tags({"Rotating Line"})
public class ALine extends MyBoundedShape implements LineInterface {

	double radius, angle;
	
	Stroke stroke = new BasicStroke(5.0f);
	public Stroke getStroke() { return stroke; }
	public void setStroke(BasicStroke newStroke) { stroke = newStroke; }

	public ALine(int initX, int initY, double initRadius, double initAngle) {
		super(initX, initY, 0, 0);
		radius = (int) initRadius;
		angle = (int) initAngle;
		rotate((int) angle);
	}

	@Tags({ "rotate" })
	public void rotate(int newAngle) {
		setAngle(newAngle);
	}

	public double getRadius() {
		return radius;
	}

	public double getAngle() {
		return angle;
	}

	public void setAngle(int newAngle) {
		angle = newAngle;
		setWidth((int) (Math.sin(angle) * radius));
		setHeight((int) (Math.cos(angle) * radius));
	}

}