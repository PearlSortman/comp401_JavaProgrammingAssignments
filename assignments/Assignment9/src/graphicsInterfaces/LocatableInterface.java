package graphicsInterfaces;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Locatable"})
public interface LocatableInterface extends PropertyListenerRegisterer {

	public int getX();
	public void setX(int newX);
	
	public int getY();
	public void setY(int newY);
	
}
