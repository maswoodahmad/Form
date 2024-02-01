package com.example.form.services;

import com.example.form.entities.FormEntity;

import com.example.form.exceptions.FormAlreadyExistException;
import com.example.form.exceptions.FormNotFoundException;
import com.example.form.repository.FormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
public class FormServiceImplementation implements  FormService {
	
	@Autowired
	FormRepo formRepo;	
	

		
		@Override
		public List<FormEntity> getAllForms() throws FormNotFoundException {
			
			List<FormEntity> list= (List<FormEntity>) formRepo.findAll();
			if(list==null) {
				throw new FormNotFoundException("No forms in database");
			}
			return list;
		}
		
		
		@Override
		public void createForm(FormEntity form) throws FormAlreadyExistException {
			
			String name= form.getFormName();
			if( formRepo.findByformName(name)==null) {
				
				formRepo.save(form);
			}
			
			else
			{
				throw new FormAlreadyExistException("Form with this Name Already Exists try changing the name");
			}
			
			
			
}
		
		@Override
		public void updateForm(FormEntity form, String name) throws FormNotFoundException
		{
			
			Optional<FormEntity> foundForm = Optional.of(formRepo.findByformName(name));
			
			if(foundForm.isEmpty()) {
				
				throw new FormNotFoundException("Form you are trying to update is not found");
				
			}
			
			form.setLastUpdatedOn(Instant.now()); 
			
			int id = foundForm.get().getId();
			Instant createdOn= foundForm.get().getCreatedOn();
			form.setId(id);
			form.setCreatedOn(createdOn);
			System.out.println(form.getCreatedOn());
			formRepo.save(form);
			
		}
		
		
		
		@Override
		public FormEntity findbyName(String name) throws FormNotFoundException {
			FormEntity form = formRepo.findByformName(name);
			if(form==null) {
				throw new FormNotFoundException("Form  is not found");
			}
			return form;
		}
		
		public void deleteForm(String name)  throws FormNotFoundException  {
			FormEntity form = formRepo.findByformName(name);
			if(form==null) {
				throw new FormNotFoundException("Form  is not found");
			}
			formRepo.delete(form);
		}


		@Override
		public FormEntity getAForm(int id) throws FormNotFoundException {
			
			Optional<FormEntity> foundForm = Optional.of(formRepo.findById(id));
			
			if(foundForm.isEmpty()) {
				
				throw new FormNotFoundException("Form you are trying to update is not found");
				
			}
			return null;
		}


		


		

		


		
		
	 
	

}
