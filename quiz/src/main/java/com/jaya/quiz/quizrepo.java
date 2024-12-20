package com.jaya.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface quizrepo extends JpaRepository<quiz, Integer> {



	
}
