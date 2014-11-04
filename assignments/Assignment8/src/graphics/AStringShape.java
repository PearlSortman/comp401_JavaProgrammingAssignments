package graphics;
import java.beans.PropertyChangeEvent;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;

@StructurePattern(StructurePatternNames.STRING_PATTERN)
public class AStringShape extends MyLocatable implements StringShapeInterface {
	String text;

	public AStringShape(String initText, int initX, int initY) {
		super(initX, initY);
		text = initText;
	}
	
	public String getText() {return text;}
	public void setText(String newVal) {
		text = newVal;
		propertySupport.notifyAllListeners(new PropertyChangeEvent(this, "Text",
				text, newVal));
	}

}
