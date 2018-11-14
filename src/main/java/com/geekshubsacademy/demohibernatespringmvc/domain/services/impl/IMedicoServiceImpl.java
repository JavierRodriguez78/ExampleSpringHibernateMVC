package com.geekshubsacademy.demohibernatespringmvc.domain.services.impl;

import com.geekshubsacademy.demohibernatespringmvc.domain.dao.IMedicoDao;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Medicos;
import com.geekshubsacademy.demohibernatespringmvc.domain.services.IMedicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class IMedicoServiceImpl implements IMedicoService {

    @Autowired
    private IMedicoDao medicoDao;

    @Override
    public List<Medicos> getAllMedicos() {
        return medicoDao.getAllMedicos();
    }

    @Override
    public Medicos getMedicoById(Long id) {

        return medicoDao.getMedicoById(id);
    }

    @Override
    public void addMedico(Medicos medico) {
        medicoDao.addMedico(medico);

    }

    @Override
    public void updateMedico(Medicos medico) {
    medicoDao.updateMedico(medico);
    }

    @Override
    public void deleteMedico(Long id) {
        medicoDao.deleteMedico(id);
    }

    @Override
    public boolean medicoExist(String nombre) {
        return false;
    }
}
