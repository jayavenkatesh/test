package com.jaya.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class service {

	@Autowired
	repository repo;

	public List<questions> getallquestions() {
		return repo.findAll();
	}

	public List<questions> getbycatagory(String catagory) {
		return repo.findByCatagory(catagory);
	}

	public questions addQuestion(questions qn) {
		return repo.save(qn);
		//return "Success";
	}

	
	
}
