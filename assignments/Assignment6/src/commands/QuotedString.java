package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Quote Token"})
public class QuotedString extends AToken {
	
	public QuotedString(String originalString) {
		super(originalString);
	}

}
