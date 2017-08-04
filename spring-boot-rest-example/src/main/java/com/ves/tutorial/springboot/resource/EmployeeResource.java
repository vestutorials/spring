package com.ves.tutorial.springboot.resource;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ves.tutorial.springboot.bo.IEmployeeService;
import com.ves.tutorial.springboot.model.Employee;

/**
 * @author VES Tutorials
 *
 */
@RestController
@RequestMapping(value = "/employee/", produces = { MediaType.APPLICATION_XML_VALUE,
		MediaType.APPLICATION_JSON_VALUE }, consumes = { MediaType.APPLICATION_XML_VALUE,
				MediaType.APPLICATION_JSON_VALUE })
public class EmployeeResource {

	@Autowired
	private IEmployeeService employeeService;

	@RequestMapping(value = "save", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		employeeService.save(employee);
		return new ResponseEntity<String>("Employee Saved", HttpStatus.OK);
	}

	@RequestMapping(value = "update", method = RequestMethod.PUT)
	@ResponseBody
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee udpatedEmployee = employeeService.update(employee);
		return new ResponseEntity<Employee>(udpatedEmployee, HttpStatus.OK);
	}

	@RequestMapping(value = "list", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<List<Employee>> listAll() {
		List<Employee> employeeList = employeeService.list();
		if (employeeList == null) {
			return new ResponseEntity<List<Employee>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employee>>(employeeList, HttpStatus.OK);
	}

	@RequestMapping(value = "find", method = RequestMethod.GET)
	public ResponseEntity<Employee> findEmployee(@RequestParam("employeeId") int employeeId) {
		Employee employee = employeeService.find(employeeId);
		try {
			return new ResponseEntity<Employee>(employee, HttpStatus.OK);
		} catch (NoSuchElementException ex) {
			return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		}
	}

}
