package nl.gyrobian.calculots.equation.term;

import nl.gyrobian.calculots.equation.EquationException;
import nl.gyrobian.calculots.equation.Term;

/**
 * Simple term that represents a fixed, constant value.
 */
public class Constant extends Term {
	private final double value;

	public Constant(double value) {
		this.value = value;
	}

	@Override
	public double compute() throws EquationException {
		return this.value;
	}

	@Override
	public String toString() {
		return "" + this.value;
	}
}
