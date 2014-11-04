package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"ACommandToken"})
public class ACommandToken implements TokenInterface, WordTokenInterface {

	private String originalString;
	private String lowerCaseWord;
	
	public ACommandToken (String originalString) {
		this.originalString = originalString;
		lowerCaseWord = originalString.toLowerCase();
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public String getLowerCaseWord() {
		return lowerCaseWord;
	}
	
}
