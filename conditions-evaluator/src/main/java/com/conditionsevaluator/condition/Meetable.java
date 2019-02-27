package com.conditionsevaluator.condition;
import java.util.Optional;
import java.util.function.Predicate;

/**
 * @author Kang Guo
 *
 */
public interface Meetable {
	Meetable setDescription(String description);
	Meetable applyRule(Predicate<Object> rule);
	Meetable toValue(Object value); 
	Meetable shouldMatch(Predicate<Object> rule, Object value);
	Optional<String> getDescription();
	boolean isMeet();
}
