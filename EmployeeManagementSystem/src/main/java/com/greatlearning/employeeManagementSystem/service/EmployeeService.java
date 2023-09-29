package com.greatlearning.employeeManagementSystem.service;

import java.util.List;

import com.greatlearning.employeeManagementSystem.entity.Employee;

public interface EmployeeService {

	public List<Employee> findAll();

	public Employee findById(int theId);

	public void saveEmployee(Employee employee);

	public void deleteEmployeeById(int theId);

	public Object getEmployeeById(Long id);

	public Employee updateEmployee(Long id, Employee employee);
}
