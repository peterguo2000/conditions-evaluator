package com.conditionsevaluator.matcher;
import java.util.function.Predicate;

import com.conditionsevaluator.utils.CEUtils;

/**
 * @author Kang Guo
 *
 */
public class Matcher<T> implements Matchable {
	private Predicate<T> rule;
	private T value;
	
	public Matcher(Predicate<T> rule, T value) {
		this.setRule(rule);
		this.setValue(value);
	}

	public Predicate<T> getRule() {
		return rule;
	}

	public void setRule(Predicate<T> rule) {
		this.rule = rule;
	}
	
	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	@Override
	public boolean isMatch() {
		CEUtils
		.checkNotNull(rule);
		CEUtils
		.checkNotNull(value);
		
		return rule.test(value);
	}

}
