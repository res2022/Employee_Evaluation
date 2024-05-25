package com.example.tts.entity;




import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
@Entity
@Table(name="task")
public class Task {

	@Id
	@Column(name="Task_Id")
	private int taskId;
	@Column(name="Project_Id")
	 private int projectId;
	@Column(name="Ttitle")
	 private String  taskTitle;
	
	@Column(name="Taskdspn")
	 private String taskDspn;
	@Column(name="Tasksdate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	 private String taskStartDate;
	@Column(name="Taskedate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	 private String taskEndDate; 
	@Column(name="emp_Id")
	 private int empId;
	@Column(name="status")
	private String status;
	@Column(name="pm_Id")
	private Integer pmId;
	
	
	

	public Integer getPmId() {
		return pmId;
	}
	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}
	public int getTaskId() {
		return taskId;
	}
	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}
	
	public String getTaskTitle() {
		return taskTitle;
	}
	public void setTaskTitle(String taskTitle) {
		this.taskTitle = taskTitle;
	}
	
	
	
	public String getTaskDspn() {
		return taskDspn;
	}
	public void setTaskDspn(String taskDspn) {
		this.taskDspn = taskDspn;
	}
	public String getTaskStartDate() {
		return taskStartDate;
	}
	public void setTaskStartDate(String taskStartDate) {
		this.taskStartDate = taskStartDate;
	}
	public String getTaskEndDate() {
		return taskEndDate;
	}
	public void setTaskEndDate(String taskEndDate) {
		this.taskEndDate = taskEndDate;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
	
	
	
}
