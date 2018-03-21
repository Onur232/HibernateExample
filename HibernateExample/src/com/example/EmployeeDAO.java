package com.example;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.annotations.common.annotationfactory.AnnotationFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;


public class EmployeeDAO {
	
	private Session currentSession;
	private Transaction currentTransaction;
	
	public Session openCurrentSession() {
		currentSession=getSessionFactory().openSession();
		return currentSession;
	}
	
	public Session openCurrentSessionwithTransaction() {
		currentSession=getSessionFactory().openSession();
		currentTransaction=currentSession.beginTransaction();
		return currentSession;
	}
	
	public void closeCurrentSession() {
		currentSession.close();
	}
	
	public void closeCurrentSessionwithTransaction() {
		currentTransaction.commit();
		currentSession.close();
	}
	
	private static SessionFactory getSessionFactory() {
		
		Configuration configuration=new Configuration().configure();
		configuration.addAnnotatedClass(Employee.class);
		StandardServiceRegistryBuilder builder=new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		SessionFactory sessionFactory=configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	public Session getCurrentSession() {
		return currentSession;
	}
	
	public void setCurrentSession(Session currentSession) {
		this.currentSession=currentSession;
	}

	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}

	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}
	
	public void persist(Employee entity) {
		getCurrentSession().save(entity);
	}

	public void update(Employee entity) {
		getCurrentSession().update(entity);
	}
	
	public Employee findById(String id) {
		Employee employee=getCurrentSession().get(Employee.class, id);
		return employee;
	}
	
	public void delete(Employee entity) {
		getCurrentSession().delete(entity);
	}
	
	public List<Employee> findAll(){
		List<Employee> employees = getCurrentSession().createQuery("FROM Employee").list();
		return employees;
	}
	
	public void deleteAll() {
		List<Employee> entityList=findAll();
		for (Employee employee : entityList) {
			delete(employee);
		}
	}

	//benim sonradan eklediðim metotlar. çalýþtýðý denenmeli. table'ý entity class ile hibernate'e
	//yaptýrmalýsýn. þu an database sql ile mysql tarafýndan yapýlýyor.
	@SuppressWarnings("deprecation")
	public void dropTable() {
		getCurrentSession().createSQLQuery("DROP TABLE employees").executeUpdate();
		
	}
	
	@SuppressWarnings("deprecation")
	public void createTable() {
		getCurrentSession().createSQLQuery("CREATE TABLE employees").executeUpdate();
	}

	//end of benim sonradan eklediðim metotlar
}
