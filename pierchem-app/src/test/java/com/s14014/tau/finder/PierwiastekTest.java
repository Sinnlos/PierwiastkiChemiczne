package com.s14014.tau.finder;

import static org.junit.Assert.*;

import org.junit.Test;

public class PierwiastekTest {
    @Test
    public void test1(){
        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.nrGrupy = 5;
        pierwiastek.przepiszElektrony();
        assertNotNull(pierwiastek);
        assertEquals(pierwiastek.liczbaElektronow, 2);

    }
}