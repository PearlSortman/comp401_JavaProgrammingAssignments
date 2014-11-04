package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"End Token"})
public class EndToken extends AToken {
	
	public EndToken(String originalString) {
		super(originalString);
	}

}
