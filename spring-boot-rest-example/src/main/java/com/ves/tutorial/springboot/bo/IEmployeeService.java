package com.ves.tutorial.springboot.bo;

import java.util.ArrayList;
import java.util.List;

import com.ves.tutorial.springboot.model.Employee;
/**
 * @author VES Tutorials
 *
 */
public interface IEmployeeService {

	public final List<Employee> employeeList = new ArrayList<Employee>();

	public void save(Employee employee);

	public Employee update(Employee employee);

	public Employee find(int id);

	public List<Employee> list();

}
