package controllers;

import java.awt.event.MouseEvent;

import scenes.AConsoleSceneView;
import scenes.BridgeSceneInterface;

public class AMouseController implements MouseControllerInterface{
	BridgeSceneInterface aScene;
	AConsoleSceneView aView;
    
    public AMouseController (BridgeSceneInterface newScene, AConsoleSceneView newView) {
    	aScene = newScene;
    	aView = newView;
    	aView.addMouseListener(this);
    }   
    public void mouseClicked(MouseEvent e) {
//        aScene.getAvatar().setX(e.getX());
//        aScene.getThief().setY(e.getY());
    }    
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mousePressed(MouseEvent e) {}
    public void mouseReleased(MouseEvent e) {}  
}
