package linesAndShapes;

import java.awt.Color;

public interface ShapeInterface {
	
	public Color getColor();
	public void setColor(Color newColor);
	
	public boolean getFilled();
	public void setFilled(boolean newFilled);
	
	public int getX();
	public void setX(int newX);
	
	public int getY();
	public void setY(int newY);
	
	public int getWidth();
	public void setWidth(int newWidth);
	
	public int getHeight();
	public void setHeight(int newHeight);

}
