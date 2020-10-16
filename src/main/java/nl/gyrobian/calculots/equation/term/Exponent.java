package nl.gyrobian.calculots.equation.term;

import nl.gyrobian.calculots.equation.EquationException;
import nl.gyrobian.calculots.equation.Expression;
import nl.gyrobian.calculots.equation.Term;

public class Exponent extends Term {
	private final Expression base;
	private final Expression power;

	public Exponent(Expression base, Expression power) {
		this.base = base;
		this.power = power;
	}

	@Override
	public double compute() throws EquationException {
		return Math.pow(this.base.compute(), this.power.compute());
	}

	@Override
	public String toString() {
		return this.base.toString() + "^" + this.power.toString();
	}
}
