
package com.s14014.tau.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.s14014.tau.repository.IPierwiastekRepository;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PierwiastekTest {

    IPierwiastekRepository pierwiastekRepository;



    @Test
    public void addTest(){
        
        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa("Lit");
        pierwiastek.setNrGrupy(1);
        pierwiastek.setNrOkresu(2);
        pierwiastek.setLiczbaElektronow(1);

        pierwiastekRepository.add(pierwiastek);
        assertNotNull(pierwiastekRepository.getPierwiastekById(pierwiastek.getId()));


    }

    @Test
    public void updateTest(){
        Pierwiastek pierwiastekToUpdate = pierwiastekRepository.getPierwiastekById(1);

        pierwiastekToUpdate.setNazwa("Wodór");
        pierwiastekRepository.updateById(pierwiastekToUpdate);

        assertEquals(pierwiastekRepository.getPierwiastekById(1).getNazwa(), pierwiastekToUpdate.getNazwa());
        assertThat(pierwiastekToUpdate.getNazwa(), is("Wodór"));

        Pierwiastek pierwiastek = pierwiastekRepository.getPierwiastekById(6);
        assertThat(pierwiastek.getNazwa(), not("Wodór"));
    }

    @Test
    public void findTest(){
        Pierwiastek pierwiastek = pierwiastekRepository.getPierwiastekById(1);

        assertNotNull(pierwiastek);
        assertEquals("wodór", pierwiastek.getNazwa());
    }

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
            assertThat(aIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    @Test
    public void deleteTest(){

        
        pierwiastekRepository.deleteById(1);

        List<Pierwiastek> pierwiastki = pierwiastekRepository.getAllPierwiastki();

        assertNull(pierwiastekRepository.getPierwiastekById(1).getNazwa());
        assertNotEquals(true, pierwiastki.isEmpty());
    }

    
    @Before
    public void initRepository(){
        Pierwiastek wodor = new Pierwiastek(1, "wodów", 1, 1, 1);
        Pierwiastek hel = new Pierwiastek(2, "hel", 1, 18, 2);
        Pierwiastek lit = new Pierwiastek(3, "lit", 2, 1, 1);

        pierwiastekRepository.add(wodor);
        pierwiastekRepository.add(hel);
        pierwiastekRepository.add(lit);
    }


}