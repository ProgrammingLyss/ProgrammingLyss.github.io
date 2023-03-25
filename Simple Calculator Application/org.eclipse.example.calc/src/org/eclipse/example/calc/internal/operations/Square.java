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

import org.eclipse.example.calc.UnaryOperation;

// Square Operation
 
public class Square extends AbstractOperation implements UnaryOperation {
	// Square is implemented as a unary operation as it takes 1 numerical argument

	@Override
	public String getName() {
		return "^2";
	}

	@Override
	public float perform(float arg1) {
		// logic
		return arg1 * arg1;
	}

}
