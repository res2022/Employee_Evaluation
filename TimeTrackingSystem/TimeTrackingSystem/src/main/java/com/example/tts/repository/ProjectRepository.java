package com.example.tts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tts.entity.Login;
import com.example.tts.entity.Project;
import com.example.tts.entity.Task;

public interface ProjectRepository extends JpaRepository<Project, Integer> {
//	@Query(value="select p.project_id,p.project_name,p.project_des,p.status,p.clientid from project p  where p.s_date='s_date' and p.edate='e_date' ",
//			nativeQuery=true)
//	public List<Project> findBySelectedProject(@Param("s_date")String  s_date,@Param("e_date") String e_date);
	@Query(" from Project where  s_date=:s_date and " + "e_date=:e_date")
	public List<Project> findBySelectedProject( @Param("s_date") String s_date,@Param("e_date") String e_date);
	
	public List<Project> findProjectBypmId(Object attribute);
	
}
