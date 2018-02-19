package com.example.demo.Repositories;


import com.example.demo.Models.ContactInformation;
import org.springframework.data.repository.CrudRepository;

public interface ContactInformationRepository extends CrudRepository<ContactInformation, Long> {
}
