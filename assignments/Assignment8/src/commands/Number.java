package commands;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString"})
@PropertyNames({"originalString", "numberValue"})
@Tags({"Number Token"})
public class Number extends ACommandToken implements NumberTokenInterface {

	private int numberValue;

	public Number(String originalString) {
		super(originalString);
		numberValue = Integer.parseInt(originalString);
	}
	
	public int getNumberValue() {
		return numberValue;
	}
	
}
