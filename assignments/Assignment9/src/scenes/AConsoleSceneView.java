package scenes;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import listenersAndObservers.AnObservablePainter;
import controllers.AMouseController;
import util.annotations.Tags;

@Tags({"Console Scene View"})
public class AConsoleSceneView implements PropertyChangeListener {
	BridgeSceneInterface aScene;

	public AConsoleSceneView(BridgeSceneInterface theScene) {
		aScene = theScene;
		theScene.getArthur().getArms().getLeftLine().addPropertyChangeListener(this);
		theScene.getArthur().getArms().getRightLine().addPropertyChangeListener(this);
		theScene.getArthur().getBody().addPropertyChangeListener(this);
		theScene.getArthur().getImage().addPropertyChangeListener(this);
		theScene.getArthur().getLegs().getLeftLine().addPropertyChangeListener(this);
		theScene.getArthur().getLegs().getRightLine().addPropertyChangeListener(this);
		theScene.getArthur().getText().addPropertyChangeListener(this);
		
		theScene.getGalahad().getArms().getLeftLine().addPropertyChangeListener(this);
		theScene.getGalahad().getArms().getRightLine().addPropertyChangeListener(this);
		theScene.getGalahad().getBody().addPropertyChangeListener(this);
		theScene.getGalahad().getImage().addPropertyChangeListener(this);
		theScene.getGalahad().getLegs().getLeftLine().addPropertyChangeListener(this);
		theScene.getGalahad().getLegs().getRightLine().addPropertyChangeListener(this);
		theScene.getGalahad().getText().addPropertyChangeListener(this);
	
		theScene.getGuard().getArms().getLeftLine().addPropertyChangeListener(this);
		theScene.getGuard().getArms().getRightLine().addPropertyChangeListener(this);
		theScene.getGuard().getBody().addPropertyChangeListener(this);
		theScene.getGuard().getImage().addPropertyChangeListener(this);
		theScene.getGuard().getLegs().getLeftLine().addPropertyChangeListener(this);
		theScene.getGuard().getLegs().getRightLine().addPropertyChangeListener(this);
		theScene.getGuard().getText().addPropertyChangeListener(this);
		
		theScene.getLancelot().getArms().getLeftLine().addPropertyChangeListener(this);
		theScene.getLancelot().getArms().getRightLine().addPropertyChangeListener(this);
		theScene.getLancelot().getBody().addPropertyChangeListener(this);
		theScene.getLancelot().getImage().addPropertyChangeListener(this);
		theScene.getLancelot().getLegs().getLeftLine().addPropertyChangeListener(this);
		theScene.getLancelot().getLegs().getRightLine().addPropertyChangeListener(this);
		theScene.getLancelot().getText().addPropertyChangeListener(this);

		theScene.getRobin().getArms().getLeftLine().addPropertyChangeListener(this);
		theScene.getRobin().getArms().getRightLine().addPropertyChangeListener(this);
		theScene.getRobin().getBody().addPropertyChangeListener(this);
		theScene.getRobin().getImage().addPropertyChangeListener(this);
		theScene.getRobin().getLegs().getLeftLine().addPropertyChangeListener(this);
		theScene.getRobin().getLegs().getRightLine().addPropertyChangeListener(this);
		theScene.getRobin().getText().addPropertyChangeListener(this);
	}

	@Override
	public void propertyChange(PropertyChangeEvent argument) {
		String current = "";
		
		//all arguments for ARTHUR
		if (argument.getSource() == aScene.getArthur().getArms().getLeftLine()) {
			current = "Arthur's Left Arm";
		}
		else if (argument.getSource() == aScene.getArthur().getArms().getRightLine()) {
			current = "Arthur's Right Arm";
		}
		else if (argument.getSource() == aScene.getArthur().getBody()) {
			current = "Arthur's Body";
		}
		else if (argument.getSource() == aScene.getArthur().getImage()) {
			current = "Arthur Image";
		}
		else if (argument.getSource() == aScene.getArthur().getLegs().getLeftLine()) {
			current = "Arthur's Left Leg";
		}
		else if (argument.getSource() == aScene.getArthur().getLegs().getRightLine()) {
			current = "Arthur's Right Leg";
		}
		else if (argument.getSource() == aScene.getArthur().getText()) {
			current = "Arthur's Text";
		}
		
		//all arguments for GALAHAD
		else if (argument.getSource() == aScene.getGalahad().getArms().getLeftLine()) {
			current = "Galahad's Left Arm";
		}
		else if (argument.getSource() == aScene.getGalahad().getArms().getRightLine()) {
			current = "Galahad's Right Arm";
		}
		else if (argument.getSource() == aScene.getGalahad().getBody()) {
			current = "Galahad's Body";
		}
		else if (argument.getSource() == aScene.getGalahad().getImage()) {
			current = "Galahad Image";
		}
		else if (argument.getSource() == aScene.getGalahad().getLegs().getLeftLine()) {
			current = "Galahad's Left Leg";
		}
		else if (argument.getSource() == aScene.getGalahad().getLegs().getRightLine()) {
			current = "Galahad's Right Leg";
		}
		else if (argument.getSource() == aScene.getGalahad().getText()) {
			current = "Galahad's Text";
		}
		
		//all arguments for GUARD
		else if (argument.getSource() == aScene.getGuard().getArms().getLeftLine()) {
			current = "Guard's Left Arm";
		}
		else if (argument.getSource() == aScene.getGuard().getArms().getRightLine()) {
			current = "Guard's Right Arm";
		}
		else if (argument.getSource() == aScene.getGuard().getBody()) {
			current = "Guard's Body";
		}
		else if (argument.getSource() == aScene.getGuard().getImage()) {
			current = "Guard Image";
		}
		else if (argument.getSource() == aScene.getGuard().getLegs().getLeftLine()) {
			current = "Guard's Left Leg";
		}
		else if (argument.getSource() == aScene.getGuard().getLegs().getRightLine()) {
			current = "Guard's Right Leg";
		}
		else if (argument.getSource() == aScene.getGuard().getText()) {
			current = "Guard's Text";
		}
		
		//all arguments for LANCELOT
		else if (argument.getSource() == aScene.getLancelot().getArms().getLeftLine()) {
			current = "Lancelot's Left Arm";
		}
		else if (argument.getSource() == aScene.getLancelot().getArms().getRightLine()) {
			current = "Lancelot's Right Arm";
		}
		else if (argument.getSource() == aScene.getLancelot().getBody()) {
			current = "Lancelot's Body";
		}
		else if (argument.getSource() == aScene.getLancelot().getImage()) {
			current = "Lancelot Image";
		}
		else if (argument.getSource() == aScene.getLancelot().getLegs().getLeftLine()) {
			current = "Lancelot's Left Leg";
		}
		else if (argument.getSource() == aScene.getLancelot().getLegs().getRightLine()) {
			current = "Lancelot's Right Leg";
		}
		else if (argument.getSource() == aScene.getLancelot().getText()) {
			current = "Lancelot's Text";
		}
		
		//all arguments for ROBIN
		else if (argument.getSource() == aScene.getRobin().getArms().getLeftLine()) {
			current = "Robin's Left Arm";
		}
		else if (argument.getSource() == aScene.getRobin().getArms().getRightLine()) {
			current = "Robin's Right Arm";
		}
		else if (argument.getSource() == aScene.getRobin().getBody()) {
			current = "Robin's Body";
		}
		else if (argument.getSource() == aScene.getRobin().getImage()) {
			current = "Robin Image";
		}
		else if (argument.getSource() == aScene.getRobin().getLegs().getLeftLine()) {
			current = "Robin's Left Leg";
		}
		else if (argument.getSource() == aScene.getRobin().getLegs().getRightLine()) {
			current = "Robin's Right Leg";
		}
		else if (argument.getSource() == aScene.getRobin().getText()) {
			current = "Robin's Text";
		}
		
		//print all information then actual argument
		System.out.println("Object: " + current + "\t Property name: "
				+ argument.getPropertyName() + "\t old value: "
				+ argument.getOldValue() + "\t new value: " + argument.getNewValue());
		System.out.println(argument);
		System.out.println();
	}

	public void addMouseListener(AMouseController aMouseController) {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener() {
		// TODO Auto-generated method stub
		
	}

	public void addPropertyChangeListener(AnObservablePainter anObservablePainter) {
		// TODO Auto-generated method stub
		
	}

}
