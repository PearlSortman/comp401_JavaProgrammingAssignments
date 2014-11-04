package linesAndShapes;
import util.annotations.StructurePattern;
import util.annotations.StructurePatternNames;
@StructurePattern(StructurePatternNames.IMAGE_PATTERN)
public class AShapeImage extends AShape implements ShapeImageInterface {
	
	String imageFileName;
	
	public AShapeImage (String initImageFileName, int initX, int initY, int initHeight, int initWidth) {	
		super(initX, initY, initWidth, initHeight);
		imageFileName = initImageFileName;
	}	
    
    public String getImageFileName() {return imageFileName;}  
    public void setImageFileName(String newVal) {imageFileName = newVal ;}     

}
