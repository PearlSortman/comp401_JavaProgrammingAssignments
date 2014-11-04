package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"say"})
public class Say extends ACommandToken {
	
	public Say(String originalString) {
		super(originalString);
	}

}
