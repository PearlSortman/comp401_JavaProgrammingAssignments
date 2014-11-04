package otherTokens;
import commands.TokenInterface;

import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Plus Token"})
public class Plus implements TokenInterface {
	
	private String originalString;
	
	public Plus (String originalString) {
		this.originalString = originalString;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

}
