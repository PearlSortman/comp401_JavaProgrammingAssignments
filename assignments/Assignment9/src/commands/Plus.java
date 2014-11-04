package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Plus Token"})
public class Plus extends AToken {
	
	public Plus (String originalString) {
		super(originalString);
	}

}
