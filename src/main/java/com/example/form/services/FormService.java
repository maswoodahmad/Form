package com.example.form.services;

import com.example.form.exceptions.FormAlreadyExistException;
import com.example.form.exceptions.FormNotFoundException;

import com.example.form.entities.FormEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // same as @Component | @Repository
public interface FormService {

	FormEntity getAForm(int id) throws FormNotFoundException;
	
	
	
	

	
	
	
	
    List<FormEntity> getAllForms() throws FormNotFoundException;
	
	void createForm( FormEntity form) throws FormAlreadyExistException;
	
	void updateForm( FormEntity form , String name)  throws FormNotFoundException;
	
	FormEntity findbyName(String name)  throws FormNotFoundException;
	
	void deleteForm(String name)  throws FormNotFoundException;
	

}