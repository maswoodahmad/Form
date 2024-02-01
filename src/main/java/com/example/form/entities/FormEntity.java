package com.example.form.entities;



import org.hibernate.annotations.CreationTimestamp;

import org.hibernate.annotations.UpdateTimestamp;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.time.Instant;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name ="forms")

public class FormEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "formName" , unique=true)
    private String formName;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "form" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<InputEntity> inputList;

    @CreationTimestamp
    private Instant createdOn;

    
    public Instant getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Instant createdOn) {
		this.createdOn = createdOn;
	}

	public Instant getLastUpdatedOn() {
		return lastUpdatedOn;
	}

	public void setLastUpdatedOn(Instant lastUpdatedOn) {
		this.lastUpdatedOn = lastUpdatedOn;
	}

	@UpdateTimestamp
    private Instant lastUpdatedOn;
    
    
    
    public String getFormName() {
        return formName;
    }

    public void setFormName(String formName) {
        this.formName = formName;
    }

    public List<InputEntity> getInputList() {
        return inputList;
    }

    public void setInputList(List<InputEntity> inputList) {
        this.inputList = inputList;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
