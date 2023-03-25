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

import org.eclipse.example.calc.BinaryOperation;

// Binary Multiply Operation

public class Multiply extends AbstractOperation implements BinaryOperation {
	// Multiply is implemented as a binary operation as it takes 2 numerical arguments

	@Override
	public float perform(float arg1, float arg2) {
		// logic
		return arg1 * arg2;
	}

	@Override
	public String getName() {
		return "*";
	}

}
