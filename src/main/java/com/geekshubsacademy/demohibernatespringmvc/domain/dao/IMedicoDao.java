package com.geekshubsacademy.demohibernatespringmvc.domain.dao;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Medicos;

import java.util.List;

public interface IMedicoDao {
    List<Medicos> getAllMedicos();
    Medicos getMedicoById(Long id);
    void addMedico(Medicos medico);
    void updateMedico(Medicos medico);
    void deleteMedico(Long id);
    boolean medicoExist(String nombre);
}
