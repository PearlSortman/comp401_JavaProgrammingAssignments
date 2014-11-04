package listenersAndObservers;
import java.awt.Graphics2D;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import util.annotations.Tags;

@Tags({"Paint Listener"})
public interface PaintListenerInterface extends PropertyChangeListener {
	
	public void paint (Graphics2D g);

	void propertyChange(PropertyChangeEvent arg0);

}
