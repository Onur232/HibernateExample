package com.example;
import java.util.List;

public class EmployeeService {
	
	private static EmployeeDAO employeeDAO;
	
	public EmployeeService() {
		employeeDAO=new EmployeeDAO();
//		initializeHibernate();
	}
	
	private void initializeHibernate() {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.closeCurrentSessionwithTransaction();
		employeeDAO.openCurrentSession();
		employeeDAO.closeCurrentSession();
	}

	public void persist(Employee entity) {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.persist(entity);
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	
	public void update(Employee entity) {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.update(entity);
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	
	public Employee findById(String id) {
		employeeDAO.openCurrentSession();
		Employee employee=employeeDAO.findById(id);
		employeeDAO.closeCurrentSession();
		return employee;
	}
	
	public void delete(String id) {
		employeeDAO.openCurrentSessionwithTransaction();
		Employee employee=employeeDAO.findById(id);
		employeeDAO.delete(employee);
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	
	public List<Employee> findAll(){
		employeeDAO.openCurrentSession();
		List<Employee> employees=employeeDAO.findAll();
		employeeDAO.closeCurrentSession();
		return employees;
	}
	
	public void deleteAll() {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.deleteAll();
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	
	public EmployeeDAO employeeDao() {
		return employeeDAO;
	}
	
	public void dropTable() {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.dropTable();
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	
	public void createTable() {
		employeeDAO.openCurrentSessionwithTransaction();
		employeeDAO.createTable();
		employeeDAO.closeCurrentSessionwithTransaction();
	}
	

}
