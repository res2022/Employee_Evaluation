package com.example.tts.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tts.entity.LeaveAppln;

public interface LeaveApplnRepository extends JpaRepository<LeaveAppln, Integer> {

	List<LeaveAppln> findEmpLeaveApplnByEmpId(Object attribute);

	List<LeaveAppln> findEmpLeaveApplnByTo(Object attribute);

}
