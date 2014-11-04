package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"undo"})
public class Undo extends ACommandToken {

	public Undo(String originalString) {
		super(originalString);
	}

}
