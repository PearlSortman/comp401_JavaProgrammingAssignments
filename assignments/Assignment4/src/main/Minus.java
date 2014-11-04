package main;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Minus Token"})
public class Minus implements TokenInterface {
	
	private String originalString;
	
	public Minus (String originalString) {
		this.originalString = originalString;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

}
