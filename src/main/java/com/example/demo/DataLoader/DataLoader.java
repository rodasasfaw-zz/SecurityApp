package com.example.demo.DataLoader;


import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;
    @Autowired
    EducationRepository educationRepository;
    @Autowired
    ContactInformationRepository contactInformationRepository;
    @Autowired
    ExperienceRepository experienceRepository;
    @Autowired
    SkillsRepository skillsRepository;
    @Autowired
    ReferencesRepository referencesRepository;



    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Loading data...");

        roleRepository.save(new Role("APPLICANT"));
        roleRepository.save(new Role("EMPLOYER"));
        roleRepository.save(new Role("ADMIN"));

        roleRepository.findByRole("ADMIN");
        roleRepository.findByRole("APPLICANT");
        roleRepository.findByRole("EMPLOYER");

        User user = new User();
        user.setUsername("applicant");
        user.setPassword("password");
        user.setFirstName("John Jacob Jingleheimer");
        user.setLastName("Schmidt");
        user.setEmail("jjjschmidt@gmail.com");
        userRepository.save(user);

        user = new User();
        user.setUsername("employer");
        user.setPassword("password");
        user.setFirstName("Admin");
        user.setLastName("User");
        user.setEmail("chmidt@gmail.com");
        userRepository.save(user);

        Skills aSkill = new Skills();
        aSkill.setRating("proficient");
        aSkill.setSkill("skill");
        skillsRepository.save(aSkill);

        Education e = new Education();
        e.setDepartment("A course");
        e.setSchool("Institution");
        e.setYear("2018");
        e.setLevel("BSc");
        educationRepository.save(e);


        Experience workexp = new Experience();
        workexp.setCompany("company");
        workexp.setJobTitle("technician");
        workexp.setBeginyear("2014");
        workexp.setEndyear("2016");
        experienceRepository.save(workexp);





    }
}