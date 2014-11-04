package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString"})
@Tags({"Minus Token"})
public class Minus extends AToken {

	public Minus (String originalString) {
		super(originalString);
	}

}
