package com.quoccuong.entities;
// Generated Jun 6, 2019, 7:56:19 PM by Hibernate Tools 5.1.10.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Employee generated by hbm2java
 */
@Entity
@Table(name = "employee", catalog = "employees")
public class Employee implements java.io.Serializable {

	private Integer empId;
	private String empNo;
	private String empName;

	public Employee() {
	}

	public Employee(String empNo, String empName) {
		this.empNo = empNo;
		this.empName = empName;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "empId", unique = true, nullable = false)
	public Integer getEmpId() {
		return this.empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	@Column(name = "empNo", length = 45)
	public String getEmpNo() {
		return this.empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	@Column(name = "empName", length = 45)
	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}
