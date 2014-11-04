package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"AToken"})
public class AToken implements TokenInterface {

private String originalString;
	
	public AToken (String originalString) {
		this.originalString = originalString;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}
	
}
