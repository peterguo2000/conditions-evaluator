package com.conditionsevaluator;
import org.junit.Assert;
import org.junit.Test;
import com.conditionsevaluator.condition.Condition;
import com.conditionsevaluator.ConditionsEvaluator;

/**
 * @author Kang Guo
 *
 */
public class ConditionEvaluatorTestsSmall {
	
    @Test
    public void test() throws Exception {
    	String x = "4";
    	
		boolean result = ConditionsEvaluator.newInstance()
		    	.addNecessary(
		    			Condition.newInstance()
						.applyRule(a -> "3".equals(a))
						.toValue(x))
		    	.evaluate();
		Assert.assertFalse(result);

    }
    
}
