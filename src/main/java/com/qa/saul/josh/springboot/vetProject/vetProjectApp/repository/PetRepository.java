package com.qa.saul.josh.springboot.vetProject.vetProjectApp.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.saul.josh.springboot.vetProject.vetProjectApp.model.PetModel;



@Repository
public interface PetRepository extends JpaRepository<PetModel, Long>{
	Page<PetModel> findByOwnerId(Long owner_id, Pageable pageable);
	Optional<PetModel> findByPetIdAndOwnerId(Long pet_id, Long owner_id);


}
