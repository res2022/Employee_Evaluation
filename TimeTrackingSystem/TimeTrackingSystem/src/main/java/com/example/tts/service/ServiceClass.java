package com.example.tts.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.tts.entity.Employee;
import com.example.tts.entity.LeaveAppln;
import com.example.tts.entity.Login;
import com.example.tts.dto.EmployeeRegistration;
import com.example.tts.entity.Client;
import com.example.tts.entity.EmpReport;
import com.example.tts.entity.EmpStatus;
import com.example.tts.entity.Project;
import com.example.tts.entity.Task;
import com.example.tts.repository.ClientRepository;
import com.example.tts.repository.EmpStatusRepository;
import com.example.tts.repository.EmployeeReportRepository;
import com.example.tts.repository.EmployeeRepository;
import com.example.tts.repository.LeaveApplnRepository;
import com.example.tts.repository.LoginRepository;
import com.example.tts.repository.ProjectRepository;
import com.example.tts.repository.TaskRepository;




@Service
public class ServiceClass {
	
	@Autowired
	LoginRepository loginRepo;
	
	@Autowired
	EmployeeRepository employeeRepo;
	
	@Autowired
	ProjectRepository projectRepo;
	
	@Autowired
	TaskRepository taskRepo;
	
	@Autowired
	EmployeeReportRepository empReportRepo;
	
	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	LeaveApplnRepository leaveApplnRepo;
	
	@Autowired
	EmpStatusRepository empStatusRepo;
	
	
	
	public Login getByUsernameAndPassword(String username,String password)
	{
		return loginRepo.findByUsernameAndPassword(username,password);
		
	}
	public Login getByUsername(String username)
	{
		return loginRepo.findByUsername(username);
		
	}
	
		public Employee getEmployeeById(Integer id)
	{
		return employeeRepo.findById(id).get();
	
	}
		

		public void deleteLogin(Login login)
		{ 
			loginRepo.delete(login);
		}
	public Employee saveEmployee(Employee employee)
	{
		return employeeRepo.save(employee);
		
	}
	public List<Employee> getAllEmployee()
	{
		return employeeRepo.findAll();
		
	}
	public void deleteEmployee(Employee employee) {
		
		employeeRepo.delete(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		
		return employeeRepo.save(employee);
	}
	
	public List<Employee> getEmpProMangr(String desgn)
	{
		
		
		return employeeRepo.findByEmpDesignation(desgn);
		
	}
	public List<Employee> getEmpDesgnNotPM()
	{
		return employeeRepo.findByEmpDesgnNotPM();
	}
	public List<Employee> getByPMdesgn()
	{
		return employeeRepo.findByPMdessgn();
	}
	
	public Client saveClient(Client client)
	{
		return clientRepo.save(client);
		
	}
	
	public LeaveAppln saveLeaveAppln(LeaveAppln appln)
	{
		
		appln.setStatus("Pending");
		
		return leaveApplnRepo.save(appln);
		
	}
	public List<LeaveAppln> getEmpLeaveAppln()
	{
         return leaveApplnRepo.findAll();
		
	}
	public LeaveAppln getLeaveApplnById(Integer id)
	{
			
		return leaveApplnRepo.findById(id).get();
	
	}
//	public void deleteEloyee(Employee employee) {
//		employeeRepo.delete(employee);
//	}

public LeaveAppln approvLeave(LeaveAppln leave)
{
  
  leave.setStatus("Approved");
	return leaveApplnRepo.save(leave);
}
public LeaveAppln rejectLeave(LeaveAppln leave)
{
	leave.setStatus("Rejected");
	return leaveApplnRepo.save(leave);
}
	
	
	public List<Client> getAllClient()
	{
		return clientRepo.findAll();		
	}
	
	public Client getClientById(Integer id)
	{
		return clientRepo.findById(id).get();

	}
		
	public void deleteClient(Client client) {
		
		clientRepo.delete(client);
	}
public Client updateClient(Client client) {
		
		return clientRepo.save(client);
	}
	
	public Project saveProject(Project project)
	{
		return projectRepo.save(project);
		
	}
	public List<Project> getAllProject()
	{
		return projectRepo.findAll();
		
	}
	
	public Project getProjectById(Integer id)
	{
		return projectRepo.findById(id).get();
	}
	
	public void deleteProject(Project project) {
		
		projectRepo.delete(project);
	}
public Project updateProject(Project project) {
		
		return projectRepo.save(project);
	}
	

	public Task saveTask(Task task)
	{
      task.setStatus("");
		return taskRepo.save(task);
		
	}
	public List<Task> getAllTask()
	{
		return taskRepo.findAll();
		
	}
	public List<Task> getAllTaskByEmpId(Object attribute)
	{
		return taskRepo.findTaskByEmpId(attribute);
		
	}
	public Task getTaskById(Integer id)
	{
		return taskRepo.findById(id).get();

			}

	public Task pendingTask(Task task)
	{
		task.setStatus("Pending");
		return taskRepo.save(task);
	}
		
	public Task onProTask(Task task)
	{
		task.setStatus("OnProgress");
		return taskRepo.save(task);
	}
	public Task completedTask(Task task)
	{
		task.setStatus("Completed");
		return taskRepo.save(task);
	}	
	
	public void deleteTask(Task task) 
	{
		taskRepo.delete(task);
	}
public Task updateTask(Task task) {
		
		return taskRepo.save(task);
	}
	
//
public List<Task> getTaskByStatus(String status)
{
	List<Task> task = taskRepo.findByStatus(status);

	 return task;
}



	
	public Employee registration(EmployeeRegistration regstr)
	{
		Employee obj=new Employee();
		obj.setEmpName(regstr.getName());
		obj.setEmpAddress(regstr.getAddr());
		obj.setEmpDob(regstr.getDob());
		obj.setEmpPhoneNo(regstr.getPhone());
		obj.setEmpDepartment(regstr.getDepat());
		obj.setEmpDesignation(regstr.getDesgn());
		//Employee saveEmp = employeeRepo.save(obj);
		Login nw= new Login();
		//nw.setUserId(regstr.getId());
		nw.setUsername(regstr.getUsername());
		nw.setPassword(regstr.getPassword());
		nw.setUserType(regstr.getDesgn());
		nw.setEmployee(obj);
		loginRepo.save(nw);
		
		
		//saveEmp.getEmpId();
		return employeeRepo.save(obj);
		
	}

	public void addPmId(Integer prjId, Integer empId) {
		Project project = projectRepo.findById(prjId).get();
	
		project.setPmId(empId);
		projectRepo.save(project);
	}

	public void addStatus(Integer id,String status)
	{
		Project project = projectRepo.findById(id).get();
		project.setStatus(status);
		projectRepo.save(project);
	}
	
	public EmpStatus saveDailyStatus(EmpStatus empStatus) {

		empStatus.setReview("Pending");
		return empStatusRepo.save(empStatus);
		
	}
	
	public EmpStatus getEmpStatusById(Integer id)
	{
		return empStatusRepo.findById(id).get();
		
	}
	
	public List<EmpStatus> getAllEmpStatus()
	{
		return empStatusRepo.findAll();
		
	}

	public List<EmpStatus> getEmpStatusByTaskId(Integer id) {
		return empStatusRepo.findBytaskId(id);
	}

	public EmpStatus approve(EmpStatus empStatus) {
		
		empStatus.setReview("Approve");
		return  empStatusRepo.save(empStatus);
	}
    public EmpStatus reject(EmpStatus empStatus) {
		
		empStatus.setReview("Reject");
		return  empStatusRepo.save(empStatus);
	}
	public List<Project> getSelectedProject(String s_date,String e_date)
{
	return projectRepo.findBySelectedProject(s_date, e_date);
		
		
	}

	public List<Task> getTaskStatusByEmpId(String status, Object attribute) {
		return taskRepo.findByTaskStatusByEmpId(status,attribute);
		
	}
	public List<Project> getAllProjectByEmpId(Object attribute) {
		
		return projectRepo.findProjectBypmId(attribute);
	}
	public List<LeaveAppln> getEmpLeaveApplnByEmpId(Object attribute) {
		return leaveApplnRepo.findEmpLeaveApplnByEmpId(attribute);
		
	}
	public List<LeaveAppln> getEmpLeaveApplnByTo(Object attribute) {
		return leaveApplnRepo.findEmpLeaveApplnByTo(attribute);
	}
	public List<Task> getAllTaskBypmId(Object attribute) {
		return taskRepo.findTaskByPmId(attribute);
	}
	public List<Task> getTaskStatusBypmId(String status, Object attribute) {
		return taskRepo.findByTaskStatusBypmId(status, attribute);
	}

}