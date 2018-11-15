package com.geekshubsacademy.demohibernatespringmvc.domain.dao.impl;

import com.geekshubsacademy.demohibernatespringmvc.domain.dao.IUsuarioDao;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Usuarios;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class IUsuarioDaoImpl implements IUsuarioDao {
    private static final Log logger = LogFactory.getLog("IUsuarioDaoImpl.class");
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Usuarios getUsuarioActivo(String username) {
        logger.info("El usuario ->"+ username);
        Usuarios usuarioInfo = new Usuarios();
        short  activo = 1;
        String hql = "SELECT u FROM Usuarios u WHERE username=? and enabled=?";
        logger.info("Consulta ->"+ hql);
        List<?> list = entityManager.createQuery(hql)
                .setParameter(0, username).setParameter(1, activo).getResultList();

        if(!list.isEmpty()){
            usuarioInfo = (Usuarios)list.get(0);
        }

        return usuarioInfo;
    }
}
