package com.conditionsevaluator;
import java.util.function.Consumer;
import com.conditionsevaluator.condition.Meetable;

/**
 * @author Kang Guo
 *
 */
public interface Evaluable {
	boolean evaluate();
	boolean evaluate(Consumer<String> resultConsumer);
	Evaluable addSufficient(Meetable condition);
	Evaluable addNecessary(Meetable condition);
}
