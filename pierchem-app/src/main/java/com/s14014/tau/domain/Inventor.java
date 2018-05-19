package com.s14014.tau.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@NamedQueries(value = {
        @NamedQuery(name = "inventor.all", query = "Select i from Inventor i"),
        @NamedQuery(name = "inventor.byPesel", query = "Select i from Inventor i where i.pesel = :pesel")
})
public class Inventor{

    private Long id;
    private String imie;
    private String nazwisko;
    private Date firstInventDate;
    private String pesel;

    private List<Pierwiastek> pierwiastki;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getImie(){
        return imie;
    }

    public void setImie(String imie){
        this.imie = imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }

    @Temporal(TemporalType.DATE)
    public Date getFirstInventDate() { return firstInventDate; }

    public void setFirstInventDate(Date firstInventDate) { this.firstInventDate = firstInventDate; }

    @Column(unique = true, nullable = false)
    public String getPesel(){return pesel;}

    public void setPesel(String pesel){this.pesel = pesel;}

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public List<Pierwiastek> getPierwiastki(){return pierwiastki;}

    public void setPierwiastki(List<Pierwiastek> pierwiastki){this.pierwiastki = pierwiastki;}


  /*  public Inventor(int id, String imie, String nazwisko){
        this.id = id;
        this.imie = imie;
        this.nazwisko = nazwisko;
    }
    */


}