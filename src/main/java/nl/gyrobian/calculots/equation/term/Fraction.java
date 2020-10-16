package nl.gyrobian.calculots.equation.term;

import nl.gyrobian.calculots.equation.EquationException;
import nl.gyrobian.calculots.equation.Expression;
import nl.gyrobian.calculots.equation.Term;

/**
 * A term which has an expression as its numerator and denominator.
 */
public class Fraction extends Term {
	private final Expression numerator;
	private final Expression denominator;

	public Fraction(Expression numerator, Expression denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
	}

	@Override
	public double compute() throws EquationException {
		return this.numerator.compute() / this.denominator.compute();
	}

	@Override
	public String toString() {
		return this.numerator.toString() + " / " + this.denominator.toString();
	}
}
