package com.test.jni;

public class EmployeeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] staff = new Employee[3];
		staff[0] = new Employee("Harry Hacker", 35000);
		staff[1] = new Employee("Carl Cracker", 75000);
		staff[2] = new Employee("Tony Tester", 35000);
		
		for (Employee employee : staff) {
			employee.raiseSalary(5);
		}
		
		for (Employee employee : staff) {
			employee.print();
		}
	}

}
