package com.example.tts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tts.entity.Task;



public interface TaskRepository extends JpaRepository<Task, Integer> {

//	@Query("select * from Task where status=")
//	List<Task> findByStatus(String s);
//	
	
	//public List<Course> findBytopicId(String topicId);
	public List<Task> findByStatus(String status);

	public List<Task> findTaskByEmpId(Object attribute);

	@Query(" from Task where  status=:status and " + "empId=:attribute")
	public List<Task> findByTaskStatusByEmpId( @Param("status") String status,@Param("attribute") Object attribute);

	public List<Task> findTaskByPmId(Object attribute);
	
	@Query(" from Task where  status=:status and " + "pmId=:attribute")
	public List<Task> findByTaskStatusBypmId( @Param("status") String status,@Param("attribute") Object attribute);

	

}