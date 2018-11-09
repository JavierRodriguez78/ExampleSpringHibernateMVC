package com.geekshubsacademy.demohibernatespringmvc.app.components;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import com.geekshubsacademy.demohibernatespringmvc.domain.services.IPacienteService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.rmi.server.UID;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("PacientesComponent")
public class PacientesComponent {

    private static final Log logger = LogFactory.getLog("PacienteComponent.class");

    @Autowired
    private IPacienteService pacienteService;


    public Pacientes crearPaciente(){
        Pacientes paciente = new Pacientes();
        paciente.setHistoriaClinica(UidGen());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        paciente.setCreatedAt(date);
        return paciente;

    }


    public Pacientes crearPaciente(Pacientes paciente){
        paciente.setHistoriaClinica(UidGen());
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        paciente.setCreatedAt(date);
        return paciente;
    }
    public void addPaciente ( Pacientes paciente){
        pacienteService.save(paciente);
    }

    public List<Pacientes> allPacientes()
    {
        logger.info(pacienteService.findAll());
        return pacienteService.findAll();
    }

    public Pacientes getPatientById(Long id){

        Optional<Pacientes>  OptPaciente = pacienteService.findOne(id);
        if(OptPaciente.get()==null) {
            return null;
        }
        return OptPaciente.get();

    }

    public boolean deletePatient(Long id)
    {
        if (id > 0) {
            pacienteService.delete(id);
            return true;
        }
        return false;
    }

    public RedirectAttributes deletePatient(Long id,         RedirectAttributes flash)
    {
        if (id > 0) {
            pacienteService.delete(id);
            return flash.addFlashAttribute("success","Se ha  adecuadamente");

        }
        return flash.addFlashAttribute("error","No se ha podido eliminar!");
    }

    private String UidGen(){
        UID uid = new UID();
        return "hist"+uid;
    }

}
