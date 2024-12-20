package com.jaya.quiz;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;

@Entity
@Data
public class quiz {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String title;
	
	@ManyToMany
	private List<questions> questions;
	@Override
	public String toString() {
		return "quiz [id=" + id + ", title=" + title + ", questions=" + questions + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public List<questions> getQuestions() {
		return questions;
	}
	public void setQuestions(List<questions> questions) {
		this.questions = questions;
	}
}
