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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quiz")
public class quizcontroller {
	
	@Autowired
	quizservice qserv;
	
	@PostMapping("/create")
	public ResponseEntity<String> createquiz(@RequestParam String catagory,@RequestParam int num,@RequestParam String title){
		
		return qserv.createQuiz(catagory,num,title);
		
		//return new ResponseEntity<>("iam here",HttpStatus.OK);
	}
	
	@GetMapping("getquiz/{id}")
	public ResponseEntity<List<qnwrapper>> getQuizQuestions(@PathVariable Integer id){
		return qserv.getQuizQuestions(id);
	}

	@PostMapping("submit/{id}")
	public ResponseEntity<Integer> userResponce(@PathVariable Integer id,@RequestBody List<responce> responces){
		return qserv.userResponce(id,responces);
	}
}
