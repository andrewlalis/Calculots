package nl.gyrobian.calculots.model;

import javafx.geometry.VPos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 * Represents an object on the calculator canvas that the user can write
 * text or equations in.
 */
public class ExpressionFragment extends Canvas {
	private String expression;
	private int cursorIndex;

	public ExpressionFragment() {
		super();
		this.minWidth(100);
		this.minHeight(30);

		this.expression = "";
		this.cursorIndex = 0;

		this.render(this.getGraphicsContext2D());
		this.addEventFilter(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
			System.out.println("Mouse event occurred in fragment.");
			System.out.println(mouseEvent.toString());
		});
		this.addEventFilter(KeyEvent.KEY_PRESSED, keyEvent -> {
			final KeyCode code = keyEvent.getCode();
			if (code.isArrowKey()) {
				if (code.equals(KeyCode.LEFT)) {
					this.setCursorIndex(Math.max(0, this.cursorIndex - 1));
				} else if (code.equals(KeyCode.RIGHT)) {
					this.setCursorIndex(Math.min(this.expression.length(), this.cursorIndex));
				}
			}
		});
		this.focusedProperty().addListener((observableValue, oldValue, newValue) -> {
			this.render(this.getGraphicsContext2D());
		});
		this.hoverProperty().addListener(observable -> {
			this.render(this.getGraphicsContext2D());
		});
	}

	protected void render(GraphicsContext gc) {
		if (this.isFocused()) {
			gc.setFill(Color.LIGHTBLUE);
		} else {
			gc.setFill(Color.LIGHTGRAY);
		}
		if (this.isHover()) {
			gc.setFill(Color.LIGHTGREEN);
		}
		gc.fillRect(0, 0, this.getWidth(), this.getHeight());
		gc.setFill(Color.BLACK);
		gc.setTextAlign(TextAlignment.LEFT);
		gc.setTextBaseline(VPos.CENTER);
		gc.fillText(this.expression, 0, this.getHeight() / 2);

	}

	private void render() {
		this.render(this.getGraphicsContext2D());
	}

	public void setExpression(String expression) {
		this.expression = expression;
		final Text text = new Text(this.expression);
		this.setWidth(text.getLayoutBounds().getWidth());
		this.setHeight(text.getLayoutBounds().getHeight());
		this.render();
	}

	public void setCursorIndex(int newIndex) {
		this.cursorIndex = newIndex;
		this.render();
	}
}
