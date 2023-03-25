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

import org.eclipse.example.calc.BinaryOperation;
import org.junit.Before;
import org.junit.Test;

// Testing Binary Divide Operation

public class DivideTest extends AbstractOperationTest {

	private BinaryOperation op;

	@Before
	public void setUp() throws Exception {
		op = new Divide();
	}

	@Test
	public void testGetName() {
		assertEquals(op.getName(), "/");
	}
}
