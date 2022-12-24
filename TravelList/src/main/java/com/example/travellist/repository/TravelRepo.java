package com.example.travellist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.example.travellist.entity.Travel;

public interface TravelRepo extends JpaRepository<Travel,String>{

	@Modifying
	@Transactional
	@Query(value="update Travel set description = ?2 where id = ?1",nativeQuery=true)
	void updateTravelDesc(String id, String desc);
}
