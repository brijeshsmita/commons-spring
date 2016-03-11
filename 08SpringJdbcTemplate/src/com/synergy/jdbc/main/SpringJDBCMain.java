package com.synergy.jdbc.main;
import java.util.List;
import java.util.Random;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.synergy.jdbc.model.Employee;
import com.synergy.jdbc.service.EmployeeService;
import com.synergy.jdbc.service.IEmployeeService;
public class SpringJDBCMain {
	public static void main(String[] args) {
		//Get the Spring Context
		ConfigurableApplicationContext ctx =
	new ClassPathXmlApplicationContext("servlet-context.xml");
		IEmployeeService employeeService = 
ctx.getBean("employeeService", EmployeeService.class);
		//Run some tests for JDBC CRUD operations
		Employee emp = new Employee();
		int randomId = new Random().nextInt(1000*100);
		emp.setId(randomId);
		emp.setName("Smita");
		emp.setRole("Java Developer");
		//Create
		employeeService.insertRecord(emp);
		//Read
		Employee emp1 = employeeService.retrieveRecord(randomId);
		System.out.println("Employee Retrieved::"+emp1);
		//Get All
		List<Employee> empList = employeeService.retrieveAllRecord();
		System.out.println("===========List Of All Employees=========");
		for(Employee e :empList)
			System.out.println(e);
		System.out.println("=========================================");
		
		//Update
		emp.setRole("CEO");
		int res=employeeService.updateRecord(emp);
		if(res==1){
			empList = employeeService.retrieveAllRecord();
			System.out.println("===========Updated Employees=========");
			for(Employee e :empList)
				System.out.println(e);
			System.out.println("=========================================");
		}
		else
			System.out.println("Record not Updated!!");		
		//Delete
		res=employeeService.deleteRecord(randomId);
		if(res==1)
			System.out.println("Record deleted successfully!!");
		else
			System.out.println("Record not Deleted!!");	
		//Close Spring Context			
		ctx.close();
		System.out.println("DONE");
	}
}
/*
//Update
		emp.setRole("Manager");
		employeeService.updateRecord(emp);
		//Get All
		List<Employee> empList = employeeService.retrieveAllRecord();
		for (Employee e1: empList) {
			System.out.println(e1);
		}
		
		//Delete
	//	employeeService.deleteRecord(randomId);
*/