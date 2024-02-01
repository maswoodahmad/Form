package com.example.form.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Id;
import javax.persistence.Entity;





@Entity

@Table(name = "options")
public class Options {

   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JsonBackReference
    private InputEntity inputEntity;

    private  String name;
    private String value;





    public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
	}





	public InputEntity getInputEntity() {
		return inputEntity;
	}





	public void setInputEntity(InputEntity inputEntity) {
		this.inputEntity = inputEntity;
	}





	public String getName() {
		return name;
	}





	public void setName(String name) {
		this.name = name;
	}





	public String getValue() {
		return value;
	}





	public void setValue(String value) {
		this.value = value;
	}





	
}








