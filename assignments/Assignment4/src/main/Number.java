package main;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "numberValue"})
@Tags({"Number Token"})
public class Number implements TokenInterface, NumberTokenInterface {
	
	private String originalString;
	private int numberValue;

	public Number(String originalString) {
		this.originalString = originalString;
		numberValue = Integer.parseInt(originalString);
	}
	
	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public int getNumberValue() {
		return numberValue;
	}
	
}
