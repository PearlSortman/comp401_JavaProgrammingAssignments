package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"repeat"})
public class Repeat extends ACommandToken {

	public Repeat(String originalString) {
		super(originalString);
	}

}
