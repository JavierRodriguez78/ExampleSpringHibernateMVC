package com.geekshubsacademy.demohibernatespringmvc.app.controllers;

import com.geekshubsacademy.demohibernatespringmvc.app.components.PacientesComponent;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Optional;

@Controller
@SessionAttributes("paciente")
public class WebController {
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
    public String addPaciente(Map<String, Object> model){
               model.put("paciente",pacientesComponent.crearPaciente());
               model.put("titulo","Añadir paciente");
              return "addpatient";
    }

    @PostMapping("/addpatient")
    public String savePatient(@Valid @ModelAttribute("paciente") Pacientes paciente, BindingResult bindingResult, Model model, RedirectAttributes flash, SessionStatus status){
        if(bindingResult.hasErrors()){
            logger.info("El formulario tiene errores");
            model.addAttribute("titulo","Añadir Paciente");
            return "addpatient";
        }
        pacientesComponent.addPaciente(paciente);
        return "redirect:/pacientes";
    }

    @GetMapping(value="/addpatient/{id}")
    public String editar(@PathVariable Long id, Map<String, Object> model, RedirectAttributes flash) {
        Pacientes paciente = null;

        if (id > 0) {
            paciente = pacientesComponent.getPatientById(id);
            logger.info("Paciente devuelto->"+paciente);
            if(paciente == null){
                flash.addFlashAttribute("error", "El ID del Paciente no existen en la BD");
                return "redirect:/pacientes";
            }
        } else{
            flash.addFlashAttribute("error", "El ID del Paciente no puede ser igual o menor a 0");
            return "redirect:/pacientes";
        }
        model.put("paciente", paciente);
        model.put("titulo", "Editar paciente");


        return "addpatient";
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

    @GetMapping("/delete/{id}")
    public String eliminar(@PathVariable(value="id") Long id, RedirectAttributes flash){

        flash = pacientesComponent.deletePatient(id, flash);
        return "redirect:/pacientes";
    }
}
