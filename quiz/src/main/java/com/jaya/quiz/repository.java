package com.jaya.quiz;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface repository extends JpaRepository<questions, Integer>{

	List<questions> findByCatagory(String catagory);

	@Query(value="SELECT * FROM questions q where q.catagory=:catagory ORDER BY RANDOM() LIMIT :num",nativeQuery=true)
	List<questions> findrandamquestionsByCatagory(String catagory, int num);

	//List<questions> findrandamquestionsByCatagory(String catagory, int num);
}
