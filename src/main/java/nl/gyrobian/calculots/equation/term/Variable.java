package nl.gyrobian.calculots.equation.term;

import nl.gyrobian.calculots.equation.EquationException;
import nl.gyrobian.calculots.equation.Term;

public class Variable extends Term {
	private final String name;

	public Variable(String name) {
		this.name = name;
	}

	@Override
	public double compute() throws EquationException {
		throw new EquationException("Variable is not computable.");
	}

	@Override
	public String toString() {
		return this.name;
	}
}
