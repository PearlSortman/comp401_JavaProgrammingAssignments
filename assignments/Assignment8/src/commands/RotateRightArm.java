package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "lowerCaseWord"})
@Tags({"rotateRightArm"})
public class RotateRightArm extends ACommandToken {
	
	public RotateRightArm(String originalString) {
		super(originalString);
	}

}
