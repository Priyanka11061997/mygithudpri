package com.te.springmvc.bean;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="Employee_info")
public class EmployeeBean {
	
	@Id
	@Column
	private Integer id;

	@Column
    private String name;
    
	@Column(name="dob")
    private Date birthdate;
    
	@Column(name="password")
    private String pwd;

}
