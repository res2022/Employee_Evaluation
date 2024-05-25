package com.example.tts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tts.entity.EmpStatus;

public interface EmpStatusRepository extends JpaRepository<EmpStatus, Integer>{

	public List<EmpStatus> findBytaskId(Integer id);




}
