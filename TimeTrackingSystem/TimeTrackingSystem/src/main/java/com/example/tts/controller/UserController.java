package com.example.tts.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.tts.dto.EmployeeRegistration;
import com.example.tts.entity.Client;
import com.example.tts.entity.EmpReport;
import com.example.tts.entity.EmpStatus;
import com.example.tts.entity.Employee;
import com.example.tts.entity.LeaveAppln;
import com.example.tts.entity.Login;
import com.example.tts.entity.Project;
import com.example.tts.entity.Task;
import com.example.tts.service.ServiceClass;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.jsp.jstl.sql.Result;




@Controller
public class UserController {
@Autowired
ServiceClass service;

@RequestMapping("/login")
public String index()
{
	
	return "Login";
	
}


@RequestMapping("/")
public String login()
{
	
	return "Login";
	
}
//@RequestMapping("saveLogin")
//public String loginPage(@RequestParam String username,@RequestParam String password,ModelMap modelMap)
//{
// if(username.equals("admin@gmail")&& password.equals("admin01"))
// {
//	 return "AdminView";
// }
// else if(username.equals("pm@gmail")&& password.equals("pm01"))
// {
//	 return "PMview";
// }
// else if (username.equals("emp@gmail")&& password.equals("emp01"))
// {
//	 return "EmployeeView";
// }
//	 modelMap.addAttribute("msg", "Please provide the correct username and password");
//     return "Login";
//}

@RequestMapping("/saveLogin")
public String saveLogin(@RequestParam("username")String username,@RequestParam("password") String password,ModelMap modelMap,HttpServletRequest request)

{
	if(username.equals("admin@gmail.com")&& password.equals("admin"))
	 {
			 return "AdminView";
		}
			
			Login login = service.getByUsernameAndPassword(username,password);
			
			if(login!=null)
			{
			
			String userType = login.getUserType();
		int empId = login.getEmployee().getEmpId();
			//int userId = login.getUserId();
			request.getSession().setAttribute("empId", empId);
			System.out.println(request.getSession().getAttribute("empId"));
//			if(userType.equals("admin"))
//			{
//				return "AdminView";
//			}
			 if(userType.equals("ProjectManager"))
			{
				return "PMview";
			}else if(userType.equals("Sr Developer")|| userType.equals("H R")||userType.equals("Jr Developer")||userType.equals("Lead"))
			{
				return "EmployeeView";
			}
			
			}
   		 modelMap.addAttribute("msg", "Please provide the correct username and password");

			return "Login";
			

	
}


	@RequestMapping("/adminView")
	public String CreateEmployee()
	{
		
		return "AdminView";
		
	}

	@RequestMapping("/pmView")
	public String pmView()
	{
		
		return "PMview";
		
	}
	@RequestMapping("/empView")
	public String empView()
	{
		
		return "EmployeeView";
		
	}
	
	@RequestMapping("/employeePage")
	public String createEmployee()
	{
		
		return "employeePage";
		
	}
	@RequestMapping("/savedEmployee")
	public String saveEmployee(@ModelAttribute("employeeRegistration") EmployeeRegistration reg,
			@RequestParam("dob")@DateTimeFormat(pattern="yyyy-MM-dd")Date dob,
			BindingResult result,ModelMap modelMap)
	
	{
		
		Login existingUser  = service.getByUsername(reg.getUsername());
		
		if(existingUser !=null && existingUser.getUsername()!=null && !existingUser.getUsername().isEmpty()) {
			
			result.rejectValue("username", null, "There is already an account registered with the same email");
			
		}
		if (result.hasErrors())
		{
			modelMap.addAttribute("user", reg);
			return "employeePage";
		}
		
		service.registration(reg);
	
		return "redirect:/employeePage?success";
		
	}
	
	@RequestMapping("/displayEmployee")
	public String displayEmployee(ModelMap modelMap)
	
	{
		List<Employee> allEmployee = service.getAllEmployee();
	modelMap.addAttribute("employee", allEmployee);
		
		return "displayEmployee";
		
	}	
		@RequestMapping("/employee-delete")
	public String employeeDelete(@RequestParam Integer id,ModelMap modelMap)
	{
		
		
	Employee employee = service.getEmployeeById(id);
	
	service.deleteEmployee(employee);
	
		List<Employee> allEmployee = service.getAllEmployee();
	modelMap.addAttribute("employee", allEmployee);
		
		return "displayEmployee";
	}
		@RequestMapping("/edit-employee")
		public String editEmployee(@RequestParam("id")Integer id,ModelMap modelMap)
		{

     		Employee employee = service.getEmployeeById(id);
            modelMap.addAttribute("employee", employee);

			return "editEmp";
		}
		@RequestMapping("/updateEmployee")
		public String updateEmployee(@ModelAttribute("employee") Employee employee,@RequestParam("empDob")@DateTimeFormat(pattern="yyyy-MM-dd")Date dob,ModelMap modelMap)
		{
			service.updateEmployee(employee);
			List<Employee> allEmployee = service.getAllEmployee();
			modelMap.addAttribute("employee", allEmployee);
			return "displayEmployee";
			
		}
		@RequestMapping("/leaveAppln")
		public String createLeaveAppln(ModelMap modelMap,HttpSession session)
		{	Object attribute = session.getAttribute("empId");
			LocalDate now=LocalDate.now();
			modelMap.addAttribute("now", now);
			List<Employee> byPMdesgn = service.getByPMdesgn();
			
			modelMap.addAttribute("employee", byPMdesgn);
			modelMap.addAttribute("empId", attribute);
			return "LeaveApplication";
			
			
		}
		@RequestMapping("/saveAppln")
		public String saveLeaveAppln(@ModelAttribute("leaveAppln") LeaveAppln leaveAppln,
		@RequestParam("from_date")@DateTimeFormat(pattern="yyyy-MM-dd")Date from_date,
		@RequestParam("to_date")@DateTimeFormat(pattern="yyyy-MM-dd")Date to_date)
		{
			
		
			service.saveLeaveAppln(leaveAppln);
			
			return "LeaveApplication";
			
		}
		@RequestMapping("/employeeLeaveAppln")
		public String empLeaveAppln(ModelMap modelMap,HttpSession session)
		
		{
			List<Employee> employee = service.getAllEmployee();
			Object attribute = session.getAttribute("empId");
			//List<LeaveAppln> leaveAppln = service.getEmpLeaveAppln();
			List<LeaveAppln> leaveAppln = service.getEmpLeaveApplnByTo(attribute);
			modelMap.addAttribute("leaveAppln", leaveAppln);
			modelMap.addAttribute("employee", employee);
			return "displayEmpLeave";
			
		}	
		@RequestMapping("/leaveApplnEmpVIew")
		public String empLeaveApplnn(ModelMap modelMap,HttpSession session)
		
		{
			Object attribute = session.getAttribute("empId");
			//List<LeaveAppln> leaveAppln = service.getEmpLeaveAppln();
			List<LeaveAppln> leaveAppln = service.getEmpLeaveApplnByEmpId(attribute);
			modelMap.addAttribute("leaveAppln", leaveAppln);
//			modelMap.addAttribute("empId", attribute);
			return "leaveApplnEmpVIew";
			
		}	
		@RequestMapping("/leaveApplnApprove")
		public String empLeaveApprove(@RequestParam Integer id,ModelMap modelMap,HttpSession session)
		{
			
			LeaveAppln appln = service.getLeaveApplnById(id);
			service.approvLeave(appln);
		
			Object attribute = session.getAttribute("empId");
			List<LeaveAppln> leaveAppln = service.getEmpLeaveApplnByTo(attribute);
			modelMap.addAttribute("leaveAppln", leaveAppln);
			return "displayEmpLeave";
			
		}
		
		@RequestMapping("/leaveApplnReject")
		public String empLeaveReject(@RequestParam Integer id,ModelMap modelMap,HttpSession session)
		{
			
			LeaveAppln appln = service.getLeaveApplnById(id);
			service.rejectLeave(appln);
		
			Object attribute = session.getAttribute("empId");
			List<LeaveAppln> leaveAppln = service.getEmpLeaveApplnByTo(attribute);
			modelMap.addAttribute("leaveAppln", leaveAppln);
			return "displayEmpLeave";
			
		}
	
	@RequestMapping("/clientPage")
	public String createclient()
	{
		return "clientPage";
		
	}
	
	@RequestMapping("/savedClient")
	public String saveClient(@ModelAttribute("client") Client client)
	
	{
		service.saveClient(client);
		
		return "clientPage";
		
	}
	@RequestMapping("/displayClient")
	public String displayClient(ModelMap modelMap)
	
	{
		List<Client> allClient = service.getAllClient();
	    modelMap.addAttribute("client", allClient);
		
		return "displayClient";
		
	}
	@RequestMapping("/client-delete")
	public String clientDelete(@RequestParam Integer id,ModelMap modelMap)
	{
		
	Client client = service.getClientById(id);
	service.deleteClient(client);
	
	List<Client> allClient = service.getAllClient();
    modelMap.addAttribute("client", allClient);
	
	return "displayClient";
	
	}
	
	
	@RequestMapping("/edit-client")
	public String editClient(@RequestParam("id")Integer id,ModelMap modelMap)
	{

 	    Client client = service.getClientById(id);
        modelMap.addAttribute("client", client);

		return "editClient";
	}
	
	@RequestMapping("/updateClient")
	public String updateClient(@ModelAttribute("client") Client client,ModelMap modelMap)
	{
		service.updateClient(client);

		List<Client> allClient = service.getAllClient();
	    modelMap.addAttribute("client", allClient);
		return "displayClient";
		
	}
	
	@RequestMapping("/projectPage")
	public String createproject(ModelMap modelMap)
	{
		List<Client> client = service.getAllClient();
		modelMap.addAttribute("client", client);
		LocalDate now=LocalDate.now();
		modelMap.addAttribute("now", now);
		return "projectPage";
		
	}
	
	@RequestMapping("/savedProject")
	public String saveProject(@ModelAttribute("project") Project project)
	
	{
		service.saveProject(project);
		
       
		return "projectPage";
		
	}
	@RequestMapping("/displayProject")
	public String displayProject(ModelMap modelMap)
	
	{
		List<Client> client = service.getAllClient();
		 List<Project> allProject = service.getAllProject();
			modelMap.addAttribute("project", allProject);
		modelMap.addAttribute("client", client);
		return "displayProject";
		
	}
	
	@RequestMapping("/project-delete")
	public String projectDelete(@RequestParam Integer id,ModelMap modelMap)
	{
		
	Project project = service.getProjectById(id);
	service.deleteProject(project);
	
	 List<Project> allProject = service.getAllProject();
		modelMap.addAttribute("project", allProject);
	
	return "displayProject";
	
	}
	@RequestMapping("/edit-project")
	public String editProject(@RequestParam("id")Integer id,ModelMap modelMap)
	{

 	 Project project = service.getProjectById(id);
        modelMap.addAttribute("project", project);

		return "editProject";
	}

	@RequestMapping("/updateProject")
	public String updateProject(@ModelAttribute("project") Project project,	
			ModelMap modelMap)
	{
		service.updateProject(project);
		List<Project> allProject = service.getAllProject();
		modelMap.addAttribute("project", allProject);
	
	return "displayProject";
	
	}

	
	@RequestMapping("/assignEmp")
	public String assignEmp(@RequestParam("id") Integer id,@RequestParam("desgn") String desgn, ModelMap modelMap)
	{ 
		 Project project = service.getProjectById(id);
		 modelMap.addAttribute("project", project);
		 
		 List<Employee> employee = service.getEmpProMangr(desgn);
		 modelMap.addAttribute("employee", employee);
		return "assignEmp";
		
	}
	@RequestMapping("/assignedPM")
	public String assignedProMangr(@RequestParam("projectId") Integer prjId,
			@RequestParam("pmId") Integer empId ,
			ModelMap modelMap)
	{
		
       service.addPmId(prjId,empId);
       List<Project> allProject = service.getAllProject();
		modelMap.addAttribute("project", allProject);
		return "displayProject";
		
	}

	@RequestMapping("/addStatus")
	public String addStatus(@RequestParam("id") Integer id,ModelMap modelMap)
	{
		
		 Project project = service.getProjectById(id);
		 modelMap.addAttribute("project", project);
		return "addStatus";
		
	}
	@RequestMapping("/saveAddStatus")
	public String saveAddStatus(@RequestParam("projectId") Integer id,
			@RequestParam("status") String  status ,
			ModelMap modelMap)
	{
		
       service.addStatus(id, status);
       List<Project> allProject = service.getAllProject();
		modelMap.addAttribute("project", allProject);
		return "displayProjectAtPMView";
		
	}
	
	@RequestMapping("/addtask")
	public String createTaskk(@RequestParam("id") Integer id,ModelMap modelMap,HttpSession session)
	{
		Object attribute = session.getAttribute("empId");
		System.out.println(attribute);
		modelMap.addAttribute("empId", attribute);
		List<Employee> desgnNotPM = service.getEmpDesgnNotPM();
		modelMap.addAttribute("employee", desgnNotPM);
           Project project = service.getProjectById(id);
	modelMap.addAttribute("project", project);
		List<Task> allTask = service.getAllTask();
	modelMap.addAttribute("task", allTask);
		return "taskPage";
		
	}
	
	
	@RequestMapping("/savedTask")
	public String saveTask(@ModelAttribute("task") Task task,ModelMap modelMap)
			
	
	{
			service.pendingTask(task);	
		//service.saveTask(task);
		List<Task> allTask = service.getAllTask();
		modelMap.addAttribute("task", allTask);
		
		return "displayTask";
		
	}
	
	@RequestMapping("/displayTask")
	public String displayTask(ModelMap modelMap,HttpSession session)
	
	{
		Object attribute = session.getAttribute("empId");
		//List<Task> allTask = service.getAllTask();
		List<Task> allTask = service.getAllTaskBypmId(attribute);
		modelMap.addAttribute("task", allTask);
		
		return "displayTask";
		
	}

	
	@RequestMapping("/completedTask")
	public String completedTask(@RequestParam Integer id,ModelMap modelMap)
	{
		Task task = service.getTaskById(id);
		service.completedTask(task);
		
		List<Task> allTask = service.getAllTask();
		modelMap.addAttribute("task", allTask);
		
		return "displayTask";
		
	}
	
	@RequestMapping("/OnProTask")
	public String onProTask(@RequestParam Integer id,ModelMap modelMap,HttpSession session)
	{
		Object attribute = session.getAttribute("empId");
		Task task = service.getTaskById(id);
		service.onProTask(task);
		
		//List<Task> allTask = service.getAllTask();
		List<Task> allTask = service.getAllTaskBypmId(attribute);

		modelMap.addAttribute("task", allTask);
		
		return "displayTask";
		
	}
	
	@RequestMapping("/task-delete")
	public String taskDelete(@RequestParam("id") Integer id,ModelMap modelMap)
	{
		
	Task task = service.getTaskById(id);
	service.deleteTask(task);
	
	List<Task> allTask = service.getAllTask();
	modelMap.addAttribute("task", allTask);
		
		return "displayTask";
	}

	@RequestMapping("/edit-task")
	public String editTask(@RequestParam("id")Integer id,ModelMap modelMap)
	{

 		Task task = service.getTaskById(id);
        modelMap.addAttribute("task", task);

		return "editTask";
	}
	@RequestMapping("/updateTask")
	public String updateTask(@ModelAttribute("task") Task task,ModelMap modelMap)
	{
		service.updateTask(task);
		List<Task> allTask = service.getAllTask();
		modelMap.addAttribute("task", allTask);
			
			return "displayTask";
	}
	@RequestMapping("/AssignedTask")
	public String assignedTask(ModelMap modelMap,HttpSession session)
	{
		Object attribute = session.getAttribute("empId");
		List<Task> allTask = service.getAllTaskByEmpId(attribute);
		
//		List<Task> allTask = service.getAllTask();
//		List<Task> allTask=(List<Task>) session.getAttribute("userId");
		modelMap.addAttribute("task", allTask);
		modelMap.addAttribute("empId", attribute);
		return "assinedTaskEmpVIew";
		
	}
	@RequestMapping("/totalTask")
	public String totalTask(ModelMap modelMap,HttpSession session)
	{
		
		
		Object attribute = session.getAttribute("empId");
		List<Task> allTask = service.getAllTaskByEmpId(attribute);
		modelMap.addAttribute("task", allTask);
		modelMap.addAttribute("empId", attribute);
		return "totalTask";
		
	}
	
	
	
	

	
	@RequestMapping("/AssignedProject")
	public String assignedProject(ModelMap modelMap,HttpSession session)
	{
		Object attribute = session.getAttribute("empId");
		//List<Project> allProject = service.getAllProject();
		List<Project> allProject = service.getAllProjectByEmpId(attribute);
		modelMap.addAttribute("project", allProject);
		modelMap.addAttribute("empId", attribute);

		return "displayProjectAtPMView";
	}
  

	
	@RequestMapping("/TaskPending")
	public String getAllTask(@RequestParam String status,ModelMap modelMap,HttpSession session)

	{
		Object attribute = session.getAttribute("empId");

	 System.out.println(status);
		//List<Task> byStatus = service.getTaskByStatus(status);
	List<Task> byStatus = service.getTaskStatusBypmId(status,attribute);
		 System.out.println(byStatus);
		modelMap.addAttribute("status", byStatus);
	 return "displayPendingTs";
	}

	@RequestMapping("/TaskOnPro")
	public String getAllTaskk(@RequestParam String status,ModelMap modelMap,HttpSession session)

	{
		Object attribute = session.getAttribute("empId");

	 System.out.println(status);
		//List<Task> byStatus = service.getTaskByStatus(status);
	 List<Task> byStatus = service.getTaskStatusBypmId(status,attribute);

		 System.out.println(byStatus);
		modelMap.addAttribute("status", byStatus);
	 return "displayPendingTs2";
	}
	@RequestMapping("/TaskCompleted")
	public String getAllTaskkk(@RequestParam String status,ModelMap modelMap,HttpSession session)

	{
		Object attribute = session.getAttribute("empId");

	 System.out.println(status);
		//List<Task> byStatus = service.getTaskByStatus(status);
		 List<Task> byStatus = service.getTaskStatusBypmId(status,attribute);

		 System.out.println(byStatus);
		modelMap.addAttribute("status", byStatus);
	 return "displayPendingTs3";
	}
		


	@RequestMapping("/TaskOnProo")
	public String getAllTaskks(@RequestParam String status,ModelMap modelMap,HttpSession session)

	{
	 System.out.println(status);
	
		Object attribute = session.getAttribute("empId");
		//List<Task> byStatus = service.getTaskByStatus(status);
		List<Task> byStatus =service.getTaskStatusByEmpId(status,attribute);
		modelMap.addAttribute("status", byStatus);
		modelMap.addAttribute("empId", attribute);

	 return "displayTaskStusAtEmpView";
	}
	@RequestMapping("/TaskCompletedd")
	public String getAllTaskkks(@RequestParam String status,ModelMap modelMap,HttpSession session)

	{
	 System.out.println(status);
		Object attribute = session.getAttribute("empId");
		//List<Task> byStatus = service.getTaskByStatus(status);
		List<Task> byStatus =service.getTaskStatusByEmpId(status,attribute);


		 System.out.println(byStatus);
		modelMap.addAttribute("status", byStatus);
		modelMap.addAttribute("empId", attribute);

	 return "displayTaskStusAtEmpView";
	}
	
	
	
	@RequestMapping("/dailyStatus")
	public String dailyStatus(@RequestParam("id")Integer id,ModelMap modelMap)
	{
		Task task = service.getTaskById(id);
		modelMap.addAttribute("task", task);
		return "dailyStatus";
		
	}
	
	@RequestMapping("/saveDailyStatus")
	public String dailyStatuss(@ModelAttribute("empStatus")EmpStatus empStatus,
			@RequestParam("date")@DateTimeFormat(pattern="yyyy-MM-dd")Date date,
			ModelMap modelMap,HttpSession session)
	{
		Object attribute = session.getAttribute("empId");
		service.saveDailyStatus(empStatus);
//		List<Task> allTask = service.getAllTask();
		List<Task> allTask = service.getAllTaskByEmpId(attribute);
		modelMap.addAttribute("task", allTask);
		return "assinedTaskEmpVIew";
		
	}
	
	@RequestMapping("/viewDailyTask")
	public String viewDailyStatus(@RequestParam("id") Integer id,ModelMap modelMap)
	{
		List<EmpStatus> empStatus = service.getEmpStatusByTaskId(id);
		modelMap.addAttribute("empStatus", empStatus);
		return "displayDailyStatus";
		
	}  
	@RequestMapping("/ProjectReport")
	public String projectReport(ModelMap modelmap)
		{
	
		List<Project> project = service.getAllProject();
		modelmap.addAttribute("project", project);

		return "ProjectReport";
		
	}


	@RequestMapping("/selectProject")
	public String selectProject(@RequestParam("s_date") String s_date,@RequestParam("e_date") String e_date
			,ModelMap modelMap)
	{
		 List<Project> project = service.getSelectedProject(s_date,e_date);
		 List<Client> client = service.getAllClient();
		 modelMap.addAttribute("project", project);
		 modelMap.addAttribute("client", client);
		 return "displayProjectReport";		
	}

	@RequestMapping("/viewProjects")
	public String viewProjects(@RequestParam("projectId") Integer id,ModelMap modelMap)
	{
		 Project project = service.getProjectById(id);
		 List<Client> client = service.getAllClient();
		 List<Employee> employee = service.getAllEmployee();
		 List<Task> task = service.getAllTask();
		 modelMap.addAttribute("project", project);
		 modelMap.addAttribute("client", client);
		 modelMap.addAttribute("task", task);
		 modelMap.addAttribute("employee", employee);
		 return "displayProjectEmpReport";		
	}
	
	@RequestMapping("/Approve")
	public String approve(@RequestParam Integer id,ModelMap modelMap)
	{
		EmpStatus empStatus = service.getEmpStatusById(id);
	    service.approve(empStatus);
	    EmpStatus empStatuss = service.getEmpStatusById(id);
		modelMap.addAttribute("empStatus", empStatuss);
		return "displayDailyStatus";
		
	}
	

	@RequestMapping("/Reject")
	public String reject(@RequestParam Integer id,ModelMap modelMap)
	{
		EmpStatus empStatus = service.getEmpStatusById(id);
	    service.reject(empStatus);
	    EmpStatus empStatuss = service.getEmpStatusById(id);
		modelMap.addAttribute("empStatus", empStatuss);
		return "displayDailyStatus";
		
	}
	
}
