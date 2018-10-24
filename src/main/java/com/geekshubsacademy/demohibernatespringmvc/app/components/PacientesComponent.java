package com.geekshubsacademy.demohibernatespringmvc.app.components;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import com.geekshubsacademy.demohibernatespringmvc.domain.services.IPacienteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Qualifier("PacientesComponent")
public class PacientesComponent {

    private static final Log logger = LogFactory.getLog("InitController.class");

    @Autowired
    private IPacienteService pacienteService;

    public void addPaciente ( Pacientes paciente){
        pacienteService.save(paciente);
    }

    public List<Pacientes> allPacientes()
    {
        return pacienteService.findAll();
    }


}
