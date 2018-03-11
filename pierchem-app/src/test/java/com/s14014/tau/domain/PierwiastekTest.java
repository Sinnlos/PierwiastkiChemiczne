package com.s14014.tau.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import com.s14014.tau.repository.PierwiastekRepository;
import java.util.List;
import org.junit.Test;

public class PierwiastekTest {

    PierwiastekRepository pierwiastekRepository;
    Pierwiastek pierwiastek = new Pierwiastek(1, "wodór", 1, 1, 1);


    @Test
    public void dodawanieTest(){
        

        pierwiastekRepository.add(pierwiastek);
        assertNotNull(pierwiastekRepository.getById(pierwiastek.getId()));


    }

    @Test
    public void updateTest(){
        Pierwiastek pierwiastekToUpdate = pierwiastekRepository.getById(1);

        pierwiastekToUpdate.setNazwa("Wodór");
        pierwiastekRepository.updateById(pierwiastekToUpdate.getId());

        assertEquals(pierwiastekRepository.getById(1), pierwiastekToUpdate);
        assertThat(pierwiastekToUpdate.getNazwa(), is("Wodór"));
    }

    @Test
    public void znajdzPoId(){
        Pierwiastek pierwiastek = pierwiastekRepository.getById(1);

        assertNotNull(pierwiastek);
        assertEquals("wodór", pierwiastek.getNazwa());
    }

    @Test
    public void getAllTest(){
        List<Pierwiastek> tabMendelejewa = pierwiastekRepository.getAll();

        assertNotNull(tabMendelejewa);
        assertThat(tabMendelejewa, hasItem(pierwiastekRepository.getById(1)));

        try{
            Pierwiastek pierwiastekToCatch = tabMendelejewa.get(0);
        }

        catch(IndexOutOfBoundsException aIndexOutOfBoundsException){
            assertThat(aIndexOutOfBoundsException.getMessage(), is("Index: 0, Size: 0"));
        }
    }

    @Test
    public void usunPoId(){
        pierwiastekRepository.deleteById(1);
        assertNull(pierwiastekRepository.getById(1));
    }

    @Test
    public void inicjujRepozytorium(){
        Pierwiastek wodor = new Pierwiastek(1, "wodów", 1, 1, 1);
        Pierwiastek hel = new Pierwiastek(2, "hel", 1, 18, 2);
        Pierwiastek lit = new Pierwiastek(3, "lit", 2, 1, 1);

        pierwiastekRepository.add(wodor);
        pierwiastekRepository.add(hel);
        pierwiastekRepository.add(lit);
    }


}