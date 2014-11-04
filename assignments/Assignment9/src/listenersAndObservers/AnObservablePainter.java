package listenersAndObservers;
import graphics.ACircleShape;
import graphics.ALine;
import graphics.ARectangleShape;
import graphics.AShapeImage;
import graphics.AStringShape;
import graphics.AVShape;
import graphics.AnAvatar;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyChangeEvent;

import controllers.AMouseController;
import scenes.BridgeSceneInterface;
import util.annotations.Tags;
import util.models.PropertyListenerRegisterer;

@Tags({"Inheriting Bridge Scene"})
public class AnObservablePainter extends Component implements PaintListenerInterface {

	BasicStroke dotted = new BasicStroke(1f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND, 1f, new float[] { 2f }, 0f);
	BridgeSceneInterface theScene;
	Graphics g;
	
	public AnObservablePainter(BridgeSceneInterface scene) {
		theScene = scene;

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
	
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {
	        super.paint(g);
	        Graphics2D g2 = (Graphics2D) g;
	        g.setColor(Color.BLACK);     
	        draw(g2, theScene);
	    }

		public void draw(Graphics2D g, BridgeSceneInterface scene) {
	    	draw(g, scene.getBridge());
	        draw(g, scene.getCircleOne());
	        draw(g, scene.getCircleTwo());
	        draw(g, scene.getGorgeOne());
	        draw(g, scene.getGorgeTwo());
	        draw(g, scene.getGuard());
	        draw(g, scene.getArthur());
	        draw(g, scene.getGalahad());
	        draw(g, scene.getLancelot());
	        draw(g, scene.getRobin());
	    }

	    private void draw(Graphics2D g, AnAvatar avatar) {
			draw(g, avatar.getText());
			draw(g, avatar.getArms());
			draw(g, avatar.getBody());
			draw(g, avatar.getImage());
			draw(g, avatar.getLegs());
		}
	    
		private void draw(Graphics2D g2, ALine line) {
			g2.drawLine(line.getX(), line.getY(), line.getX()+line.getWidth(), line.getY()+line.getHeight());
		}

		private void draw(Graphics2D g2, AVShape arms) {
			draw(g2, arms.getLeftLine());
			draw(g2, arms.getRightLine());
		}

		private void draw(Graphics2D g2, ACircleShape circle) {
			g2.drawOval(circle.getX(), circle.getY(), circle.getWidth(), circle.getHeight());
		}

		private void draw(Graphics2D g2, ARectangleShape rectangle) {
			g2.drawRect(rectangle.getX(), rectangle.getY(), rectangle.getHeight(), rectangle.getWidth());
			
		}

		public void draw(Graphics2D g2, AStringShape string) {
	        String s = string.getText();
	        g2.drawString(s, string.getX(), string.getY());     
//	        System.out.println("Working!!!!!!!!!!!!");
	    }
	    
	    public  void draw(Graphics2D g, AShapeImage anImage) {
	        Image img = Toolkit.getDefaultToolkit().getImage(anImage.getImageFileName());
	        g.drawImage(img, anImage.getX(), anImage.getY(), this);     
	    }
		
		public void register(PropertyListenerRegisterer aPropertyChangeRegister){
			aPropertyChangeRegister.addPropertyChangeListener(this);        
		}

		@Override
		public void paint(Graphics2D g) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void propertyChange(PropertyChangeEvent argument) {
			repaint();
			String current = "";
			
			//all arguments for ARTHUR
			if (argument.getSource() == theScene.getArthur().getArms().getLeftLine()) {
				current = "Arthur's Left Arm";
			}
			else if (argument.getSource() == theScene.getArthur().getArms().getRightLine()) {
				current = "Arthur's Right Arm";
			}
			else if (argument.getSource() == theScene.getArthur().getBody()) {
				current = "Arthur's Body";
			}
			else if (argument.getSource() == theScene.getArthur().getImage()) {
				current = "Arthur Image";
			}
			else if (argument.getSource() == theScene.getArthur().getLegs().getLeftLine()) {
				current = "Arthur's Left Leg";
			}
			else if (argument.getSource() == theScene.getArthur().getLegs().getRightLine()) {
				current = "Arthur's Right Leg";
			}
			else if (argument.getSource() == theScene.getArthur().getText()) {
				current = "Arthur's Text";
			}
			
			//all arguments for GALAHAD
			else if (argument.getSource() == theScene.getGalahad().getArms().getLeftLine()) {
				current = "Galahad's Left Arm";
			}
			else if (argument.getSource() == theScene.getGalahad().getArms().getRightLine()) {
				current = "Galahad's Right Arm";
			}
			else if (argument.getSource() == theScene.getGalahad().getBody()) {
				current = "Galahad's Body";
			}
			else if (argument.getSource() == theScene.getGalahad().getImage()) {
				current = "Galahad Image";
			}
			else if (argument.getSource() == theScene.getGalahad().getLegs().getLeftLine()) {
				current = "Galahad's Left Leg";
			}
			else if (argument.getSource() == theScene.getGalahad().getLegs().getRightLine()) {
				current = "Galahad's Right Leg";
			}
			else if (argument.getSource() == theScene.getGalahad().getText()) {
				current = "Galahad's Text";
			}
			
			//all arguments for GUARD
			else if (argument.getSource() == theScene.getGuard().getArms().getLeftLine()) {
				current = "Guard's Left Arm";
			}
			else if (argument.getSource() == theScene.getGuard().getArms().getRightLine()) {
				current = "Guard's Right Arm";
			}
			else if (argument.getSource() == theScene.getGuard().getBody()) {
				current = "Guard's Body";
			}
			else if (argument.getSource() == theScene.getGuard().getImage()) {
				current = "Guard Image";
			}
			else if (argument.getSource() == theScene.getGuard().getLegs().getLeftLine()) {
				current = "Guard's Left Leg";
			}
			else if (argument.getSource() == theScene.getGuard().getLegs().getRightLine()) {
				current = "Guard's Right Leg";
			}
			else if (argument.getSource() == theScene.getGuard().getText()) {
				current = "Guard's Text";
			}
			
			//all arguments for LANCELOT
			else if (argument.getSource() == theScene.getLancelot().getArms().getLeftLine()) {
				current = "Lancelot's Left Arm";
			}
			else if (argument.getSource() == theScene.getLancelot().getArms().getRightLine()) {
				current = "Lancelot's Right Arm";
			}
			else if (argument.getSource() == theScene.getLancelot().getBody()) {
				current = "Lancelot's Body";
			}
			else if (argument.getSource() == theScene.getLancelot().getImage()) {
				current = "Lancelot Image";
			}
			else if (argument.getSource() == theScene.getLancelot().getLegs().getLeftLine()) {
				current = "Lancelot's Left Leg";
			}
			else if (argument.getSource() == theScene.getLancelot().getLegs().getRightLine()) {
				current = "Lancelot's Right Leg";
			}
			else if (argument.getSource() == theScene.getLancelot().getText()) {
				current = "Lancelot's Text";
			}
			
			//all arguments for ROBIN
			else if (argument.getSource() == theScene.getRobin().getArms().getLeftLine()) {
				current = "Robin's Left Arm";
			}
			else if (argument.getSource() == theScene.getRobin().getArms().getRightLine()) {
				current = "Robin's Right Arm";
			}
			else if (argument.getSource() == theScene.getRobin().getBody()) {
				current = "Robin's Body";
			}
			else if (argument.getSource() == theScene.getRobin().getImage()) {
				current = "Robin Image";
			}
			else if (argument.getSource() == theScene.getRobin().getLegs().getLeftLine()) {
				current = "Robin's Left Leg";
			}
			else if (argument.getSource() == theScene.getRobin().getLegs().getRightLine()) {
				current = "Robin's Right Leg";
			}
			else if (argument.getSource() == theScene.getRobin().getText()) {
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
