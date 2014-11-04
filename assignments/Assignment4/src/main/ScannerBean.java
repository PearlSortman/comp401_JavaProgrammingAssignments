package main;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.EditablePropertyNames;
import util.annotations.PropertyNames;

@EditablePropertyNames({"originalString", "myTestInput"})
@PropertyNames({"originalString", "largeArray", "compactArray", "arrayIndex", "startIndex", "stopIndex", "isQuote", "mySubstring"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
@Tags({ "Scanner Bean" })
public class ScannerBean implements TokenInterface, ScannerBeanInterface {

	private String originalString;
	private TokenInterface[] largeArray = new TokenInterface[100];
	TokenInterface[] compactArray;
	int arrayIndex = 0;
	
	public void setMyTestInput(String myTestInput) {
		originalString = myTestInput;
	}

	public String getOriginalString() {
		return originalString;
	}

	public void setOriginalString(String originalString) {
		this.originalString = originalString;
	}

	public TokenInterface[] getCompactArray() {
		return compactArray;
	}
	
	public void scan() {

		int startIndex = 0;
		int stopIndex = 0;
		
		boolean isQuote = false;
		String mySubstring = "";
				
		
		while (++stopIndex < originalString.length()) {

			// Ends the loop when the end of the input string is reached.
			if (startIndex >= originalString.length()) {
				break;
			}

			// Checks for beginning quotes and once found, creates substring of everything inside the quotes. Also adds quote to largeArray.
			if (originalString.charAt(startIndex) == '"' || isQuote) {
				isQuote = true;
				
				if (stopIndex + 1 < originalString.length() && originalString.charAt(stopIndex + 1) == '"') {
					mySubstring = originalString.substring(startIndex + 1, stopIndex + 1);
					TokenInterface quote = new QuotedString(mySubstring);
					isQuote = false;
					startIndex = stopIndex + 3;
					stopIndex = startIndex;
					largeArray[arrayIndex ++] = quote;
					continue;
				}
			}
			
			// If the token is anything other than a quote, we find the substring here then determine what type of token it is.
			if ((originalString.charAt(stopIndex) == ' ') && (isQuote == false)) {
				mySubstring = originalString.substring(startIndex, stopIndex);
				startIndex = stopIndex + 1;
				analyzeTokens(mySubstring);
			}
			
		}
		
		compactArray = new TokenInterface [arrayIndex];
		
		// Once the entire string has been scanned and tokens added to the largeArray.
		// This loop copies those tokens into the compactArray with the exact size of the originalString.
		for (int index = 0; index < arrayIndex; index ++) {
			compactArray[index] = largeArray[index];
			largeArray[index] = null;
		}
		
		// Reset arrayIndex to 0 so the next input string creates a new array instead of building upon the previous one.
		arrayIndex = 0;
	}

	// Private method to analyze all substrings that are not quotes. During this process, tokens are added to largeArray once token type determined.
	private void analyzeTokens(String mySubstring) {
		
		 if (mySubstring.equalsIgnoreCase("move")) {
		 TokenInterface move = new Move(mySubstring);
		 move.setOriginalString(mySubstring);
		 largeArray[arrayIndex] = move;
		 arrayIndex++;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("say")) {
		 TokenInterface say = new Say(mySubstring);
		 say.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = say;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("rotateleftarm")) {
		 TokenInterface rotateLeft = new RotateLeftArm(mySubstring);
		 rotateLeft.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = rotateLeft;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("rotaterightarm")) {
		 TokenInterface rotateRight = new RotateRightArm(mySubstring);
		 rotateRight.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = rotateRight;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("repeat")) {
		 TokenInterface repeat = new Repeat(mySubstring);
		 repeat.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = repeat;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("define")) {
		 TokenInterface define = new Define(mySubstring);
		 define.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = define;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("call")) {
		 TokenInterface call = new Call(mySubstring);
		 call.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = call;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("thread")) {
		 TokenInterface thread = new Thread(mySubstring);
		 thread.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = thread;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("wait")) {
		 TokenInterface wait = new Wait(mySubstring);
		 wait.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = wait;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("proceedall")) {
		 TokenInterface proceedAll = new ProceedAll(mySubstring);
		 proceedAll.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = proceedAll;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("sleep")) {
		 TokenInterface sleep = new Sleep(mySubstring);
		 sleep.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = sleep;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("undo")) {
		 TokenInterface undo = new Undo(mySubstring);
		 undo.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = undo;
		 }
		
		 else if (mySubstring.equalsIgnoreCase("redo")) {
		 TokenInterface redo = new Redo(mySubstring);
		 redo.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = redo;
		 }	
		 
		 // Tokenize any word other than a known command.
		 else if (Character.isLetter(mySubstring.charAt(0))) { 
		 TokenInterface word = new Word(mySubstring);
		 word.setOriginalString(mySubstring);
		 largeArray[arrayIndex ++] = word;
		 }
		
		 else if (Character.isDigit(mySubstring.charAt(0))) {
		 TokenInterface number = new Number(mySubstring);
		 largeArray[arrayIndex ++] = number;
		 }
		
		 else if (mySubstring.equals("{")) {
		 TokenInterface startToken = new StartToken(mySubstring);
		 largeArray[arrayIndex ++] = startToken;
		 }
		
		 else if (mySubstring.equals("}")) {
		 TokenInterface endToken = new EndToken(mySubstring);
		 largeArray[arrayIndex ++] = endToken;
		 }
		
		 else if (mySubstring.equals("+")) {
		 Plus plus = new Plus(mySubstring);
		 largeArray[arrayIndex ++] = plus;
		 }
		
		 else if (mySubstring.equals("-")) {
		 Minus minus = new Minus(mySubstring);
		 largeArray[arrayIndex ++] = minus;
		 }
		
	}

}
