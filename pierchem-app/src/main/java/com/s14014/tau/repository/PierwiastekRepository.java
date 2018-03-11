package com.s14014.tau.repository;

import com.s14014.tau.domain.*;
import java.util.List;

public interface PierwiastekRepository{

    public void initDatabase();

    public Pierwiastek getById(int id);
    public List<Pierwiastek> getAll();
    public void add(Pierwiastek p);
    public Pierwiastek deleteById(int id);
    public Pierwiastek updateById(int id);
	

    
    




}