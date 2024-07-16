package Liveasy.demo.dao;

import java.util.List;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;


import Liveasy.demo.entities.Load;

public interface loadRepository extends JpaRepository<Load, UUID> {

	List<Load> findByShipperId(String shipperId);

   }
