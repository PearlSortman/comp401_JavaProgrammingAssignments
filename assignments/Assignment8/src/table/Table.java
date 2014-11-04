package table;
import java.util.ArrayList;

import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Table"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class Table implements TableInterface {

	private ArrayList<String> arrayKeys;
	private ArrayList<Object> arrayObjects;

	public Table() {
		arrayKeys = new ArrayList<String>();
		arrayObjects = new ArrayList<Object>();
	}

	public void put(String key, Object val) {
		// Checks if key is already associated with a value.
		// If not, associates key with a value.
		if (arrayKeys.contains(key) && !arrayObjects.contains(null)) {
			arrayObjects.set(arrayKeys.indexOf(key), val);
		}

		// If key already associated with a value, adds new association (key,
		// val) to collection of associations.
		else if (!arrayKeys.contains(key) && !arrayKeys.contains(null) && !arrayObjects.contains(null)) {
			arrayKeys.add(key);
			arrayObjects.add(val);
		}

//		System.out.println(arrayKeys);
//		System.out.println(arrayObjects);

	}

	public Object get(String key) {
		if (arrayKeys.contains(key)) {
			return arrayObjects.get(arrayKeys.indexOf(key));
		}

		else {
			return null;
		}
	}
	
	public ArrayList<String> getArrayKeys() { return arrayKeys; }
	public ArrayList<Object> getArrayObjects() { return arrayObjects; }

}
