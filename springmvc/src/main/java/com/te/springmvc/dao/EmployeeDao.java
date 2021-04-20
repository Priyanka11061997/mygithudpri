package com.te.springmvc.dao;

import com.te.springmvc.bean.EmployeeBean;

public interface EmployeeDao {
	
	public EmployeeBean authentication(int id, String pwd);
	 public EmployeeBean getEmployee(int id);
	 
	 public boolean deleteEmpData(int id);
	 
	// public List<E> getAllEmp(int id);
		
	
}
