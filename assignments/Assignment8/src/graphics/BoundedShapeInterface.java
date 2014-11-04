package graphics;
import java.awt.Color;
import util.annotations.Tags;

@Tags({"Bounded Shape"})
public interface BoundedShapeInterface extends LocatableInterface {
	
	public Color getColor();
	public void setColor(Color newColor);
	
	public boolean getFilled();
	public void setFilled(boolean newFilled);

	public int getWidth();
	public void setWidth(int newWidth);
	
	public int getHeight();
	public void setHeight(int newHeight);

}
