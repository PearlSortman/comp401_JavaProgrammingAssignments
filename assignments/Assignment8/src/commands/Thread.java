package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"thread"})
public class Thread extends ACommandToken {

	public Thread(String originalString) {
		super(originalString);
	}

}
