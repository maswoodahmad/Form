package com.example.form.controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.form.entities.FormEntity;
import com.example.form.exceptions.FormAlreadyExistException;
import com.example.form.exceptions.FormNotFoundException;
import com.example.form.services.FormService;
import org.springframework.http.MediaType;

@RestController

@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class FormController {
	
	
	FormController(){
		System.out.println("controller");
	}
    @Autowired
    
    FormService formService;
    
    
    @GetMapping("/forms")
	public ResponseEntity<List<FormEntity>> getForms() {
		try {
			List<FormEntity> list = formService.getAllForms();
			return ResponseEntity.of(Optional.of(list));
		} catch (FormNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
 
	// Getting Form by name
	@GetMapping("/{formName}")
	public ResponseEntity<FormEntity> getSingleForm(@PathVariable("formName") String formName) {
		try {
			FormEntity form = formService.findbyName(formName);
			return ResponseEntity.of(Optional.of(form));
		} catch (FormNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<FormEntity> getSingleFormById(@PathVariable("id") int id) {
		try {
			FormEntity form = formService.getAForm(id);
			return ResponseEntity.of(Optional.of(form));
		} catch (FormNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
	}
 
	// Inserting the form
	@PostMapping(value="/form",  consumes = {"application/json"})
	public ResponseEntity<String> storeForm(@RequestBody FormEntity form) {
		try {
			formService.createForm(form);
			return ResponseEntity.status(HttpStatus.CREATED).body("Form inserted successfully..");
		} catch (FormAlreadyExistException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
 
	// Updating Form
//	@PutMapping("{formName}")
//	public ResponseEntity<String> updateForm(@RequestBody FormEntity form, @PathVariable("formName") String formName) {
//		try {
//			formService.updateForm(form, formName);
//			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Form updated successfully..");
//		} catch (FormNotFoundException e) {
//			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
//		}
//	}
 
	
	
	// deleting Form details..
	@DeleteMapping("{formName}")
	public ResponseEntity<String> deleteForm(@PathVariable("formName") String formName) {
		try {
			formService.deleteForm(formName);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body("Form deleted Successfully..");
		} catch (FormNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
 

	
	
	@PutMapping("{formName}")
	public ResponseEntity<Map<String, String>> updateForm(@RequestBody FormEntity form, @PathVariable("formName") String formName) {
	    try {
	        formService.updateForm(form, formName);
	        Map<String, String> successResponse = new HashMap<>();
	        successResponse.put("message", "Form updated successfully");
	        return ResponseEntity.status(HttpStatus.ACCEPTED).contentType(MediaType.APPLICATION_JSON).body(successResponse);
	    } catch (FormNotFoundException e) {
	        Map<String, String> errorResponse = new HashMap<>();
	        errorResponse.put("error", e.getMessage());
	        return ResponseEntity.status(HttpStatus.CONFLICT).contentType(MediaType.APPLICATION_JSON).body(errorResponse);
	    }
	}


    
//   @GetMapping("/forms")
//    public List<FormEntity> getForms() {
//        return formService.getAllForms();
//    }
//   

//   @GetMapping("/forms")
//    public String getMsg() {
//        return "tjhis is controller";
//    }
   
   @GetMapping("/hello")
   public String hello() {
       return "Hello, World!";
   }

   
}
