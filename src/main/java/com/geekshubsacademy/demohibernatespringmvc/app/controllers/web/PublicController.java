package com.geekshubsacademy.demohibernatespringmvc.app.controllers.web;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PublicController {
    private static final Log logger = LogFactory.getLog("PublicController.class");

    @GetMapping("/")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("custom-login");
        return mav;
    }

    @GetMapping("/unathorizedpage")
    public String fuera(){
        return "/unathorizedpage";
    }

    @GetMapping("/logout")
    public String logout(){
        return "logout";
    }
}
