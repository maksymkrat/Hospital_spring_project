package com.krat.hospital_v2.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {


    @GetMapping("/")
    public String getInfoForAll(){
        return "view-for-all";
    }

    @GetMapping("/doctor_info")
    public String getInfoForDoctor(){
        return "doctor-info";
    }

    @GetMapping("/patient_info")
    public String getInfoForPatient(){
        return "patient-info";
    }
}
