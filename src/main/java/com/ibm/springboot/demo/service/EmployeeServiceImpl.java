package com.ibm.springboot.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.model.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	List<Employee> l = new ArrayList<>();
	Employee found;

		Employee e1 = new Employee(1, "Robert", 11.5);
		Employee e2 = new Employee(2, "Jhon", 12);
		Employee e3 = new Employee(3, "Doe", 15);
	{
		l.add(e1);
		l.add(e2);
		l.add(e3);
	}


	@Override
	public Employee getEmployeeById(Integer employeeId) {
		 
		
		l.forEach(e->{
			if (e.getEmpId()==employeeId) {
				found = e;
			}
		});
		
		return found;
	}

	@Override
	public List<Employee> getAllEmployees() {
		return l;
	}

	@Override
	public Employee updateEmployee(Employee employee) {
		Employee temp = getEmployeeById(employee.getEmpId());
		temp.setEmpName("Zack");
		l.remove(temp);
		l.add(temp);
		return temp;
	}

	@Override
	public Employee deleteEmployee(Integer employeeId) {
		
		Employee temp = getEmployeeById(employeeId);
		l.remove(temp);
		return temp;
		
	}

	@Override
	public Employee createEmployee(int empId,String name,double salary) {
		Employee temp = (new Employee(empId,name,salary));
		l.add(temp);
		return temp;
	}
	
	

}
