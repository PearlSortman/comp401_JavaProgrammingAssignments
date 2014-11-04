package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"Word Token"})
public class Word extends ACommandToken {
	
	public Word(String originalString) {
		super(originalString);
	}

}
