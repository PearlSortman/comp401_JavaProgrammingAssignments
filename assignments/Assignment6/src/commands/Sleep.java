package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"sleep"})
public class Sleep extends ACommandToken {
	
	public Sleep(String originalString) {
		super(originalString);
	}

}
