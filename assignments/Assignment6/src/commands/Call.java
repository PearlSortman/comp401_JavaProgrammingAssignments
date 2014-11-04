package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"call"})
public class Call extends ACommandToken {
	
	public Call(String originalString) {
		super(originalString);
	}
	
}
