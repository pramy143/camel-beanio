package org.example.model;

import java.io.Serializable;
import java.util.List;

public class Employees  implements Serializable
{
  
	 private static final long serialVersionUID = 1L;
	 private List<Employee> employee = null;

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

}