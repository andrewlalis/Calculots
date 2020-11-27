package nl.gyrobian.calculots.view;

import javafx.scene.control.TextField;
import javafx.scene.text.Text;

/**
 * An expression field is a special text field which is added to an expression
 * on the main calculator canvas, in which some text can be typed.
 */
public class ExpressionField extends TextField {
	public ExpressionField() {
		this("");
	}

	public ExpressionField(String s) {
		super(s);
		this.textProperty().addListener((observableValue, oldText, newText) -> {
			Text text = new Text(this.getText());
			text.setFont(this.getFont());
			double textWidth = text.getBoundsInLocal().getWidth()
					+ this.getPadding().getLeft() + this.getPadding().getRight()
					+ 2;
			this.setPrefWidth(textWidth + 14);
			System.out.println(this.getText());
		});
	}
}
