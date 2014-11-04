package linesAndShapes;

import bus.uigen.OEFrame;

public interface BridgeScene {

	public ARectangleShape getBridge();
	public ARectangleShape getGorgeOne();
	public ARectangleShape getGorgeTwo();
	public ACircleShape getCircleOne();
	public ACircleShape getCircleTwo();
	public AnAvatar getArthur();
	public AnAvatar getGalahad();
	public AnAvatar getGuard();
	public AnAvatar getLancelot();
	public AnAvatar getRobin();
	public OEFrame getAvatarEditor();
	//public Boolean getOccupied();
	public Boolean getPass();
	public Boolean getKnightTurn();
	
}
