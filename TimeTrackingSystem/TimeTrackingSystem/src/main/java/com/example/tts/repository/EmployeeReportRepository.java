package com.example.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tts.entity.EmpReport;

public interface EmployeeReportRepository extends JpaRepository<EmpReport, Integer> {

}
