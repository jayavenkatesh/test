package com.jaya.quiz;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class quizservice {

	@Autowired
	quizrepo quizrepo;
	
	@Autowired
	repository qnrepo;

	public ResponseEntity<String> createQuiz(String catagory, int num, String title) {
		
		List<questions> questions=qnrepo.findrandamquestionsByCatagory(catagory,num);
		
		quiz quiz=new quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		quizrepo.save(quiz);
		
		return new ResponseEntity<String>("created", HttpStatus.CREATED);
	}

	public ResponseEntity<List<qnwrapper>> getQuizQuestions(Integer id) {
		Optional<quiz> quiz=quizrepo.findById(id);
		
		List<questions> qnfromdb=quiz.get().getQuestions();
		List<qnwrapper> userqns=new ArrayList<>();
		for(questions q:qnfromdb) {
			qnwrapper qw=new qnwrapper(q.getId(),q.getQuestiontitle(),q.getOption1(),q.getOption2(),q.getOption3(),q.getOption4());
			userqns.add(qw);
		}
		return new ResponseEntity<>(userqns,HttpStatus.OK);
	}

	public ResponseEntity<Integer> userResponce(Integer id, List<responce> responces) {
		quiz quiz=quizrepo.findById(id).get();
		List<questions> qns=quiz.getQuestions();
		
		int ans=0;
		int i=0;
		for(responce res:responces) {
			questions qn=qns.get(i);
			if(res.getResponce().equals(qn.getAnswer())){
				ans++;
			}
			i++;
		}
		return new ResponseEntity<>(ans,HttpStatus.OK);
		
	}
	
	
}
