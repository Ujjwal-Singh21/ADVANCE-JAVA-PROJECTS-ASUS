package com.jpa.JPAProject;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employee_jpa")
class Employee {

	@Id
	private int employeeId;
	private String employeeName;
	private double empSalary;
	
	public Employee() {
		super();
	}

	public Employee(int employeeId, String employeeName, double empSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.empSalary = empSalary;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee5 [employeeId=" + employeeId + ", employeeName=" + employeeName + ", empSalary=" + empSalary + "]";
	}
}
