package com.geekshubsacademy.demohibernatespringmvc.app.controllers;

import com.geekshubsacademy.demohibernatespringmvc.app.components.PacientesComponent;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class InitController {

    @Autowired
    private PacientesComponent pacientesComponent;

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
