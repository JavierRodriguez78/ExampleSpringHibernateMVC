package com.geekshubsacademy.demohibernatespringmvc.domain.services.impl;

import com.geekshubsacademy.demohibernatespringmvc.domain.dao.IPacienteDao;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import com.geekshubsacademy.demohibernatespringmvc.domain.services.IPacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class IPacienteServiceImpl implements IPacienteService {

    @Autowired
    private IPacienteDao pacienteDao;

    @Override
    @Transactional(readOnly = true)
    public List<Pacientes> findAll() {
        return (List<Pacientes>)pacienteDao.findAll() ;
    }

    @Override
    @Transactional
    public void save(Pacientes paciente) {
        pacienteDao.save(paciente);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Pacientes> findOne(Long id) {
        return pacienteDao.findById(id);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        pacienteDao.deleteById(id);
    }


}
