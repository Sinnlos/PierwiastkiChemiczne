package com.s14014.tau.domain.repository;


import com.s14014.tau.domain.Pierwiastek;
import com.s14014.tau.repository.PierwiastekManagerImpl;
import com.s14014.tau.repository.IPierwiastekRepository;

import static org.junit.Assert.*;

import java.net.URL;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.s14014.tau.repository.IPierwiastekRepository;
import com.s14014.tau.repository.PierwiastekManagerImpl;
import org.dbunit.Assertion;

import org.dbunit.DBTestCase;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.SortedTable;
import org.dbunit.dataset.filter.DefaultColumnFilter;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;



@RunWith(JUnit4.class)
public class PierwiastekDBUnitTest extends DBTestCase{

    public static String url = "jdbc:hsqldb:hsql://localhost/workdb";

    IPierwiastekRepository pierwiastekManager;

    @After
    public void tearDown() throws Exception{
        super.tearDown();
    }

    @Before
    public void setUp() throws Exception{
        super.setUp();
        pierwiastekManager = new PierwiastekManagerImpl(DriverManager.getConnection(url));
    }

    @Test
    public void doNothing(){
        assertEquals(4, pierwiastekManager.getAllPierwiastki().size());
    }

    @Test
    public void checkAdding() throws Exception{

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa("lit");
        pierwiastek.setNrGrupy(1);
        pierwiastek.setNrOkresu(2);
        pierwiastek.setLiczbaElektronow(1);

        assertEquals(1, pierwiastekManager.add(pierwiastek));

        // Data verification

        IDataSet dbDataSet = this.getConnection().createDataSet();
        ITable actualTable = dbDataSet.getTable("PIERWIASTEK");
        ITable filteredTable = DefaultColumnFilter.excludedColumnsTable(actualTable, new String[] { "ID" });
        IDataSet expectedDataSet = getDataSet("ds-2.xml");
        ITable expectedTable = expectedDataSet.getTable("PIERWIASTEK");
        Assertion.assertEquals(expectedTable, filteredTable);
        pierwiastekManager.deletePierwiastek(pierwiastek);


    }

    @Override
    protected DatabaseOperation getSetUpOperation() throws Exception {
        return DatabaseOperation.INSERT;
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE;
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return this.getDataSet("ds-1.xml");
    }


    /**
     * Returns dataset for selected resource
     * @param datasetName filename in resources
     * @return flat xml data set
     * @throws Exception when there is a problem with opening dataset
     */
    protected IDataSet getDataSet(String datasetName) throws Exception {
        URL url = getClass().getClassLoader().getResource(datasetName);
        FlatXmlDataSet ret = new FlatXmlDataSetBuilder().build(url.openStream());
        return ret;
    }
}
