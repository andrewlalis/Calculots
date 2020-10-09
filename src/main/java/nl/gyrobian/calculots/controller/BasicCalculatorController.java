package nl.gyrobian.calculots.controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class BasicCalculatorController {
	public TextField basicInputField;
	public Button zeroButton;
	public Button oneButton;
	public Button twoButton;
	public Button threeButton;
	public Button fourButton;
	public Button fiveButton;
	public Button sixButton;
	public Button sevenButton;
	public Button eightButton;
	public Button nineButton;
	public Button addButton;
	public Button subtractButton;
	public Button multiplyButton;
	public Button divideButton;
	public Button decimalButton;
	public Button ansButton;
	public Button equalsButton;

	public void onInputKeyTyped(KeyEvent keyEvent) {
		System.out.println("Key typed: " + keyEvent.toString());
	}
}
