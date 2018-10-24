package com.geekshubsacademy.demohibernatespringmvc.domain.services;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;

import java.util.List;
import java.util.Optional;


public interface IPacienteService {
    public List<Pacientes> findAll();
    public void save (Pacientes paciente);
    public Optional<Pacientes> findOne(Long id);
    public void delete(Long id);
  }
