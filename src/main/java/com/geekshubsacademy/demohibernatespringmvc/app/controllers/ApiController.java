package com.geekshubsacademy.demohibernatespringmvc.app.controllers;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.geekshubsacademy.demohibernatespringmvc.app.components.PacientesComponent;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import net.minidev.json.JSONObject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class ApiController {
    private static final Log logger = LogFactory.getLog("ApiController.class");
    @Autowired
    private PacientesComponent pacientesComponent;

    @RequestMapping(value="pacientes",method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<List<Pacientes>> getPatients(){
        List<Pacientes> list = pacientesComponent.allPacientes();
        return new ResponseEntity<List<Pacientes>>(list, HttpStatus.OK);
    }

    @RequestMapping(value="pacientes/{id}", method= RequestMethod.GET, produces="application/json")
    public ResponseEntity<Pacientes> getPatient(@PathVariable Long id){
        logger.info("El id recibido es ->"+ id);
        Pacientes paciente;
        paciente =pacientesComponent.getPatientById(id);
        return new ResponseEntity<>(paciente, HttpStatus.OK);
    }

    @RequestMapping(value="pacientes", method=RequestMethod.POST)
    public ResponseEntity<Void> addPatient(@RequestBody Pacientes paciente, UriComponentsBuilder builder)
    {

        paciente = pacientesComponent.crearPaciente(paciente);
        pacientesComponent.addPaciente(paciente);
         return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @RequestMapping(value="pacientes/{id}", method=RequestMethod.PUT)
    public ResponseEntity<Void> editPatient(@PathVariable Long id, @RequestBody Pacientes paciente, UriComponentsBuilder builder)
    {

        Pacientes pacienteResult = pacientesComponent.getPatientById(id);

        if(pacienteResult==null) {
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        pacienteResult.setApellido(paciente.getApellido());
        pacienteResult.setNombre(paciente.getNombre());
        pacientesComponent.addPaciente(pacienteResult);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @RequestMapping(value="pacientes/{id}", method= RequestMethod.DELETE)
    public ResponseEntity<Void> deletePatient(@PathVariable Long id){
        boolean flag = pacientesComponent.deletePatient(id);
        if(flag==false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
