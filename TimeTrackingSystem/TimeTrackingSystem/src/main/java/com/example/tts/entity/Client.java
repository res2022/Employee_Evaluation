package com.example.tts.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="client")
public class Client {

	@Id
	@Column(name="C_Id")
	private int clientId;
	@Column(name="C_Name")
	private String clientName;
	@Column(name="C_Orgn")
	private String clientOrgName;
	@Column(name="C_Address")
	private String clientAddress;
	@Column(name="C_Email")
	private String clientEmail;
	@Column(name="C_Phone")
	private String clientPhoneNo;
	@Column(name="C_Web")
	private String clientWebUrl;

	public int getClientId() {
		return clientId;
	}
	public void setClientId(int clientId) {
		this.clientId = clientId;
	}
	public String getClientName() {
		return clientName;
	}
	public void setClientName(String clientName) {
		this.clientName = clientName;
	}
	public String getClientOrganizationName() {
		return clientOrgName;
	}
	public void setClientOrganizationName(String clientOrganizationName) {
		this.clientOrgName = clientOrganizationName;
	}
	public String getClientAddress() {
		return clientAddress;
	}
	public void setClientAddress(String clientAddress) {
		this.clientAddress = clientAddress;
	}
	public String getClientEmail() {
		return clientEmail;
	}
	public void setClientEmail(String clientEmail) {
		this.clientEmail = clientEmail;
	}
	public String getClientPhoneNo() {
		return clientPhoneNo;
	}
	public void setClientPhoneNo(String clientPhoneNo) {
		this.clientPhoneNo = clientPhoneNo;
	}
	public String getClientWebsiteUrl() {
		return clientWebUrl;
	}
	public void setClientWebsiteUrl(String clientWebsiteUrl) {
		this.clientWebUrl = clientWebsiteUrl;
	}
	public String getClientOrgName() {
		return clientOrgName;
	}
	public void setClientOrgName(String clientOrgName) {
		this.clientOrgName = clientOrgName;
	}
	public String getClientWebUrl() {
		return clientWebUrl;
	}
	public void setClientWebUrl(String clientWebUrl) {
		this.clientWebUrl = clientWebUrl;
	}
//	public Project getProject() {
//		return project;
//	}
//	public void setProject(Project project) {
//		this.project = project;
//	}
//	
	
	
	
	
}
