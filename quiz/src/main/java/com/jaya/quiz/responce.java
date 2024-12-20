package com.jaya.quiz;

import java.util.List;

import jakarta.persistence.Id;
import lombok.Data;

@Data
public class responce {

	@Id
	private int id;
	private String responce;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getResponce() {
		return responce;
	}
	public void setResponce(String responce) {
		this.responce = responce;
	}
	@Override
	public String toString() {
		return "responce [id=" + id + ", responce=" + responce + "]";
	}
	
	
}
