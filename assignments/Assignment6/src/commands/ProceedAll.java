package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"proceedAll"})
public class ProceedAll extends ACommandToken {
	
	public ProceedAll(String originalString) {
		super(originalString);
	}

}
