package com.s14014.tau.service;

import com.s14014.tau.domain.User;
import com.s14014.tau.domain.Undead;

import java.util.List;

public interface UndeadManager {

    Long addUser(User user);
    List<User> getAllUsers();
    void deleteUser(User user);
    User findUserByPesel(String pesel);

    Long addNewUndead(Undead undead);
    List<Undead> getMaleUndeads();
    void disposeUndead(User user, Undead undead);
    Undead findUndeadById(Long id);

    List<Undead> getCreatedUndeads(User user);
    void assignedUndead(Long userId, Long undeadId);
    void updateUser(User user);
}
