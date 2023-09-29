package com.greatlearning.employeeManagementSystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employeeManagementSystem.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}