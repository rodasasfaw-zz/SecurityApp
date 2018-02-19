package com.example.demo.Controller;


import com.example.demo.Models.*;
import com.example.demo.Repositories.*;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    UserService userService;



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

    @RequestMapping("/")
    public String showindex() {
        return "index";
    }

    @RequestMapping("/login")
    public String showLogin(Model model) {
        return "login";
    }


    @GetMapping("/addeducation")
    public String educationForm(Model model) {
        model.addAttribute("education", new Education());
        return "educationform";
    }

    @PostMapping("/processeduction")
    public String processeducationForm(@Valid @ModelAttribute("education") Education educations, BindingResult result) {
        if (result.hasErrors()) {
            return "educationform";
        }
        educationRepository.save(educations);
        return "redirect:/";

    }

    @GetMapping("/addcontactinfo")
    public String contactinfoForm(Model model) {
        model.addAttribute("contactinfo", new ContactInformation());
        return "contactinformationform";
    }

    @PostMapping("/processcontactinfo")
    public String processcontactinfoForm(@Valid @ModelAttribute("contactinfo") ContactInformation contactinfos, BindingResult result){
        if (result.hasErrors()){
            return "contactinformationform";
        }
        contactInformationRepository.save(contactinfos);
        return "redirect:/";

    }
    @GetMapping("/addexperience")
    public String experienceForm(Model model) {
        model.addAttribute("experience", new Experience());
        return "experienceform";
    }

    @PostMapping("/processexperience")
    public String processExperience(@Valid @ModelAttribute("experience") Experience experiences, Model model,BindingResult result){
        if (result.hasErrors()){
            return "experienceform";
        }
        experienceRepository.save(experiences);
        model.addAttribute("experience", experienceRepository.findAll());
        return "redirect:/";

    }
    @GetMapping("/addskills")
    public String skillsForm(Model model) {
        model.addAttribute("skills", new Skills());
        return "skillsform";
    }

    @PostMapping("/processskills")
    public String processskills(@Valid @ModelAttribute("skills") Skills skillss, BindingResult result){
        if (result.hasErrors()){
            return "skillsform";
        }
        skillsRepository.save(skillss);
        return "redirect:/";

    }
    @GetMapping("/addreference")
    public String referenceForm(Model model) {
        model.addAttribute("reference", new References());
        return "referenceform";
    }

    @PostMapping("/processsreference")
    public String processsReferences(@Valid @ModelAttribute("reference") References references, BindingResult result){
        if (result.hasErrors()){
            return "referenceform";
        }
        referencesRepository.save(references);
        return "redirect:/";

    }
    @RequestMapping("/completeresume")
    public String showComplete(Model model){
        model.addAttribute("contactinfos", contactInformationRepository.findAll());
        model.addAttribute("educations", educationRepository.findAll());
        model.addAttribute("experiences",experienceRepository.findAll());
        model.addAttribute("skillss",skillsRepository.findAll());
        model.addAttribute("references",referencesRepository.findAll());

        return "completeresume";
    }


    @GetMapping("/register")
    public String showRegistrationPage(Model model){
        model.addAttribute("user",new User());
        return "registration";
    }

    @PostMapping("/register")
    public String processregistration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model ){

        model.addAttribute("user",user);
        if(result.hasErrors()){
            return "registration";
        }else{
            userService.saveApplicant(user);

            model.addAttribute("message","User Account Successfully Created");
        }
        return "index";
    }

    @RequestMapping("/secure")
    public String secure(HttpServletRequest request, Authentication authentication, Principal principal) {
        Boolean isAdmin = request.isUserInRole("ADMIN");
        Boolean isUSer = request.isUserInRole("APPLICANT");
        Boolean isuser = request.isUserInRole("EMPLOYER");
        UserDetails userDetails = (UserDetails)
                authentication.getPrincipal();
        String username = principal.getName();
        return "secure";
    }
}
