package com.conditionsevaluator.condition;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import com.conditionsevaluator.matcher.Matcher;
import com.conditionsevaluator.utils.CEUtils;

/**
 * @author Kang Guo
 *
 */
public class Condition implements Meetable {
	
	private List<Matcher<Object>> matchers = new ArrayList<>();
	private String description;
	
	public static Meetable newInstance() {
		return new Condition();
	}
	
	public Optional<String> getDescription() {
		return Optional.of(description);
	}
	
	public List<Matcher<Object>> getMatchers() {
		return matchers;
	}

	public void setMatchers(List<Matcher<Object>> matchers) {
		this.matchers = matchers;
	}

	public Meetable setDescription(String description) {
		CEUtils.checkNotNull(description);
		this.description = description;
		return this;
	}
	
	public Meetable applyRule(Predicate<Object> rule) {
		matchers.add(new Matcher<Object>(rule, null));
		return this;
	}
	
	public Meetable toValue(Object value) {
		if (matchers.size() < 1) {
			throw new IllegalArgumentException(
					"toValue function should be called by following applyRule function.");
		}

		matchers
		.get(matchers.size() - 1)
		.setValue(value);
		return this;
	}
	
	public Meetable shouldMatch(Predicate<Object> rule, 
			Object value) {
		CEUtils.checkNotNull(rule);
		CEUtils.checkNotNull(value);
		matchers.add(new Matcher<Object>(rule,value));
		return this;
	}
	
	@Override
	public boolean isMeet() {
		return matchers.stream().allMatch(a 
				-> a.isMatch());
	}
	
}
