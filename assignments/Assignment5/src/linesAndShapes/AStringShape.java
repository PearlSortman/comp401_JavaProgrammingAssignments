package linesAndShapes;

public class AStringShape implements StringShapeInterface {
	String text;
	int x, y;

	public AStringShape(String initText, int initX, int initY) {
		text = initText;
		x = initX;
		y = initY;
	}
	public int getX() {return x;}
	public void setX(int newX) {x = newX;}
	public int getY() {return y;}
	public void setY(int newY) {y = newY;}
	public String getText() {return text;}
	public void setText(String newVal) {text = newVal;}

}
