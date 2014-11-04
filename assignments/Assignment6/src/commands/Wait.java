package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"wait"})
public class Wait extends ACommandToken {

	public Wait(String originalString) {
		super(originalString);
	}

}
