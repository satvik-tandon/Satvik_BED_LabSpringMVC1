package com.greatlearning.employeeManagementSystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employeeManagementSystem.entity.Employee;
import com.greatlearning.employeeManagementSystem.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepo;

	@Autowired
	public EmployeeServiceImpl(EmployeeRepository empEmployeeRepository) {
		this.employeeRepo = empEmployeeRepository;
	}

	@Override
	public List<Employee> findAll() {

		List<Employee> employeesList = employeeRepo.findAll();
		return employeesList;
	}

	@Override
	public Employee findById(int theId) {
		return null;
	}

	@Override
	public void saveEmployee(Employee employee) {
		employeeRepo.save(employee);

	}

	@Override
	public Employee getEmployeeById(Long id) {
		Optional<Employee> result = employeeRepo.findById(id);

		if (result.isPresent())
			return result.get();
		else
			throw new RuntimeException("Employee ID " + id + "not found");

	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existEmployee = (Employee) getEmployeeById(id);
		existEmployee.setFirstName(employee.getFirstName());
		existEmployee.setLastName(employee.getLastName());
		existEmployee.setEmail(employee.getEmail());

		return employeeRepo.save(existEmployee);

	}

	@Override
	public void deleteEmployeeById(int theId) {
		employeeRepo.deleteById((long) theId);

	}
}
