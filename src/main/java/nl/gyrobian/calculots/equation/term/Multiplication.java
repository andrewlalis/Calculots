package nl.gyrobian.calculots.equation.term;

import nl.gyrobian.calculots.equation.EquationException;
import nl.gyrobian.calculots.equation.Term;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Represents a collection of terms that are being multiplied together.
 */
public class Multiplication extends Term {
	private final List<Term> terms;

	public Multiplication() {
		this.terms = new LinkedList<>();
	}

	public Multiplication(Term... terms) {
		this();
		this.terms.addAll(Arrays.asList(terms));
	}

	@Override
	public double compute() throws EquationException {
		double product = 1.0;
		for (Term term : this.terms) {
			product *= term.compute();
		}
		return product;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < this.terms.size(); i++) {
			Term term = this.terms.get(i);
			sb.append(term.toString());
			if (i < this.terms.size() - 1) {
				sb.append(" * ");
			}
		}
		return sb.toString();
	}
}
