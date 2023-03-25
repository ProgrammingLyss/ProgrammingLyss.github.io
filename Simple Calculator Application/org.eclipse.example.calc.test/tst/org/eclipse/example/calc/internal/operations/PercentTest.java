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

// Testing Unary Percent Operation

public class PercentTest extends AbstractOperationTest {

	private Operation op;

	@Before
	public void setUp() throws Exception {
		op = new Percent();
	}

	@Test
	public void testGetName() {
		assertEquals(op.getName(), "%");
	}
}
