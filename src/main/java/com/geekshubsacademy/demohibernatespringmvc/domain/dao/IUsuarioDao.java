package com.geekshubsacademy.demohibernatespringmvc.domain.dao;

import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Usuarios;

public interface IUsuarioDao {

    Usuarios getUsuarioActivo(String userName);
}
