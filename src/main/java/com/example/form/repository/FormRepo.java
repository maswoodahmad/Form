package com.example.form.repository;

import com.example.form.entities.FormEntity;
import org.springframework.data.repository.CrudRepository;

public interface FormRepo extends CrudRepository<FormEntity, Integer> {

   public  FormEntity findById(int id);
   
   public  FormEntity findByformName(String name);
}
