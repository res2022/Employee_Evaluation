package com.example.tts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tts.entity.Client;

public interface ClientRepository extends JpaRepository<Client, Integer> {

}
