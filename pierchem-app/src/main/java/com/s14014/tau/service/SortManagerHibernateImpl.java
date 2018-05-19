package com.s14014.tau.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.domain.Inventor;

import javax.persistence.criteria.CriteriaBuilder;


@Component
@Transactional
public class SortManagerHibernateImpl implements SortManager {

    /**
     *
     */
    @Autowired
    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }


    @Override
    public void addInventor(Inventor inventor) {
        inventor.setId(null);
        sessionFactory.getCurrentSession().persist(inventor);
        sessionFactory.getCurrentSession().flush();
    }



    @Override
    @SuppressWarnings("unchecked")
    public List<Inventor> getAllInventors() {
        return sessionFactory.getCurrentSession().getNamedQuery("inventor.all").list();
    }

    @Override
    public void deleteInventor(Inventor inventor) {
        inventor = (Inventor) sessionFactory.getCurrentSession().get(Inventor.class,inventor.getId());

        for(Pierwiastek pierwiastek : inventor.getPierwiastki()){
            pierwiastek.setMetal(false);
            sessionFactory.getCurrentSession().update(pierwiastek);
        }

        sessionFactory.getCurrentSession().delete(inventor);
    }

    @Override
    public Inventor findInventorByPesel(String pesel) {
        return (Inventor) sessionFactory.getCurrentSession().getNamedQuery("inventor.byPesel").setString("pesel", pesel).uniqueResult();
    }

    @Override
    public int addNewPierwiastek(Pierwiastek pierwiastek) {
        pierwiastek.setId(null);
        return (int) sessionFactory.getCurrentSession().save(pierwiastek);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Pierwiastek> getMetalePerwiastki() {

        return sessionFactory.getCurrentSession().getNamedQuery("pierwiastek.niemetal").list();
    }

    @Override
    public void disposePierwiastek(Inventor inventor, Pierwiastek pierwiastek) {
        inventor = (Inventor) sessionFactory.getCurrentSession().get(Inventor.class, inventor.getId());

        pierwiastek = (Pierwiastek) sessionFactory.getCurrentSession().get(Pierwiastek.class, pierwiastek.getId());

        Pierwiastek toRemove = null;

        for (Pierwiastek aPierwiastek : inventor.getPierwiastki()) {
            if (aPierwiastek.getId().compareTo(pierwiastek.getId()) == 0) {
                toRemove = aPierwiastek;
                break;
            }
        }

        if (toRemove != null){
            inventor.getPierwiastki().remove(toRemove);
        }

        pierwiastek.setMetal(false);

    }

    @Override
    public Pierwiastek findPierwiastekById(int id) {
        return (Pierwiastek) sessionFactory.getCurrentSession().get(Pierwiastek.class, id);
    }

    @Override
    public List<Pierwiastek> getInventedPierwiastki(Inventor inventor) {
        inventor = (Inventor) sessionFactory.getCurrentSession().get(Inventor.class,
                inventor.getId());

        List<Pierwiastek> pierwiastki = new ArrayList<Pierwiastek>(inventor.getPierwiastki());
        return pierwiastki;
    }

    @Override
    public void assignePierwiastek(Long inventorId, Long pierwiastekId) {

        Inventor inventor  = (Inventor) sessionFactory.getCurrentSession().get(Inventor.class, inventorId);

        Pierwiastek pierwiastek = (Pierwiastek) sessionFactory.getCurrentSession().get(Pierwiastek.class, pierwiastekId);

        pierwiastek.setMetal(true);

        if(inventor.getPierwiastki() == null){
            inventor.setPierwiastki(new LinkedList<Pierwiastek>());
        }

        inventor.getPierwiastki().add(pierwiastek);
    }

    @Override
    public void updateInventor(Inventor inventor) {
        sessionFactory.getCurrentSession().update(inventor);
    }
}
