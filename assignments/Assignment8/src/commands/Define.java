package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"define"})
public class Define extends ACommandToken {
	
	public Define(String originalString) {
		super(originalString);
	}

}
