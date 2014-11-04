package graphics;
import java.beans.PropertyChangeListener;
import table.Table;
import util.models.PropertyListenerRegisterer;
import bus.uigen.OEFrame;

public interface BridgeSceneInterface extends PropertyChangeListener, PropertyListenerRegisterer {

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
	public boolean getOccupied();
	public boolean getPass();
	public boolean getKnightTurn();
	public Table getAvatarTable();
}
