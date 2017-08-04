package com.ves.tutorial.springboot.bo;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ves.tutorial.springboot.model.Employee;

/**
 * Business layer for employee.
 * 
 * @author VES Tutorials
 *
 */
@Service
public class EmployeeService implements IEmployeeService {

	@Override
	public void save(Employee employee) {
		employeeList.add(employee);
	}

	@Override
	public Employee update(Employee employee) {
		Employee emp = employeeList.stream()
				.filter(emp1 -> emp1.getId() == employee.getId())
				.findFirst()
				.get();
		emp.setName(employee.getName());
		emp.setAge(employee.getAge());
		emp.setDesignation(employee.getDesignation());
		emp.setGender(employee.getGender());
		return emp;
	}

	@Override
	public Employee find(int id) {
		return employeeList.stream()
		.filter(emp1 -> emp1.getId() == id)
		.findFirst()
		.get();
	}

	@Override
	public List<Employee> list() {
		return employeeList;
	}

}
