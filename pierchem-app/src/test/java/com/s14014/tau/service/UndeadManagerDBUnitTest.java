package com.s14014.tau.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import com.s14014.tau.domain.User;
import com.s14014.tau.domain.Undead;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/beans.xml"})
@Rollback
@Transactional(transactionManager = "txManager")
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})
public class UndeadManagerDBUnitTest {

    @Autowired
    UndeadManager undeadManager;

    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/aaddUserData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addUserCheck() throws Exception{

        assertEquals(3, undeadManager.getAllUsers().size());


        User u = new User();
        u.setUsername("LimChangkyun");
        u.setPassword("diction");
        u.setPasswordConfirm("diction");
        u.setPesel("95122113440");


        undeadManager.addUser(u);

        assertEquals(4, undeadManager.getAllUsers().size());

    }

    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/adeleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void deleteUserCheck() throws Exception{

        assertEquals(3, undeadManager.getAllUsers().size());

        User user = undeadManager.findUserByPesel("85043021547");

        undeadManager.deleteUser(user);

        assertEquals(2, undeadManager.getAllUsers().size());

    }


    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/aupdateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void updateUserCheck() throws Exception{



        User user = undeadManager.findUserByPesel("43012144859");

        user.setUsername("WonhoUlzzang");

        undeadManager.updateUser(user);

        assertEquals(undeadManager.findUserByPesel("43012144859").getUsername(), user.getUsername());




    }

    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/fullData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void getUserCheck() throws Exception{

        User user = undeadManager.findUserByPesel("12043021547");

        assertNotNull(user);

        assertEquals(undeadManager.findUserByPesel("12043021547").getUsername(), user.getUsername());
    }


    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/adisposeUndead.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void disposeUndeadCheck() throws Exception{

        User user = undeadManager.findUserByPesel("12043021547");

        assertEquals(2, user.getUndeadList().size());

        Undead undead = user.getUndeadList().get(0);
        undeadManager.disposeUndead(user, undead);

        assertEquals(1, user.getUndeadList().size());

    }

    @Test
    @DatabaseSetup(value = {"/fullData.xml"})
    @ExpectedDatabase(value = "/aundeadsList.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void getUsersUndeads() throws Exception{

        User user = undeadManager.findUserByPesel("12043021547");

        assertNotNull(user);

        assertNotNull(user.getUndeadList());

        assertEquals(2, user.getUndeadList().size());
    }

}

