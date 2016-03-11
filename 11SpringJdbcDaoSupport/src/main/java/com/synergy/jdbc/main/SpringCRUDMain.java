package com.synergy.jdbc.main;

import java.util.List;
import java.util.Random;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.synergy.jdbc.model.Employee;
import com.synergy.jdbc.service.EmployeeService;
import com.synergy.jdbc.service.EmployeeServiceImpl;

public class SpringCRUDMain {

	public static void main(String[] args) {
		//Get the Spring Context
		@SuppressWarnings("resource")
		ConfigurableApplicationContext ctx =
		new FileSystemXmlApplicationContext("D:\\Spring\\010SpringJdbcDaoSupport\\src\\main\\resources\\applicationContext.xml");
			
		//Get the employeeService Bean
		EmployeeService employeeService = 
						ctx.getBean("employeeServiceImpl", EmployeeServiceImpl.class);		
		Employee emp = new Employee();
		int randomId = new Random().nextInt(1000*100);
		emp.setId(randomId);
		emp.setName("Smita");
		emp.setRole("Java Developer");		
		//Create/insert
		employeeService.insertRecord(emp);
		
		//Read/retrieve
		Employee emp1 = employeeService.retrieveRecord(randomId);
		if(emp1!=null)
			System.out.println("Employee Retrieved::"+emp1);
		else
			System.out.println("Employee does not exists");
		
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
