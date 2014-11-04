package commands;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;
import util.annotations.Tags;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"approach"})
public class Approach extends ACommandToken {
	
	public Approach (String originalString) {
		super(originalString);
	}

}