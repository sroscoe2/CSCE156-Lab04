package com.cinco.payroll;

import org.junit.Test;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * This is a suite of tests for the various {@link #Employee} derived classes.
 * The compiler errors should be addressed once you've completed the lab.
 * 
 */
public class PayrollTests {

	/**
	 * Tests that the {@link #Employee} and {@link #HourlyEmployee} classes are
	 * <code>abstract</code>
	 */
	@Test
	public void employeeTest() {
		assertTrue(Modifier.isAbstract(Employee.class.getModifiers()), "Employee must be abstract");
		assertTrue(Modifier.isAbstract(HourlyEmployee.class.getModifiers()), "Employee must be abstract");
	}

	/**
	 * Tests that the constructor and pay rates are correctly calculated in the
	 * {@link #HourlyEmployee} class
	 */
	@Test
	public void hourlyEmployeeTest() {
		assertTrue(Modifier.isAbstract(HourlyEmployee.class.getModifiers()));
		//assertEquals(3, HourlyEmployee.class.getDeclaredMethods().length, "Must declare methods as in the UML diagram");
		assertTrue(Employee.class.isAssignableFrom(HourlyEmployee.class), "Temporary must extend Hourly");

		HourlyEmployee hourlyEmployee = new Temporary("B0CAF2", "Neil", "Hamburger", "Janitor", 10.2, 20);
		assertEquals(204, hourlyEmployee.getGrossPay(), "Check how your HourlyEmployee is calculating gross pay");
		assertEquals(10.2, hourlyEmployee.getHourlyPayRate(), "Check how your HourlyEmployee is storing hourly pay");
		assertEquals(20, hourlyEmployee.getHoursWorked(), "Check how your HourlyEmployee is storing hours worked");
	}

	/**
	 * Tests that the constructor and pay rates are correctly calculated in the
	 * {@link #Temporary} class
	 */
	@Test
	public void temporaryEmployeeTest() {
		assertFalse(Modifier.isAbstract(Temporary.class.getModifiers()));
		assertEquals(2, Temporary.class.getDeclaredMethods().length, "Must declare methods as in the UML diagram");
		assertTrue(HourlyEmployee.class.isAssignableFrom(Temporary.class), "Temporary must extend Hourly");

		Temporary temp = new Temporary("B0CAF2", "Neil", "Hamburger", "Janitor", 10.2, 20);
		assertEquals(0, temp.getTaxes(), "Temp employees don't pay taxes");
		assertEquals("Temporary", temp.getType(), "Are you sure you are storing the correct type?");
		assertEquals(204, temp.getGrossPay(), "Check how your HourlyEmployee is calculating gross pay");
		assertEquals(204, temp.getNetPay(), "Check how your Employee is calculating net pay");
	}

	/**
	 * Tests that the constructor and pay rates are correctly calculated in the
	 * {@link #Staff} class
	 */
	@Test
	public void staffTest() {
		assertFalse(Modifier.isAbstract(Staff.class.getModifiers()));
		assertEquals(2, Staff.class.getDeclaredMethods().length, "Must declare methods as in the UML diagram");
		assertTrue(HourlyEmployee.class.isAssignableFrom(Staff.class), "Staff must extend HourlyEmployee");

		Staff staff = new Staff("FA0112", "Jan", "Skylar", "Professional Assistant", 8.45, 40);
		assertEquals(338, staff.getGrossPay(), 0.01, "Check how your HourlyEmployee is calculating net pay");
		assertEquals(50.7, staff.getTaxes(), 0.01, "Check the staff taxes calculation");
		assertEquals(287.3, staff.getNetPay(), 0.01, "Check how your Employee is calculating net pay");
		assertEquals("Staff", staff.getType(), "Are you sure you are storing the correct type?");
	}

	/**
	 * Tests that the constructor and pay rates are correctly calculated in the
	 * {@link #SalaryEmployee} class
	 */
	@Test
	public void salaryTest() {
		assertFalse(Modifier.isAbstract(SalaryEmployee.class.getModifiers()));
		assertEquals(4, SalaryEmployee.class.getDeclaredMethods().length, "Must declare methods as in the UML diagram");
		assertTrue(Employee.class.isAssignableFrom(SalaryEmployee.class), "SalaryEmployee must extend Employee");

		SalaryEmployee staff = new SalaryEmployee("011F42", "Tim", "Heidecker", "President", 120000);
		assertEquals(2307.69, staff.getGrossPay(), 0.01, "Check how your SalaryEmployee is calculating net pay");
		assertEquals(461.54, staff.getTaxes(), 0.01, "Check the salary tax calculation ");
		assertEquals(1946.15, staff.getNetPay(), 0.01, "Check how your Employee is calculating net pay");
		assertEquals("Salary", staff.getType(), "Are you sure you are storing the correct type?");
	}

	/**
	 * Tests that the {@link #Employee} and {@link #Supplier} classes implement the
	 * {@link #Payable} interface
	 */
	@Test
	public void payableTest() {
		assertTrue(new ArrayList<>(Arrays.asList(Employee.class.getInterfaces())).contains(Payable.class),
				"Employee must implement the Payable Interface");
		assertTrue(new ArrayList<>(Arrays.asList(Supplier.class.getInterfaces())).contains(Payable.class),
				"Employee must implement the Payable Interface");
		assertEquals(300, new Supplier("Google", 300).getNetPay(), 0.01,
				"Check that your suppliers are being paid correctly");
	}
}
