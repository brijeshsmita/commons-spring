package com.synergy.jdbc.main;
import java.nio.file.ClosedFileSystemException;
import java.util.List;
import java.util.Random;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.synergy.jdbc.dao.EmployeeDAO;
import com.synergy.jdbc.model.Employee;
import com.synergy.jdbc.service.EmployeeService;
import com.synergy.jdbc.service.EmployeeServiceImpl;
public class SpringJDBCMain {
	public static void main(String[] args) {
		//Get the Spring Context
		ConfigurableApplicationContext ctx =
	new FileSystemXmlApplicationContext("D:\\Spring\\009JdbcTemplateMaven\\src\\main\\resources\\applicationContext.xml");
		EmployeeService employeeService = 
ctx.getBean("employeeServiceImpl", EmployeeServiceImpl.class);
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
		//Close Spring Context
		//Update
		emp.setRole("CEO");
		employeeService.updateRecord(emp);
		//Get All
		List<Employee> empList = employeeService.retrieveAllRecord();
		System.out.println(empList);
		//Delete
		employeeService.deleteRecord(randomId);
		ctx.close();
		System.out.println("DONE");
	}
}
/*

*/