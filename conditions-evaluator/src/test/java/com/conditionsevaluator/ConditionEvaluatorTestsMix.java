package com.conditionsevaluator;
import org.junit.Assert;
import org.junit.Test;
import com.conditionsevaluator.condition.Condition;
import com.conditionsevaluator.condition.Meetable;
import com.conditionsevaluator.ConditionsEvaluator;

/**
 * @author Kang Guo
 *
 */
public class ConditionEvaluatorTestsMix {
	
	private Meetable getCondition1(String x, Integer y) {
		return Condition.newInstance()
				.setDescription("x is 3 and y is 3. that is enough")
				.applyRule(i -> "3".equals(i))
				.toValue(x)
				.applyRule(i -> ((Integer)i).intValue() == 3)
				.toValue(y);
	}
	
	private Meetable getCondition2(String x, Integer y) {
		return Condition.newInstance()
				.setDescription("x should not be 1. that is necessary.")
				.shouldMatch(i -> !"1".equals(i),
						x);
	}
	
	private Meetable getCondition3(String x, Integer y) {
		return Condition.newInstance()
		.setDescription("x should not be 4. that is necessary.")
		.shouldMatch(i -> !"4".equals(i),
				x);
	}
	
    @Test
    public void test() throws Exception {
    	String x = "4";
    	Integer y = 2;
    	StringBuilder resultMessage = new StringBuilder();
    	
    	boolean result = ConditionsEvaluator.newInstance()
				.addSufficient(getCondition1(x, y))
		    	.addNecessary(getCondition2(x, y))
		    	.addNecessary(getCondition3(x, y))
		    	.addNecessary(
		    			Condition.newInstance()
		    			.setDescription("y is 2. that is necessary.")
		    			.shouldMatch(a -> ((Integer)a).intValue() == 2, y)) //shouldMatch == applyRule + toValue
		    	.evaluate(a -> 
		    	resultMessage.append(a));

    	if (!result) {
			Assert.assertEquals("x should not be 4. that is necessary.", resultMessage.toString());			
    	} else {
			Assert.fail();
    	}
    }
    
}
