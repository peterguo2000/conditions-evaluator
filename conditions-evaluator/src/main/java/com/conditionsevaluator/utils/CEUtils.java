package com.conditionsevaluator.utils;

/**
 * @author Kang Guo
 *
 */
public class CEUtils {
	
	public static void checkNotNull(Object object) {
		if (object == null) {
			throw new IllegalArgumentException(
					"The parameter cannot be null.");
		}
	}
	
}
