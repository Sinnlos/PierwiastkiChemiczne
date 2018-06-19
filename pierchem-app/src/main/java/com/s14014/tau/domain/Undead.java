package com.s14014.tau.domain;

import javax.persistence.*;


@Entity
@NamedQueries({
        @NamedQuery(name = "undead.male" , query = "Select un from Undead un where un.male = false")
})
public class Undead {
    private Long id;
    private String name;
    private String ability;
    private Integer strength;
    private Integer health;
    private String userName;

    private Boolean male;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getMale() {
        return male;
    }

    public void setMale(Boolean male) {
        this.male = male;
    }


    public Undead(Long id, String name, String ability, Integer strength, Integer health, String userName, Boolean male){

        this.id = id;
        this.name = name;
        this.ability = ability;
        this.strength = strength;
        this.health = health;
        this.male = male;
    }

    public Undead(){

    }
}

