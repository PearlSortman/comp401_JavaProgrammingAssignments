package table;
import commands.ACommandToken;
import commands.Move;
import commands.QuotedString;
import commands.Say;
import commands.TokenInterface;
import commands.Word;
import commands.Number;
import graphics.ABridgeScene;
import graphics.APropertyListenerSupport;
import graphics.AvatarInterface;
import graphics.PropertyListenerSupport;
import scannerBean.ScannerBean;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;
import util.annotations.Visible;

@Tags({"Command Interpreter"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class ACommandInterpreter implements CommandInterpreterInterface {
	
	ABridgeScene aScene;
	ScannerBean aScanner;
	String commandInput;
	TokenInterface compactArray[];
	AvatarInterface avatar;
	Table table;
	boolean turn;
	PropertyListenerSupport propertySupport = new APropertyListenerSupport();
	
	public ACommandInterpreter(ABridgeScene aScene, ScannerBean aScanner) {
		this.aScene = aScene;
		this.aScanner = aScanner;
		table = aScene.getAvatarTable();
	}
	
	@Visible(true)
	public String getCommandInput() {
		return commandInput;
	}
	
	public void setCommandInput(String commandInput) {
		this.commandInput = commandInput;
		aScanner.setMyTestInput(commandInput);
		aScanner.scan();
		compactArray = aScanner.getCompactArray();
		interpretCommand();
//		newX = aScene.get
//		propertySupport.notifyAllListeners(new PropertyChangeEvent(this,
//				"Unknown", x, y));
	}
	
	@Visible(false)
	public ScannerBean getAScanner() {
		return aScanner;
	}
	
	// This method figures out if the parsed token is an instanceof Word command or instanceof
	@Visible(false)
	public void interpretCommand() {
		// Is the token an instance of a Command? If not, do nothing.
		if(compactArray[0] instanceof ACommandToken) {
			String avatarName = compactArray[1].getOriginalString();
			avatar = (AvatarInterface) table.get(avatarName);
				
			if(compactArray[0] instanceof Move && compactArray[1] instanceof Word 
					&& compactArray[2] instanceof Number && compactArray[3] instanceof Number) {
				int moveX = ((Number) compactArray[2]).getNumberValue();
				int moveY = ((Number) compactArray[3]).getNumberValue();
				avatar.moveAvatar(moveX, moveY);
			}
			
			if(compactArray[0] instanceof Say && compactArray[1] instanceof Word && compactArray[2] instanceof QuotedString) {
				turn = true;
				String spokenText = compactArray[2].getOriginalString();
				aScene.say(spokenText);
			}

		}
		
	}
	
	@Visible(false)
	public AvatarInterface getAvatar() { return avatar; }
	
	@Visible(false)
	public boolean getTurn() { return turn;	}
	
}
