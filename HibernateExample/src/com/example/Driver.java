package com.example;
import java.util.List;

public class Driver {
	
	public static void main(String[] args) {
		EmployeeService employeeService=new EmployeeService();
//		System.out.println("***dropping table employees***");
//		employeeService.dropTable();
//		System.out.println("***creating table employees***");
//		employeeService.createTable();
//		System.out.println("***deleting all employees in employees table***");
//		employeeService.deleteAll();
		Employee employee1=new Employee("ahmet", "yýlmaz", 232);
		Employee employee2=new Employee("mehmet", "tryrthy", 555);
		Employee employee3=new Employee("veli", "dsadsa", 777);
		System.out.println("***persist start***");
		employeeService.persist(employee1);
		employeeService.persist(employee2);
		employeeService.persist(employee3);
		System.out.println("Employees persisted are:");
		findAll(employeeService);
		System.exit(0);
	}

	private static void findAll(EmployeeService employeeService) {
		List<Employee> employees=employeeService.findAll();
		for (Employee employee : employees) {
			System.out.println("-"+employee);
		}
	}

}
