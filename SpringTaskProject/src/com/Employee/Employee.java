package com.Employee;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Employee {

	private int empId;
	private String empName;
	private double empSalary;
	private Address address;
	private List<String> bookList;
	private Set<Integer> mobileNumbers;
	private Map<String, String> favouriteSportsPersons;

	public Employee() {
		super();
	}

	public Employee(int empId, String empName, double empSalary, Address address, List<String> bookList,
			Set<Integer> mobileNumbers, Map<String, String> favouriteSportsPersons) {
		super();
		System.out.println("Constructor injection");
		this.empId = empId;
		this.empName = empName;
		this.empSalary = empSalary;
		this.address = address;
		this.bookList = bookList;
		this.mobileNumbers = mobileNumbers;
		this.favouriteSportsPersons = favouriteSportsPersons;
	}

	public int getEmpId() {
		return empId;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getBookList() {
		return bookList;
	}

	public void setBookList(List<String> bookList) {
		this.bookList = bookList;
	}

	public Set<Integer> getMobileNumbers() {
		return mobileNumbers;
	}

	public void setMobileNumbers(Set<Integer> mobileNumbers) {
		this.mobileNumbers = mobileNumbers;
	}

	public Map<String, String> getFavouriteSportsPersons() {
		return favouriteSportsPersons;
	}

	public void setFavouriteSportsPersons(Map<String, String> favouriteSportsPersons) {
		this.favouriteSportsPersons = favouriteSportsPersons;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empSalary=" + empSalary + ", address=" + address
				+ ", bookList=" + bookList + ", mobileNumbers=" + mobileNumbers + ", favouriteSportsPersons="
				+ favouriteSportsPersons + "]";
	}

}
