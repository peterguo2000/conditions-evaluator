package com.conditionsevaluator;
import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import com.conditionsevaluator.condition.Condition;
import com.conditionsevaluator.condition.Meetable;
import com.conditionsevaluator.ConditionsEvaluator;

/**
 * @author Kang Guo
 *
 */
public class ConditionEvaluatorTestsLarge {
	
	private List<Meetable> getNecessaryConditions (String x, Integer y) {
		return Arrays.asList(
				
				//condition1
				Condition.newInstance()
				.setDescription("x should not be 1. that is necessary.")
				.applyRule(i -> !"1".equals(i))  //shouldMatch == applyRule + toValue
				.toValue(x),
				
				//condition2
				Condition.newInstance()
				.setDescription("x should not be 4. that is necessary.")
				.shouldMatch(i -> !"4".equals(i), x) //shouldMatch == applyRule + toValue
				
				);
	}
	
    @Test
    public void test() throws Exception {
    	String x = "4";
    	Integer y = 2;
    	StringBuilder resultMessage = new StringBuilder();
    	
    	//get instance and add sufficient conditions
    	Evaluable evaluator =  ConditionsEvaluator.newInstance()
    			.addSufficient(Condition.newInstance()
    					.setDescription("x is 3 and y is 3. that is enough")
    					.applyRule(i -> "3".equals(i))
    					.toValue(x)
    					.applyRule(i -> ((Integer)i).intValue() == 3)
    					.toValue(y));
    	
    	//add necessary conditions
    	getNecessaryConditions(x, y)
    	.forEach( a -> evaluator.addNecessary(a));
    	
		boolean result = evaluator
				.evaluate(a -> 
				resultMessage.append(a));

		if (!result) {
			Assert.assertEquals("x should not be 4. that is necessary.", resultMessage.toString());			
		} else {
			Assert.fail();
		}
    }
    
}
