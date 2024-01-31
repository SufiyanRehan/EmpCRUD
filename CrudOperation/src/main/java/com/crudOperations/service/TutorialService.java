package com.crudOperations.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.crudOperations.model.Tutorial;

@Service
public class TutorialService {

	
	static  List<Tutorial> tutorial = new ArrayList<Tutorial>();
	
	
	public List<Tutorial> findAll(){
		return tutorial;
	}
	
	
	public List<Tutorial> findByTitleContians(String title){
		return tutorial.stream().filter(tutorials -> tutorials.getTitle().contains(title)).toList();
	}
	
	public Tutorial findById(long id){
		return tutorial.stream().filter(tutorials -> id == tutorials.getId()).findAny().orElse(null);
	}
	
}
