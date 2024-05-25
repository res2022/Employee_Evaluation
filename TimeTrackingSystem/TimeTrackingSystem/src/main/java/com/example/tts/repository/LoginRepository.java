package com.example.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.tts.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	
	@Query(" from Login where  username=:username and " + "password=:password")
			
	//@Query("from Flight where departureCity=:departureCity and "
		//	+ "arrivalCity=:arrivalCity and dateOfDeparture=:dateOfDeparture ")
	public Login findByUsernameAndPassword(@Param("username")String  username,@Param("password") String password);
	
	
	public Login findByUsername(String username);
	
	
	
}
