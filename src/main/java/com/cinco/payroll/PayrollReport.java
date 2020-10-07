package com.cinco.payroll;

import java.io.File;
<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * This is the main driver program that parses the payroll
 * data file and produces a payroll report.
 *
 */
public class PayrollReport {

	public static List<Employee> parseDataFile() {
		List<Employee> result = new ArrayList<Employee>();
		File f = new File("data/employee.dat");
		try(Scanner s = new Scanner(f)) {
			while(s.hasNext()) {
				String line = s.nextLine();
				if(!line.trim().isEmpty()) {
					Employee e = null;
					String tokens[] = line.split(";");
					String id = tokens[1];
					String nameTokens[] = tokens[2].split(",");
					String lastName = nameTokens[0];
					String firstName = nameTokens[1];
					String title = tokens[3];
					double annualSalary = 0.0, hourlyPayRate = 0.0, hoursWorked = 0.0;
					if(tokens.length == 6) {
						hourlyPayRate = Double.parseDouble(tokens[4]);
						hoursWorked = Double.parseDouble(tokens[5]);
					} else if(tokens.length == 5) {
						annualSalary = Double.parseDouble(tokens[4]);
					}
					
					if(tokens[0].equals("E")) {
						e = new Employee(); //TODO: modify this
					} else if(tokens[0].equals("S")) {
						e = new Employee(); //TODO: modify this
					} else if(tokens[0].equals("T")) {
						e = new Employee(); //TODO: modify this
					}
					
					result.add(e);
				}
			}
		} catch(Exception e) {
			throw new RuntimeException(e);
		}
=======
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PayrollReport {

	public static List<Employee> parseDataFile() {
		List<Employee> result = new ArrayList<Employee>();
		File f = new File("data/employee.dat");
		Scanner s;
		try {
			s = new Scanner(f);
		} catch(FileNotFoundException fnfe) {
			throw new RuntimeException(fnfe);
		}
		while(s.hasNext()) {
			String line = s.nextLine();
			if(!line.trim().isEmpty()) {
				Employee e = null;
				String tokens[] = line.split(";");
				String id = tokens[1];
				String nameTokens[] = tokens[2].split(",");
				String lastName = nameTokens[0];
				String firstName = nameTokens[1];
				String title = tokens[3];
				double annualSalary = 0.0, hourlyPayRate = 0.0, hoursWorked = 0.0;
				if(tokens.length == 6) {
					hourlyPayRate = Double.parseDouble(tokens[4]);
					hoursWorked = Double.parseDouble(tokens[5]);
				} else if(tokens.length == 5) {
					annualSalary = Double.parseDouble(tokens[4]);
				}
				
				if(tokens[0].equals("E")) {
					e = new SalaryEmployee(); //TODO: modify this
				} else if(tokens[0].equals("S")) {
					e = new Staff(); //TODO: modify this
				} else if(tokens[0].equals("T")) {
					e = new Temporary(); //TODO: modify this
				}
				
				result.add(e);
			}
		}
		
>>>>>>> refs/remotes/origin/master
		return result;
	}
	
	public static void main(String args[]) {

		//get the employees from the data file
		List<Employee> payroll = parseDataFile();

		StringBuilder sb = new StringBuilder();
		
		sb.append(String.format("%-8s %-20s %-10s %-30s %9s %9s %9s\n", 
				"ID", "Name", "Type", "Title", "Gross", "Taxes", "Net"));

		//for each employee
		for(Employee e : payroll) {
			//format their information
			sb.append(String.format("%-8s %-20s %-10s %-30s $%8.2f $%8.2f $%8.2f\n", 
					"TODO", "TODO", "TODO", "TODO", 0.0, 0.0, 0.0)); //TODO: replace these
		}
		
		System.out.println(sb);
	}
	
}
