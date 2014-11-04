package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"move"})
public class Move extends ACommandToken {
	
	public Move(String originalString) {
		super(originalString);
	}

}