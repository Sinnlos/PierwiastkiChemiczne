package com.s14014.tau.finder;


public class Pierwiastek {

    public String nazwa;
    public int nrOkresu;
    public int nrGrupy;
    public int liczbaElektronow;
    


    public void przepiszElektrony(){

        if(nrGrupy == 1 || nrGrupy == 2){
            liczbaElektronow = nrGrupy;
        }

        else if(nrGrupy == 13 || nrGrupy == 14 || nrGrupy == 15 || nrGrupy == 16|| nrGrupy == 17 || nrGrupy == 18){
            liczbaElektronow = nrGrupy = 10;
        }

        else{
            liczbaElektronow = 2;
        }

    }

}