package nl.gyrobian.calculots.model;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import nl.gyrobian.calculots.controller.calculator_canvas.CalculatorCanvasMouseClickHandler;

public class CalculatorCanvas extends Pane {
	public CalculatorCanvas() {
		super();
		this.addEventHandler(MouseEvent.MOUSE_CLICKED, new CalculatorCanvasMouseClickHandler(this));
		this.addEventHandler(MouseEvent.MOUSE_DRAGGED, mouseEvent -> {
			System.out.println("drag");
		});
	}
}
