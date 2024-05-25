package com.example.tts.entity;



import java.util.Date;



import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="project")

public class Project {

	@Id
	@Column(name="projectId")
	public int projectId;
	@Column(name="clientid")
	private Integer clientId;
	@Column(name="projectName")
	private String projectName;
	@Column(name="projectDes")
	private String projectDes;	
	@Column(name="projectDeliveryDate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private String projectDeliveryDate;
	@Column(name="s_date")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private String s_date;
	@Column(name="edate")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private String e_date;
	@Column(name="pmId")
	private Integer pmId;
	@Column(name="status")
	private String status;


	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	
		

	public Integer getClientId() {
		return clientId;
	}
	public void setClientId(Integer clientId) {
		this.clientId = clientId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectDes() {
		return projectDes;
	}
	public void setProjectDes(String projectDes) {
		this.projectDes = projectDes;
	}
	public String getProjectDeliveryDate() {
		return projectDeliveryDate;
	}
	public void setProjectDeliveryDate(String projectDeliveryDate) {
		this.projectDeliveryDate = projectDeliveryDate;
	}
	
	public String getS_date() {
		return s_date;
	}
	public void setS_date(String s_date) {
		this.s_date = s_date;
	}
	public String getE_date() {
		return e_date;
	}
	public void setE_date(String e_date) {
		this.e_date = e_date;
	}
	public Integer getPmId() {
		return pmId;
	}
	public void setPmId(Integer pmId) {
		this.pmId = pmId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
