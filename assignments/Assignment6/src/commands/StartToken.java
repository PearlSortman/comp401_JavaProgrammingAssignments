package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Start Token"})
public class StartToken extends AToken {
	
	public StartToken(String originalString) {
		super(originalString);
	}

}
