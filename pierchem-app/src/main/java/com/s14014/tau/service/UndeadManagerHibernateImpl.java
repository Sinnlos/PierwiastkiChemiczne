package com.s14014.tau.service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.s14014.tau.domain.User;
import com.s14014.tau.domain.Undead;

@Component
@Transactional
public class UndeadManagerHibernateImpl implements UndeadManager{

    @Autowired
    private SessionFactory sessionFactory;


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }




    @Override
    public Long addUser(User user) {

        user.setId(null);
        sessionFactory.getCurrentSession().persist(user);
        sessionFactory.getCurrentSession().flush();

        return user.getId();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return sessionFactory.getCurrentSession().getNamedQuery("user.all").list();
    }

    @Override
    public void deleteUser(User user) {

        user = (User) sessionFactory.getCurrentSession().get(User.class,user.getId());


        for(Undead undead : user.getUndeadList()){
            undead.setMale(false);
            sessionFactory.getCurrentSession().update(undead);
        }

        sessionFactory.getCurrentSession().delete(user);

    }

    @Override
    public User findUserByPesel(String pesel) {
        return (User) sessionFactory.getCurrentSession().getNamedQuery("user.byPesel").setString("pesel", pesel).uniqueResult();
    }

    @Override
    public Long addNewUndead(Undead undead) {
        undead.setId(null);

        return (Long) sessionFactory.getCurrentSession().save(undead);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Undead> getMaleUndeads() {
        return sessionFactory.getCurrentSession().getNamedQuery("undead.male").list();
    }

    @Override
    public void disposeUndead(User user, Undead undead) {

        user = (User) sessionFactory.getCurrentSession().get(User.class, user.getId());
        undead = (Undead) sessionFactory.getCurrentSession().get(Undead.class, undead.getId());

        Undead toRemove = null;

        for(Undead aUndead : user.getUndeadList()){
            if(aUndead.getId().compareTo(undead.getId()) == 0){
                toRemove = aUndead;
                break;
            }
        }

        if(toRemove != null){
            user.getUndeadList().remove(toRemove);
        }

        undead.setMale(false);

    }

    @Override
    public Undead findUndeadById(Long id) {
        return (Undead) sessionFactory.getCurrentSession().get(Undead.class, id);
    }

    @Override
    public List<Undead> getCreatedUndeads(User user) {

        user = (User) sessionFactory.getCurrentSession().get(User.class, user.getId());

        List<Undead> undeadList = new ArrayList<Undead>(user.getUndeadList());

        return undeadList;
    }

    @Override
    public void assignedUndead(Long userId, Long undeadId) {

        User user = (User) sessionFactory.getCurrentSession().get(User.class, userId);

        Undead undead = (Undead) sessionFactory.getCurrentSession().get(Undead.class, undeadId);

        undead.setMale(true);

        if(user.getUndeadList() == null){
            user.setUndeadList(new LinkedList<Undead>());
        }

        user.getUndeadList().add(undead);
    }

    @Override
    public void updateUser(User user) {

        sessionFactory.getCurrentSession().update(user);

    }
}
