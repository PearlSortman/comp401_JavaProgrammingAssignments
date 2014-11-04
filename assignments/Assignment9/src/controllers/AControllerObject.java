package controllers;

import interpreter.ACommandInterpreter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;

public class AControllerObject implements ActionListener {

	JTextField userInput = new JTextField();
	JButton button = new JButton();
	ACommandInterpreter commandInter;
	
	public AControllerObject (ACommandInterpreter commandInterpreter, JTextField userInputA, JButton enterButton) {
		commandInter = commandInterpreter;
		userInput = userInputA;
		button = enterButton;
		enterButton.addActionListener((ActionListener) this);
	}
	
	public void actionPerformed(ActionEvent anEvent) {
		commandInter.setCommandInput(userInput.getText());
	}
	
	public void setModel(ACommandInterpreter aCommandInterpreter) {
		commandInter = aCommandInterpreter;
	}

	public void processInput() {
		
	}
}
