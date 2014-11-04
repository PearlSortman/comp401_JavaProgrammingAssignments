package graphics;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import util.annotations.Tags;

@Tags({"Locatable"})
public class MyLocatable implements LocatableInterface {
	
	int x, y;
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	public MyLocatable(int initX, int initY) {
		x = initX;
		y = initY;
	}
	
	public int getX() {
		return x;
	}

	public void setX(int newX) {
		int oldVal = x;
		x = newX;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "X",
				oldVal, newX));
	}

	public int getY() {
		return y;
	}

	public void setY(int newY) {
		int oldVal = y;
		y = newY;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Y",
				oldVal, newY));
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertySupport.add(listener);
	}
	
}
