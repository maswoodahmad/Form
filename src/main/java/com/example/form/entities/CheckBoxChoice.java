package com.example.form.entities;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;





@Entity

@Table(name = "checkbox")
public class CheckBoxChoice {
	
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   
	   @JsonBackReference
		@ManyToOne
		private InputEntity inputEntity;
	   
	  @Column(name="name", nullable=true) 
	   private String name;
	  
	  
		@Column(name="isChecked", columnDefinition = "boolean default false", nullable=true)
	private boolean isChecked;
	
	
	    
		
		
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public boolean isChecked() {
		return isChecked;
	}


	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}


	public InputEntity getInputEntity() {
		return inputEntity;
	}


	public void setInputEntity(InputEntity inputEntity) {
		this.inputEntity = inputEntity;
	}


}
