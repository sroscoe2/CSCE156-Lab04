package com.cinco.payroll;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This is a suite of tests for the various {@link #Employee} derived classes.
 * The compiler errors should be addressed once you've completed the lab.
 * 
 */
public class PayrollTests {

	private static final List<Employee> employees = PayrollReport.parseDataFile();

	/**
	 * Tests that the various {@link #Employee} derived classes have implemented the
	 * <code>getNetPay()</code> method correctly.
	 * 
	 */
	@Test
	void employeeNetPayTest() {
		double expected = 100.0;
		double total = 0.0;
		for (Employee e : employees) {
			total += e.getNetPay();
		}
		Assertions.assertEquals(expected, total);
	}

	/**
	 * Tests that the various {@link #Employee} derived classes have implemented the
	 * <code>getGrossPay()</code> method correctly.
	 * 
	 */
	@Test
	void employeeGrossPayTest() {
		double expected = 100.0;
		double total = 0.0;
		for (Employee e : employees) {
			total += e.getGrossPay();
		}
		Assertions.assertEquals(expected, total);
	}

	/**
	 * Tests that the various {@link #Employee} derived classes have implemented the
	 * <code>getNetPay()</code> method correctly.
	 * 
	 */
	@Test
	void employeeTaxesTest() {
		double expected = 100.0;
		double total = 0.0;
		for (Employee e : employees) {
			total += e.getTaxes();
		}
		Assertions.assertEquals(expected, total);
	}

}
