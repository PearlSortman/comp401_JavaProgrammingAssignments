package linesAndShapes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
import util.annotations.Tags;

@Tags({"Bridge Scene"})
@StructurePattern(StructurePatternNames.BEAN_PATTERN)
public class TheBridgeScene implements BridgeScene {
	
	AnAvatar arthur;
	AnAvatar galahad;
	AnAvatar guard;
	AnAvatar lancelot;
	AnAvatar robin;

	public TheBridgeScene() {
		arthur = new AnAvatar("Hello", "arthur.jpg", 100, 100, 80, 1);
		galahad = new AnAvatar("Hi! I'm Galahad.", "galahad.jpg", 300, 100, 80, 1);
		guard = new AnAvatar("I am the guard.", "guard.jpg", 500, 150, 80, 1);
		lancelot = new AnAvatar("Hey!! Great to see you Arthur!", "lancelot.jpg", 150, 400, 80, 1);
		robin = new AnAvatar("Go fish.", "robin.jpg", 550, 400, 80, 1);
	}
	
	public AnAvatar getArthur() { return arthur; }
	public AnAvatar getGalahad() { return galahad; }
	public AnAvatar getGuard() { return guard; }
	public AnAvatar getLancelot() { return lancelot; }
	public AnAvatar getRobin() { return robin; }

}
