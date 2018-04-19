
package com.s14014.tau.domain;

import com.s14014.tau.repository.IPierwiastekRepository;
import com.s14014.tau.repository.PierwiastekManagerImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@Ignore
public class PierwiastekRepositoryTest {


    IPierwiastekRepository pierwiastekRepository;

    private final static String NAZWA_1 = "Tlen";

    @Before
    public void setup() throws SQLException{
        pierwiastekRepository = new PierwiastekManagerImpl();
    }

    @After
    public void cleanup() throws SQLException{

    }

    @Test
    public void checkConnection(){
        assertNotNull(pierwiastekRepository.getConnection());
    }

    @Test
    public void checkAdding() throws SQLException{
        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa(NAZWA_1);

        assertEquals(1, pierwiastekRepository.add(pierwiastek));

        List<Pierwiastek> pierwiastki = pierwiastekRepository.getAllPierwiastki();
        Pierwiastek pierwiastekRetrived = pierwiastki.get(0);

        assertEquals(NAZWA_1, pierwiastekRetrived.getNazwa());
    }


}
