package com.s14014.tau.service;
import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.domain.Inventor;

import java.util.List;

public interface SortManager {

    void addInventor(Inventor inventor);
    List<Inventor> getAllInventors();
    void deleteInventor(Inventor inventor);
    Inventor findInventorByPesel(String pesel);

    Long addNewPierwiastek(Pierwiastek pierwiastek);
    List<Pierwiastek> getMetalePerwiastki();
    void disposePierwiastek(Inventor inventor, Pierwiastek pierwiastek);
    Pierwiastek findPierwiastekById(Long id);

    List<Pierwiastek> getInventedPierwiastki(Inventor inventor);
    void assignePierwiastek(Long inventorId, Long pierwiastekId);

    void updateInventor(Inventor inventor);
}
