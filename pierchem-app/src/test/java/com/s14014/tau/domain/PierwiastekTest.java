
/*package com.s14014.tau.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.List;

import com.s14014.tau.domain.repository.PierwiastekDBUnitTest;
import org.junit.*;
import com.s14014.tau.repository.*;

import java.sql.DriverManager;

import org.dbunit.JdbcDatabaseTester;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import com.s14014.tau.repository.PierwiastekManagerImpl;



public class PierwiastekTest {




/*

    IPierwiastekRepository pierwiastekRepository;



    @Ignore
    @Test
    public void addTest(){

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setId(2);
        pierwiastek.setNazwa("Lit");
        pierwiastek.setNrGrupy(1);
        pierwiastek.setNrOkresu(2);
        pierwiastek.setLiczbaElektronow(1);

        pierwiastekRepository.add(pierwiastek);
        assertNotNull(pierwiastekRepository.getPierwiastekById(pierwiastek.getId()));


    }

    @Ignore
    @Test
    public void updateTest(){
        Pierwiastek pierwiastekToUpdate = pierwiastekRepository.getPierwiastekById(3);

        pierwiastekToUpdate.setNazwa("siarka");
        pierwiastekRepository.updateById(pierwiastekToUpdate);


        assertThat(pierwiastekRepository.getPierwiastekById(3).getNazwa(), is(pierwiastekToUpdate.getNazwa()));
        assertNotNull(pierwiastekRepository.getPierwiastekById(1));

        assertFalse("nie powinno mody..",pierwiastekRepository.getPierwiastekById(2).getNazwa().equals(pierwiastekToUpdate.getNazwa()));


    }

    @Ignore
    @Test
    public void findTest(){
       Pierwiastek pierwiastek = pierwiastekRepository.getPierwiastekById(2);

        assertNotNull(pierwiastek);
      //  assertEquals("lit", pierwiastekRepository.getPierwiastekById(2).getNazwa());
          assertThat("lit", is(pierwiastekRepository.getPierwiastekById(2).getNazwa()));

    }

    @Ignore
    @Test
    public void getAllTest(){
        List<Pierwiastek> tabMendelejewa = pierwiastekRepository.getAllPierwiastki();

        assertNotNull(tabMendelejewa);
       Pierwiastek pierwiastek = tabMendelejewa.get(3);
       assertNotNull(pierwiastek);

        try{
            Pierwiastek pierwiastekToCatch = tabMendelejewa.get(0);
        }

        catch(IndexOutOfBoundsException aIndexOutOfBoundsException){
            assertThat(aIndexOutOfBoundsException.getMessage(), is("Index: 3, Size: 3"));
        }
    }

    @Ignore
    @Test
    public void deleteTest(){


        pierwiastekRepository.deleteById(1);

        List<Pierwiastek> pierwiastki = pierwiastekRepository.getAllPierwiastki();

        assertNull(pierwiastekRepository.getPierwiastekById(1).getNazwa());
        assertEquals(true, !pierwiastki.isEmpty());
    }

    @Ignore
    @Before
    public void initRepository(){
       pierwiastekRepository = PierwiastekRepositoryFactory.getInstance();
        Pierwiastek wodor = new Pierwiastek(0, "wodor", 1, 1, 1);

        Pierwiastek hel = new Pierwiastek(1, "hel", 1, 18, 2);
        Pierwiastek lit = new Pierwiastek(2, "lit", 2, 1, 1);
        Pierwiastek magnez = new Pierwiastek(3, "magnez", 2, 2, 2);
        Pierwiastek siarka = new Pierwiastek(4, "siarka", 2, 13, 3);

        pierwiastekRepository.add(wodor);
        pierwiastekRepository.add(hel);
        pierwiastekRepository.add(lit);
        pierwiastekRepository.add(magnez);
        pierwiastekRepository.add(siarka);
    }

    @Ignore
    @After
    public void dropRepository(){
        pierwiastekRepository.dropTable();
    }

}
*/