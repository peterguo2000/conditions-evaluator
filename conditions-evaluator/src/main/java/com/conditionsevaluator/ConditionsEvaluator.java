package com.conditionsevaluator;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

import com.conditionsevaluator.condition.Meetable;
import com.conditionsevaluator.utils.CEUtils;

/**
 * @author Kang Guo
 *
 */
public class ConditionsEvaluator implements Evaluable {
	
	protected Stream.Builder<Meetable> sufficientBuilder = Stream.builder();
	protected Stream.Builder<Meetable> necessaryBuilder = Stream.builder();
	
	public static ConditionsEvaluator newInstance() {
		return new ConditionsEvaluator();
	}
	
	private Optional<Meetable> findFirst(Stream<Meetable> conditions, 
			Predicate<Meetable> criteria) {
		return conditions
				  .filter(criteria)
				  .findFirst();
	}
	
	private void consumResultMessage(Consumer<String> resultConsumer, 
			Meetable condition) {
		Optional.ofNullable(resultConsumer)
		.ifPresent(a -> 
		a.accept(
				condition
				.getDescription()
				.get()));
	}
	
	@Override
	public ConditionsEvaluator addSufficient(Meetable condition) {
		CEUtils.checkNotNull(condition);
		sufficientBuilder
		.add(condition);
		return this;	
	}
	
	@Override
	public ConditionsEvaluator addNecessary(Meetable condition) {
		CEUtils.checkNotNull(condition);
		necessaryBuilder
		.add(condition);
		return this;
	}
	
	@Override
	public boolean evaluate() { 
		return evaluate(null);					
	}
	
	@Override
	public boolean evaluate(Consumer<String> resultConsumer) { 
		boolean result = true;
		
		Optional<Meetable> sufficientCondition = 
				findFirst(sufficientBuilder.build(), a -> a.isMeet());
		
		if (sufficientCondition.isPresent()) {
			consumResultMessage(resultConsumer, sufficientCondition.get());
			result = true;
		} else {
			Optional<Meetable> necessaryCondition = 
					findFirst(necessaryBuilder.build(), a -> !a.isMeet());
			if(necessaryCondition.isPresent()) {
				consumResultMessage(resultConsumer, necessaryCondition.get());
				result = false;
			}
		}
		
		return result;			
	}

}
