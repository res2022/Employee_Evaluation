package com.example.tts.entity;





import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name="employee")
public class Employee {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name="id")
	private int  empId;
	@Column(name="name")
	private String empName;
	@Column(name="address")
	private String empAddress;
	@Column(name="dob")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private  Date  empDob;

    @Column(name="phone")
	private String empPhoneNo;
	@Column(name="dept")
	private String empDepartment;
	@Column(name="desgn")
	private String empDesignation;
//	@OneToOne(cascade = CascadeType.ALL)
//	  @JoinTable(name = "Employee_Login",
//	      joinColumns = @JoinColumn(name = "employee_id"),
//	      inverseJoinColumns = @JoinColumn(name = "login_id"))
//	  private Login login;

	public int getEmpId() {
		return empId;
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
	public String getEmpAddress() {
		return empAddress;
	}
	public void setEmpAddress(String empAddress) {
		this.empAddress = empAddress;
	}
	public Date getEmpDob() {
		return empDob;
	}
	public void setEmpDob(Date empDob) {
		this.empDob = empDob;
	}

	public String getEmpPhoneNo() {
		return empPhoneNo;
	}
	public void setEmpPhoneNo(String empPhoneNo) {
		this.empPhoneNo = empPhoneNo;
	}
	public String getEmpDepartment() {
		return empDepartment;
	}
	public void setEmpDepartment(String empDepartment) {
		this.empDepartment = empDepartment;
	}
	public String getEmpDesignation() {
		return empDesignation;
	}
	public void setEmpDesignation(String empDesignation) {
		this.empDesignation = empDesignation;
	}
	
}
