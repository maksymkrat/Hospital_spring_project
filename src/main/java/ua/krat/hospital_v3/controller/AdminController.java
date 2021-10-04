package ua.krat.hospital_v3.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.krat.hospital_v3.service.UserService;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    UserService userService;



    @GetMapping()
    public String admin(Model model) {
        model.addAttribute("users", userService.findAllUsers());
        return "admin";
    }

//    @GetMapping("/{id}")
//    public String showPatientInfo(@PathVariable("id") int id, Model model){
//
//        model.addAttribute("users", )
//        return "";
//    }

}
