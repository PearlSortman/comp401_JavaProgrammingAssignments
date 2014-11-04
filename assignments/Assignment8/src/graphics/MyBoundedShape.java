package graphics;
import java.awt.Color;
import java.beans.PropertyChangeEvent;

import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Bounded Shape"})
public class MyBoundedShape extends MyLocatable implements BoundedShapeInterface {
	
	int width, height;
	Color color;
	boolean filled;
	
	@Visible(false)
	public Color getColor() { return color; }
	public void setColor(Color newColor) { color = newColor; }
	
	@Visible(false)
	public boolean getFilled() { return filled; }
	public void setFilled(boolean newFilled) { filled = newFilled; }
	
	public MyBoundedShape (int initX, int initY, int initWidth, int initHeight) {
		super(initX, initY);
		width = initWidth;
		height = initHeight;
	}
	
	public int getWidth() { return width; }
	public void setWidth(int newWidth) { 
		width = newWidth; 
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "New Width",
				width, newWidth));
	}
	
	public int getHeight() { return height; }
	public void setHeight(int newHeight) { 
		height = newHeight;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "New Height",
				height, newHeight));
	}

}
