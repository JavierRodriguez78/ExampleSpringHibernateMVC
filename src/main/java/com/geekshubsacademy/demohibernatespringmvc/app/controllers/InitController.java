package com.geekshubsacademy.demohibernatespringmvc.app.controllers;

import com.geekshubsacademy.demohibernatespringmvc.app.components.PacientesComponent;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InitController {
    private static final Log logger = LogFactory.getLog("InitController.class");
    @Autowired
    private PacientesComponent pacientesComponent;

    @GetMapping("/")
    public ModelAndView home(){
        ModelAndView mv = new ModelAndView("index");
        mv.addObject("titulo","Añadir Paciente");
        return mv;
    }

    @GetMapping("/pacientes")
    public ModelAndView pacientes(){
        ModelAndView mv= new ModelAndView("patients");
        mv.addObject("pacientes", pacientesComponent.allPacientes());
        return mv;
    }

    @GetMapping("/addpatient")
    public ModelAndView addPaciente(){
        Pacientes paciente = new Pacientes();

        ModelAndView mv = new ModelAndView("addpatient");
        mv.addObject("paciente", paciente);
        mv.addObject("titulo","Añadir paciente");
        return mv;
    }

    @PostMapping("/addpatient")
    public ModelAndView savePatient(Pacientes paciente){
        logger.info(paciente);
        ModelAndView mv = new ModelAndView("patients");
        return mv;
    }

    @GetMapping("/add")
    public String añadir(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        Pacientes paciente = new Pacientes("HC32323","Xavi","Rodriguez Soler",date);
        pacientesComponent.addPaciente(paciente);
        return "index";
    }

    @GetMapping("/list")
    public ModelAndView listado(){
        ModelAndView mv = new ModelAndView("list");
        mv.addObject("pacientes", pacientesComponent.allPacientes());
        return mv;
    }
}
