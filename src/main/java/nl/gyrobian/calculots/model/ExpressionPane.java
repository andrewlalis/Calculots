package nl.gyrobian.calculots.model;

import javafx.geometry.Insets;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import nl.gyrobian.calculots.view.ExpressionField;

/**
 * Represents an object on the calculator canvas that the user can write
 * text or equations in.
 */
public class ExpressionPane extends Pane {
	public ExpressionPane() {
		// By default every expression fragment starts with a single starting field.
		var firstField = new ExpressionField();
		firstField.getStyleClass().add("expression_field");
		firstField.setPrefWidth(50);
		this.getChildren().add(firstField);

		this.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
			System.out.println("Mouse event occurred in fragment.");
			System.out.println(mouseEvent.toString());
		});
		this.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
			final KeyCode code = keyEvent.getCode();
			if (keyEvent.getCharacter().equals("^")) {
				System.out.println("Exponent!");
			}
		});
	}
}
