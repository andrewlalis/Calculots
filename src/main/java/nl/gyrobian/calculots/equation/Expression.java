package nl.gyrobian.calculots.equation;

import lombok.Getter;

import java.util.LinkedList;
import java.util.List;

/**
 * Represents a mathematical expression, consisting of one or more terms.
 */
@Getter
public class Expression implements Computable {
	private List<Term> terms;

	public Expression() {
		this.terms = new LinkedList<>();
	}

	public Expression(Term term) {
		this();
		this.terms.add(term);
	}

	public void addTerm(Term term) {
		this.terms.add(term);
	}

	@Override
	public double compute() throws EquationException {
		double sum = 0.0;
		for (Term term : this.getTerms()) {
			sum += term.compute();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder("( ");
		for (int i = 0; i < this.terms.size(); i++) {
			Term term = this.terms.get(i);
			sb.append(term.toString());
			if (i < this.terms.size() - 1) {
				sb.append(" + ");
			}
		}
		sb.append(" )");
		return sb.toString();
	}
}
