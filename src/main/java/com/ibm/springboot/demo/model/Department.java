package com.ibm.springboot.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("departments")
public class Department {
	
	@Id
	private String departmentId;
	private Integer id;
	private String departmentName;
	private String location;
	private String managerId;
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Department(String departmentId, Integer id, String departmentName, String location, String managerId) {
		super();
		this.departmentId = departmentId;
		this.id = id;
		this.departmentName = departmentName;
		this.location = location;
		this.managerId = managerId;
	}
	public String getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", id=" + id + ", departmentName=" + departmentName
				+ ", location=" + location + ", managerId=" + managerId + "]";
	}
	
	
}
