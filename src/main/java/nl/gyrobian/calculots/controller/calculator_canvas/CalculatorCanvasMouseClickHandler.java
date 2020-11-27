package nl.gyrobian.calculots.controller.calculator_canvas;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import nl.gyrobian.calculots.model.CalculatorCanvas;
import nl.gyrobian.calculots.model.ExpressionPane;

public class CalculatorCanvasMouseClickHandler implements EventHandler<MouseEvent> {
	private final CalculatorCanvas canvas;

	public CalculatorCanvasMouseClickHandler(CalculatorCanvas canvas) {
		this.canvas = canvas;
	}

	@Override
	public void handle(MouseEvent mouseEvent) {
		for (Node node : this.canvas.getChildren()) {
			if (node.contains(node.parentToLocal(mouseEvent.getX(), mouseEvent.getY()))) {
				if (mouseEvent.getButton().equals(MouseButton.SECONDARY)) {
					this.canvas.getChildren().remove(node);
					return;
				}
				node.requestFocus();
				return;
			}
		}
		if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
			System.out.println("Primary button pressed on canvas.");
			if (!this.canvas.isFocused()) {
				System.out.println("Requesting focus on the canvas.");
				this.canvas.requestFocus();
				return;
			}
			ExpressionPane fragment = new ExpressionPane();
			fragment.getStyleClass().add("expression_pane");
			fragment.setTranslateX(mouseEvent.getX());
			fragment.setTranslateY(mouseEvent.getY());
			this.canvas.getChildren().add(fragment);
			System.out.println("Adding expression fragment.");
		}
	}
}
