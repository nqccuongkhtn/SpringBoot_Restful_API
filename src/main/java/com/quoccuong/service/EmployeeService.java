package com.quoccuong.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quoccuong.dao.EmployeeDao;
import com.quoccuong.entities.Employee;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeDao employeeDao;
	public Employee getEmployee(Integer empId)
	{
		return employeeDao.getEmployee(empId);
	}
	public Employee addEmployee(Employee empForm)
	{
		return employeeDao.addEmployee(empForm);
	}
	public Employee updateEmployee(Employee empForm)
	{
		return employeeDao.updateEmployee(empForm);
	}
	public void deleteEmployee(Integer empId)
	{
		employeeDao.deleteEmployee(empId);
	}
	public List<Employee> getAllEmployees()
	{
		return employeeDao.getAllEmployees();
	}
	
}
