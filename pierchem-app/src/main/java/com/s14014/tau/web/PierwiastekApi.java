package com.s14014.tau.web;

import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.repository.IPierwiastekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

@RestController
public class PierwiastekApi {

    @Autowired
    IPierwiastekRepository pierwiastekRepository;

    @RequestMapping("/")
    public String index(){
        return "This is not rest, just checking if everything works.";

    }

    @RequestMapping(value = "pierwiastki", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Pierwiastek> getPieriwaski() throws SQLException{
        List<Pierwiastek> pierwiastki = new LinkedList<>();
        pierwiastki.addAll(pierwiastekRepository.getAllPierwiastki());

        return pierwiastki;

    }

    @RequestMapping(value = "/pierwiastek/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pierwiastek getPierwiastek(@PathVariable("id") int id) throws SQLException{
        return pierwiastekRepository.getPierwiastekById(id);
    }

    @RequestMapping(value = "/pierwiastek/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public int deletePierwiastek(@PathVariable("id") int id){
        return (int) pierwiastekRepository.deleteById(id);
    }

    @RequestMapping(value = "/pierwiastek", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public int addPierwiastek(@RequestBody Pierwiastek p){
        return (int) pierwiastekRepository.add(p);
    }

    @RequestMapping(value = "/pierwiastek", method = RequestMethod.PUT)
    public int updatePierwiastek(@RequestBody Pierwiastek p) throws SQLException{
        return (int) pierwiastekRepository.updateById(p);
    }

























}
