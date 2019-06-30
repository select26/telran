package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import app.ICalculator;
import app.SimpleCalculator;

public class SimpleCalculatorTest {
	
	ICalculator calculator = new SimpleCalculator();

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testMultiplyIntInt() {
//		fail("Not yet implemented");
		assertEquals(4, calculator.multiply(2, 2));
		assertEquals(-4, calculator.multiply(-2, 2));
		assertEquals(6, calculator.multiply(-2, -3));
		assertEquals(0, calculator.multiply(0, -2));
		assertEquals(-2, calculator.multiply(Integer.MAX_VALUE, 2));
	}

	@Test
	public void testMultiplyFloatFloat() {
//		fail("Not yet implemented");
		assertEquals(4.4, calculator.multiply(2.2F, 2F), 0.000_001);
	}

	@Test
	public void testDevideIntInt() {
//		fail("Not yet implemented");
		assertEquals(2, calculator.devide(4, 2));
		assertEquals(Integer.MAX_VALUE, calculator.devide(5, 0));
		assertEquals(2, calculator.devide(5, 2));
	}
	
	@Test
	public void testDevideFloatFloat() {
		assertEquals(2.2, calculator.devide(4.4F, 2), 0.000_001);
		assertEquals(-2.3, calculator.devide(-4.6F, 2), 0.000_001);
//		assertEquals(Float.NaN, calculator.devide(4.0F, 0), 0.000_001);
		assertFalse(Float.isFinite(calculator.devide(4.4F, 0)));
		assertTrue(Float.isNaN(calculator.devide(4.4F, 0)));
	}

}
