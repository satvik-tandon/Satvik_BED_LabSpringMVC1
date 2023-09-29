package com.greatlearning.employeeManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.greatlearning.employeeManagementSystem.entity.Employee;
import com.greatlearning.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {

	private EmployeeService employeeService;

	@Autowired
	public EmployeeController(EmployeeService EmpService) {
		this.employeeService = EmpService;
	}

	@GetMapping("/employees")
	public String listEmployees(Model model) {

		List<Employee> employees = employeeService.findAll();
		model.addAttribute("employees", employees);
		return "employees";
	}

	@GetMapping("/employees/add")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String updateEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", employeeService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee employee) {
		employeeService.updateEmployee(id, employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String delete(@PathVariable int id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/employees";

	}

}
