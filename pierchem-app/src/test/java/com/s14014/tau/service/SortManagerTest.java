package com.s14014.tau.service;

import static org.junit.Assert.assertEquals;

import java.util.List;

import net.bytebuddy.TypeCache;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.omg.CORBA.PERSIST_STORE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;
import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.domain.Inventor;

import javax.persistence.criteria.CriteriaBuilder;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/beans.xml"})
@Rollback
@Transactional(transactionManager = "txManager")
public class SortManagerTest {

    @Autowired
    SortManager sortManager;

    private final String IMIE_1 = "";
    private final String NAZWISKO_1 = "";
    private final String PESEL_1 = "";

    private final String IMIE_2 = "";
    private final String NAZWISKO_2 = "";
    private final String PESEL_2 = "";


    private final String NAZWA_1 = "wodor";
    private final int NROKRESU_1 = 1;
    private final int NRGRUPY_1 = 1;

    private final String NAZWA_2 = "lit";
    private final int NROKRESU_2 = 2;
    private final int NRGRUPY_2 = 1;


    @Test
    public void addInventorCheck(){

        List<Inventor> sciencePeople = sortManager.getAllInventors();

        for (Inventor scientist : sciencePeople){
            System.out.println("Wynalazca: " + scientist.getImie() + " " + scientist.getNazwisko() + " " + scientist.getPesel());

            if (scientist.getPesel().equals(PESEL_1)){
                sortManager.deleteInventor(scientist);
            }

            Inventor inventor = new Inventor();
            inventor.setImie(IMIE_1);
            inventor.setNazwisko(NAZWISKO_1);
            inventor.setPesel(PESEL_1);

            sortManager.addInventor(inventor);

            Inventor sciencePerson = sortManager.findInventorByPesel(PESEL_1);

            assertEquals(IMIE_1, sciencePerson.getImie());
            assertEquals(NAZWISKO_1, sciencePerson.getNazwisko());
            assertEquals(PESEL_1, sciencePerson.getPesel());
        }
    }

    @Test
    public void addPierwiastekCheck(){

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa(NAZWA_1);
        pierwiastek.setNrOkresu(NROKRESU_1);
        pierwiastek.setNrGrupy(NRGRUPY_1);

        Long pierwiastekId = sortManager.addNewPierwiastek(pierwiastek);

        Pierwiastek scienceSubstance = sortManager.findPierwiastekById(pierwiastekId);
        assertEquals(NAZWA_1, scienceSubstance.getNazwa());
        assertEquals(NROKRESU_1, scienceSubstance.getNrGrupy());
        assertEquals(NRGRUPY_1, scienceSubstance.getNrGrupy());



    }

    @Test
    public void inventedPierwiastekCheck(){

        Inventor inventor = new Inventor();
        inventor.setImie(IMIE_2);
        inventor.setNazwisko(NAZWISKO_2);
        inventor.setPesel(PESEL_2);

        sortManager.addInventor(inventor);

        Inventor retrievedScientist = sortManager.findInventorByPesel(PESEL_2);

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa(NAZWA_2);
        pierwiastek.setNrOkresu(NROKRESU_2);
        pierwiastek.setNrGrupy(NRGRUPY_2);

        Long pierwiastekId = sortManager.addNewPierwiastek(pierwiastek);

        sortManager.assignePierwiastek(retrievedScientist.getId(), pierwiastekId);

        List<Pierwiastek> inventedPierwiastki = sortManager.getInventedPierwiastki(retrievedScientist);

        assertEquals(1, inventedPierwiastki.size());
        assertEquals(NAZWA_2, inventedPierwiastki.get(0).getNazwa());
        assertEquals(NRGRUPY_2, inventedPierwiastki.get(0).getNrGrupy());
        assertEquals(NROKRESU_2, inventedPierwiastki.get(0).getNrOkresu());

    }

    @Test
    public void disposePierwiastkiCheck(){

        //TO DO


    }

}

























