package com.example.travellist.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.travellist.entity.Travel;
import com.example.travellist.repository.TravelRepo;

@Controller
public class TravelController {
	
	@Autowired
	TravelRepo repo;
	
	@RequestMapping("/addTravel")
	@ResponseBody
	private Optional<Travel> saveBook(@RequestParam String id,String name,String desc, Travel travel)   
	{ 
		travel.setId(id);
		travel.setName(name);
		travel.setDescription(desc);
		repo.save(travel);  
		
		return repo.findById(id);
	} 
	
	@RequestMapping("/travel")
	@ResponseBody
	public List<Travel> displayTravel()
	{
		return repo.findAll();		
	}
	
	@RequestMapping("/travel/{id}")
	@ResponseBody
	public Optional<Travel> displayTravelId(@PathVariable String id)
	{
		return repo.findById(id);		
	}
	
	@RequestMapping("/deleteTravel/{id}")
	@ResponseBody
	public String deleteTravelId(@PathVariable String id)
	{
		repo.deleteById(id);	
		return "Travel Deleted Successfully ! "+id;
	}
	
	@RequestMapping("/updateTravel/{id}/{desc}")
	@ResponseBody
	public String updateTravel(@PathVariable String id,String desc)
	{
		repo.updateTravelDesc(id,desc);
		return "Travel Updated Successfully ! "+id;
	}
	
	
	

}
