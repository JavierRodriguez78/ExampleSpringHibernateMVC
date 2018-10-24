package com.geekshubsacademy.demohibernatespringmvc.domain.dao;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Pacientes;
import org.springframework.data.repository.CrudRepository;

public interface IPacienteDao extends CrudRepository<Pacientes, Long> {

}
