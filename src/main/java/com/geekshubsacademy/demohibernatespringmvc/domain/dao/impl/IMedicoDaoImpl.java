package com.geekshubsacademy.demohibernatespringmvc.domain.dao.impl;

import com.geekshubsacademy.demohibernatespringmvc.domain.dao.IMedicoDao;
import com.geekshubsacademy.demohibernatespringmvc.domain.entities.Medicos;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Transactional
@Repository
public class IMedicoDaoImpl implements IMedicoDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Medicos> getAllMedicos() {
        String hql= " FROM  Medicos";
        return (List<Medicos>) entityManager.createQuery(hql).getResultList();
    }

    @Override
    public Medicos getMedicoById(Long id) {
        return entityManager.find(Medicos.class, id);
    }

    @Override
    public void addMedico(Medicos medico) {
        entityManager.persist(medico);

    }

    @Override
    public void updateMedico(Medicos medicoRecibido) {
        Medicos medico= getMedicoById(medicoRecibido.getId());
        medico.setNombre(medicoRecibido.getNombre());
        medico.setApellido(medicoRecibido.getApellido());
        medico.setEspecialidad(medicoRecibido.getEspecialidad());
        entityManager.flush();
    }

    @Override
    public void deleteMedico(Long id) {
        entityManager.remove(getMedicoById(id));
    }

    @Override
    public boolean medicoExist(String nombre) {
        String hql = "FROM Medicos as medicos where medicos.nombre =?";
        int count = entityManager.createQuery(hql).setParameter(1,nombre).getResultList().size();
        return count > 0 ? true : false ;
    }
}
