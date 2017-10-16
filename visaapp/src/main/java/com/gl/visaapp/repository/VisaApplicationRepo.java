/**
 * 
 */
package com.gl.visaapp.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.gl.visaapp.modal.VisaApplicant;

/**
 * @author Ajay Kumar
 *
 */
@Repository
public interface VisaApplicationRepo extends MongoRepository<VisaApplicant, String> {   
    List<VisaApplicant> findAll();    
}
