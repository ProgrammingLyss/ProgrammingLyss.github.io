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

import static org.junit.Assert.assertEquals;

import org.eclipse.example.calc.UnaryOperation;
import org.junit.Before;
import org.junit.Test;

// Testing Unary Square Operation

public class SquareTest extends AbstractOperationTest {

	private UnaryOperation op;

	@Before
	public void setUp() throws Exception {
		op = new Square();
	}

	@Test
	public void testPerform() {
		assertEquals(4.0, op.perform(2.0F), 0.01F);
	}

	@Test
	public void testGetName() {
		assertEquals(op.getName(), "^2");
	}
}
