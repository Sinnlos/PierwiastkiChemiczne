package com.s14014.tau.domain;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({
        @NamedQuery(name = "pierwiastek.niemetal" , query = "Select p from Pierwiastek p where p.metal = false")
})

public class Pierwiastek {

    private  Long id;
    private  String nazwa;
    private  int nrOkresu;
    private  int nrGrupy;
    private  int liczbaElektronow;
    private  Boolean metal = false;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
 
    public void setId(Long id) {
        this.id = id;
    }

    public String getNazwa(){
        return nazwa;
    }

    public void setNazwa(String nazwa){
        this.nazwa = nazwa;
    }

    public int getNrOkresu(){
        return nrOkresu;
    }

    public void setNrOkresu(int nrOkresu){
        this.nrOkresu = nrOkresu;
    }

    public int getNrGrupy(){
        return nrGrupy;
    }

    public void setNrGrupy(int nrGrupy){
        this.nrGrupy = nrGrupy;
    }

    public int getLiczbaElektronow(){
        return liczbaElektronow;
    }

    public void setLiczbaElektronow(int liczbaElektronow){
        this.liczbaElektronow = liczbaElektronow;
    }

    public Boolean getMetal(Boolean metal){ return metal; }

    public void setMetal(Boolean metal){ this.metal = metal; }

    

	public Pierwiastek(Long id, String nazwa, int nrOkresu, int nrGrupy, int liczbaElektronow, Boolean metal) {

        this.id = id;
        this.nazwa = nazwa;
        this.nrOkresu = nrOkresu;
        this.nrGrupy = nrGrupy;
        this.liczbaElektronow = liczbaElektronow;
        this.metal = metal;
	}

	public Pierwiastek() {
	}

/*	@Override
    public boolean equals(Object o){
        Pierwiastek other = (Pierwiastek) o;
        boolean ret = other.getNazwa().equals(this.getNazwa()) &&
                (other.getId() == this.getId()) &&
                (other.getNrGrupy() == this.getNrGrupy()) &&
                (other.getNrOkresu() == this.getNrOkresu()) &&
                (other.getLiczbaElektronow() == this.getLiczbaElektronow()) &&;

                return ret;
    }

    @Override
    public String toString(){
        return "[" + id + "," + nazwa + "," + nrGrupy + "," + nrOkresu +
                "," + liczbaElektronow + "]" ;

    }

  */

    /*public void przepiszElektrony(){

        if(nrGrupy == 1 || nrGrupy == 2){
            liczbaElektronow = nrGrupy;
        }

        else if(nrGrupy == 13 || nrGrupy == 14 || nrGrupy == 15 || nrGrupy == 16|| nrGrupy == 17 || nrGrupy == 18){
            liczbaElektronow = nrGrupy = 10;
        }

        else{
            liczbaElektronow = 2;
        }

    } */

}