package com.geekshubsacademy.demohibernatespringmvc.app.components;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Medicos;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import com.geekshubsacademy.demohibernatespringmvc.domain.services.IMedicoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@Qualifier("MedicosComponent")
public class MedicosComponent {
    private static final Log logger = LogFactory.getLog("MedicosComponent.class");

    @Autowired
    private IMedicoService medicoService;

    public List<Medicos> getAllMedicos()
    {
        return medicoService.getAllMedicos();
    }

    public Medicos crearMedico(Medicos medico){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        medico.setCreatedAt(date);
        return medico;
    }

    public void addMedico ( Medicos medico){
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dateFormat.format(date);
        medico.setCreatedAt(date);
        medicoService.addMedico(medico);
    }
    public Medicos getMedicoById(Long id){

        Medicos medico = medicoService.getMedicoById(id);
        if(medico ==null) {
            return null;
        }
       return medico;

    }
    public boolean deleteMedico(Long id)
    {
        if (id > 0) {
            medicoService.deleteMedico(id);
            return true;
        }
        return false;
    }
}
