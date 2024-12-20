package com.jaya.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/questions")
public class Homecontroller {

	@Autowired
	service service;
	
	@GetMapping("/")
	public String qns() {
		return "we are here";
	}
	
	@GetMapping("/getallquestions")
	public List<questions> getallqns(){
		return service.getallquestions();
	}
	
	@GetMapping("/catagory/{catagory}")
	public List<questions> getbycatagory(@PathVariable String catagory){
		return service.getbycatagory(catagory);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addQuestion(@RequestBody questions question) {
		//return service.addQuestion(question);
		try {
			questions product1=service.addQuestion(question);
			
			return new ResponseEntity<>(product1,HttpStatus.CREATED);
		}
		catch(Exception e){
			return new ResponseEntity<>(e.getMessage(),HttpStatus.OK);
		}
	}
}
