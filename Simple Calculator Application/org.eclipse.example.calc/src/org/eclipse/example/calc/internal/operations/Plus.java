/*******************************************************************************
 * Copyright (C) 2010, Matthias Sohn <matthias.sohn@sap.com>
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
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

// Binary Plus Operation

public class Plus extends AbstractOperation implements BinaryOperation {
	// Plus is implemented as a binary operation as it takes 2 numerical arguments

	@Override
	public float perform(float arg1, float arg2) {
		// logic
		return arg1 + arg2;
	}

	@Override
	public String getName() {
		return "+";
	}

}
