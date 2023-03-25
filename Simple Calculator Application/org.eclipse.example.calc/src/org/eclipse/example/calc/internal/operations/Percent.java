/*******************************************************************************
 *                   Simple Calculator Application
 * 
 * Description: A calculator application for performing 
 * arithmetic operations on numbers.
 * Alyssa Fasciano
 * Southern New Hampshire University
 * CS-499: Computer Science Capstone
 * March/April 2023
 *******************************************************************************/
package org.eclipse.example.calc.internal.operations;

import org.eclipse.example.calc.UnaryOperation;

// Unary Percent Operation

public class Percent extends AbstractOperation implements UnaryOperation {
	// Percent is implemented as a unary operation as it takes 1 numerical argument

	@Override
	public float perform(float arg1) {
		// logic
		return arg1 / 100;
	}

	@Override
	public String getName() {
		return "%";
	}


}
