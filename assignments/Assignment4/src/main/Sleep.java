package main;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"sleep"})
public class Sleep implements TokenInterface, WordTokenInterface {
	
	private String originalString;
	private String lowerCaseWord;
	
	public Sleep(String originalString) {
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
