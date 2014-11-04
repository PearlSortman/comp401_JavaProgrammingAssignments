package main;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"End Token"})
public class EndToken implements TokenInterface {
	
	private String originalString;
	
	public EndToken(String originalString) {
		this.originalString = originalString;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}
	
}
