package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"redo"})
public class Redo extends ACommandToken {

	public Redo(String originalString) {
		super(originalString);
	}

}
