package ua.krat.hospital_v3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ua.krat.hospital_v3.model.User;
import ua.krat.hospital_v3.service.UserService;

import javax.validation.Valid;

@Controller
public class AuthenticationController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView showStartPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start-page");
        return modelAndView;
    }

    @RequestMapping(value = {"/login"}, method = RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @RequestMapping(value = {"/logout"}, method = RequestMethod.GET)
    public ModelAndView logout() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("start-page");
        return modelAndView;
    }

    @RequestMapping(value = {"register"}, method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        User user = new User();
        modelAndView.addObject("user", user);
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("home");
        return modelAndView;
    }


    @RequestMapping(value = {"/doctor"}, method = RequestMethod.GET)
    public ModelAndView doctor() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("doctor");
        return modelAndView;
    }

    @RequestMapping(value = {"/register"}, method = RequestMethod.POST)
    public ModelAndView registerUser(@Valid User user, BindingResult bindingResult, ModelMap modelMap){
        ModelAndView modelAndView = new ModelAndView();
        //Check for the validations
        if(bindingResult.hasErrors()){
            modelAndView.addObject("successMessage", "Please correct the errors in form!");
            modelMap.addAttribute("bindingResult", bindingResult);
        }

        else if(userService.inUserAlreadyPresent(user)){
            modelAndView.addObject("successMessage", "User with this email already exists !");
        }
        // we will save the user if no binding errors
        else {
            userService.saveUser(user);
            modelAndView.addObject("successMessage", "User is registered successfully!");
        }
        modelAndView.addObject("user", new User());
        modelAndView.setViewName("register");
        return modelAndView;
    }
}
