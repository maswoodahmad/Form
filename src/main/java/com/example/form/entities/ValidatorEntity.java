package com.example.form.entities;




import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity

@Table(name = "validators")
public class ValidatorEntity {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @ManyToOne
    @JsonBackReference
    private InputEntity inputEntity;

    private boolean required;

    private String pattern;


    private int min;
    private int max;


    public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isRequired() {
		return required;
	}


	public void setRequired(boolean required) {
		this.required = required;
	}


	public String getPattern() {
		return pattern;
	}


	public void setPattern(String pattern) {
		this.pattern = pattern;
	}


	public int getMin() {
		return min;
	}


	public void setMin(int min) {
		this.min = min;
	}


	public int getMax() {
		return max;
	}


	public void setMax(int max) {
		this.max = max;
	}


	public InputEntity getInputEntity() {
		return inputEntity;
	}


	public void setInputEntity(InputEntity inputEntity) {
		this.inputEntity = inputEntity;
	}


	

}
