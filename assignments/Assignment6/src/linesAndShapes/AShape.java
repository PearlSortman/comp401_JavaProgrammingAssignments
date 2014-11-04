package linesAndShapes;
import java.awt.Color;

public class AShape implements ShapeInterface {
	
	int x, y, width, height;
	Color color;
	boolean filled;
	
	public Color getColor() { return color; }
	public void setColor(Color newColor) { color = newColor; }
	
	public boolean getFilled() { return filled; }
	public void setFilled(boolean newFilled) { filled = newFilled; }
	
	public AShape (int initX, int initY, int initWidth, int initHeight) {
		x = initX;
		y = initY;
		width = initWidth;
		height = initHeight;
	}
	
	public int getX() { return x; }
	public void setX(int newX) { x = newX; }
	
	public int getY() { return y; }
	public void setY(int newY) { y = newY; }
	
	public int getWidth() { return width; }
	public void setWidth(int newWidth) { width = newWidth; }
	
	public int getHeight() { return height; }
	public void setHeight(int newHeight) { height = newHeight; }

}
