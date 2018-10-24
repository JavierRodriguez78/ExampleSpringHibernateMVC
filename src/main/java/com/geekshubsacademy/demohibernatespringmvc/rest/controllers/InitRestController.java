package com.geekshubsacademy.demohibernatespringmvc.rest.controllers;

import com.geekshubsacademy.demohibernatespringmvc.domain.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;

public class InitRestController {

    @Autowired
    IPacienteService pacienteService;


}
