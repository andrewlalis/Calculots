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

	public void addTerm(Term term) {
		this.terms.add(term);
	}

	public void addTerm(Term term, int index) {
		this.terms.add(index, term);
	}

	@Override
	public double compute() {
		return this.terms.stream().mapToDouble(Term::compute).sum();
	}
}
