package graphicsInterfaces;

import graphics.ALine;
import graphics.AShapeImage;
import graphics.AStringShape;
import graphics.AVShape;

public interface AvatarInterface {
	
	public void moveTheText(int newX, int newY);
	public void moveImage(int newX, int newY);
	public void moveArms(int newX, int newY);
	public void moveLegs(int newX, int newY);
	public void moveBody(int newX, int newY);
	public void moveAvatar (int newX, int newY);

	public AVShape getArms();
	public AVShape getLegs();
	public ALine getBody();
	public AShapeImage getImage();
	public AStringShape getText();
	
}
