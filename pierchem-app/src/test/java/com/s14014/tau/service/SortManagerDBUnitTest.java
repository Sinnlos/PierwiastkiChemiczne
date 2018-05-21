package com.s14014.tau.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;
import org.springframework.transaction.annotation.Transactional;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;

import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.domain.Inventor;



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
public class SortManagerDBUnitTest {

    @Autowired
    SortManager sortManager;

    @Test
    @DatabaseSetup("/fullData.xml")
    @ExpectedDatabase(value = "/addInventorData.xml",
    assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void addInventorCheck() throws Exception{

        assertEquals(3, sortManager.getAllInventors().size());


        Inventor i = new Inventor();
        i.setImie("Taehyung");
        i.setNazwisko("Kim");
        i.setPesel("95122113440");
        i.setFirstInventDate(new SimpleDateFormat("yyyy-MM-dd").parse("1874-05-14"));

        sortManager.addInventor(i);

        assertEquals(4, sortManager.getAllInventors().size());

    }

    @Test
    @DatabaseSetup("/fullData.xml")
    @ExpectedDatabase(value = "/deleteData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void deleteInventorCheck() throws Exception{

        assertEquals(3, sortManager.getAllInventors().size());

        Inventor inventor = sortManager.findInventorByPesel("85043021547");

        sortManager.deleteInventor(inventor);

        assertEquals(2, sortManager.getAllInventors().size());

    }


    @Test
    @DatabaseSetup("/fullData.xml")
    @ExpectedDatabase(value = "/updateData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void updateInventorCheck() throws Exception{



        Inventor inventor = sortManager.findInventorByPesel("43012144859");

        inventor.setNazwisko("Update");

         sortManager.updateInventor(inventor);

         assertEquals(sortManager.findInventorByPesel("43012144859").getNazwisko(), inventor.getNazwisko());




    }

    @Test
    @DatabaseSetup("/fullData.xml")
    @ExpectedDatabase(value = "/fullData.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void getInventorCheck() throws Exception{

        Inventor inventor = sortManager.findInventorByPesel("12043021547");

        assertNotNull(inventor);

        assertEquals(sortManager.findInventorByPesel("12043021547").getNazwisko(), inventor.getNazwisko());
    }


    @Test
    @DatabaseSetup("/fullData.xml")
    @ExpectedDatabase(value = "/disposePierwiastek.xml",
            assertionMode = DatabaseAssertionMode.NON_STRICT)
    public void disposePerwiastekCheck(){

        Inventor inventor = sortManager.findInventorByPesel("85043021547");

        assertEquals(2, inventor.getPierwiastki().size());

        Pierwiastek pierwiastek = inventor.getPierwiastki().get(0);
        sortManager.disposePierwiastek(inventor, pierwiastek);

        assertEquals(1, inventor.getPierwiastki().size());

    }

}


















