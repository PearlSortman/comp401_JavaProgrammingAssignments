package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"rotateLeftArm"})
public class RotateLeftArm extends ACommandToken {

	public RotateLeftArm(String originalString) {
		super(originalString);
	}

}
