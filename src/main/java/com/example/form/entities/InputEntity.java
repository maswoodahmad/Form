package com.example.form.entities;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.List;
@Entity
@Table(name = "configurations")
public class InputEntity {


  

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JsonBackReference
    private FormEntity form;
    
   
    
    private String name;
    private String label;

    public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	private String type;
    
    @Column(name = "Value", nullable = true)
    private String value;
    
    
    
    @JsonManagedReference
 	@OneToMany( mappedBy = "inputEntity", cascade = CascadeType.ALL,orphanRemoval = true)
    @Column(name="options", nullable=true)
 	private List<Options> options;

  
     @JsonManagedReference
     @OneToOne (mappedBy = "inputEntity", cascade = CascadeType.ALL, orphanRemoval = true )
    
     private ValidatorEntity validators;

     
     @JsonManagedReference
     @OneToMany (mappedBy = "inputEntity",orphanRemoval = true, cascade = CascadeType.ALL)
     private List<CheckBoxChoice> checkbox;
     
     
   
     

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    

    

   
    
 




    public List<CheckBoxChoice> getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(List<CheckBoxChoice> checkbox) {
		this.checkbox = checkbox;
	}

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Options> getOptions() {
        return options;
    }

    public void setOptions(List<Options> options) {
        this.options = options;
    }

    public ValidatorEntity getValidators() {
        return validators;
    }

    public void setValidators(ValidatorEntity validators) {
        this.validators = validators;
    }

    public FormEntity getForm() {
        return form;
    }

    public void setForm(FormEntity form) {
        this.form = form;
    }





}
