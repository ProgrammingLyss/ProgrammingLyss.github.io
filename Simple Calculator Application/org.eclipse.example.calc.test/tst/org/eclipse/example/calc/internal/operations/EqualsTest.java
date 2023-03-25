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

import org.eclipse.example.calc.Operation;
import org.junit.Before;
import org.junit.Test;

// Testing Equals Operation

public class EqualsTest extends AbstractOperationTest {

	private Operation op;

	@Before
	public void setUp() throws Exception {
		op = new Equals();
	}

	@Test
	public void testGetName() {
		assertEquals(op.getName(), "=");
	}

}
