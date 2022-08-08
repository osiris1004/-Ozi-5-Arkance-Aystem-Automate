package com.mycompany.user.controller;

import com.mycompany.model.Application;
import com.mycompany.UserNotFoundException;
import com.mycompany.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.io.IOException;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService service;


    /*@GetMapping("/user")
    public  String showUserPage(){
        // direct to the page index
        return "user";
    }*/

    /// Display application form and pass the object to your html
    @GetMapping("/user/applicationForm/new/{id}")
    public  String showApplicationFormPage(Model model,@PathVariable("id") Integer id){
        // direct to the page index
        model.addAttribute("app", new Application());
        model.addAttribute("pageTitle", "Postuler (ID: "+id+")");

        return "applicationForm";
    }

    // save the new applied application
    @PostMapping("/user/processApplication")
    public  String processApplication(Application application/*, @RequestParam(name="cv") MultipartFile multipartFile*/) throws IOException {
        /*String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());*/

        //System.out.println("\n\n"+fileName+"\n\n");
        //application.setCv("ok");
        //service.saveApplication(application);
        service.saveApplication(application);

        //String upLoadDir = "assets/cv/"+saveNewApplication.getId();
       /* String upLoadDir = "assets/cv";

        Path uploadPath = Paths.get(upLoadDir);
        if(!Files.exists(uploadPath)){
            Files.createDirectories(uploadPath);
        }

        try {
            InputStream inputStream = multipartFile.getInputStream();
            Path filePath = uploadPath.resolve(fileName);
            Files.copy(inputStream, filePath,StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            throw new IOException("could not save uploaded file: name");
        }*/

    // direct to the page index
        return "redirect:/user";
    }


    /// Display application list
    @GetMapping("/user/application")
    public  String showApplicationList(Model model){
        // execute our business logic
        List<Application> applicationList = service.listsApplication();
        // we put the <listUser> in to the model attribute, so that we can have access in the view
        model.addAttribute("applicationList", applicationList);
        // name of your html template
        return "application";
    }

    @GetMapping("/user/application/edit/{id}")
    public  String showEditApplicationFormPage(@PathVariable("id") Integer id, Model model, RedirectAttributes ra){
        try {
            Application application = service.get(id);
            model.addAttribute("app",application);
            model.addAttribute("pageTitle", "Mettre à jour (ID: "+id+")");
            return "applicationForm";
        } catch (UserNotFoundException e) {
            //<addFlashAttribute>
            ra.addFlashAttribute("message", e.getMessage());
            // redirecting my user to users template
            return "redirect:/application";
        }

    }



}
