
package com.s14014.tau.domain;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


import java.util.List;

import org.junit.*;
import com.s14014.tau.repository.*;

import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.InOrder;
import org.mockito.Mock;
import java.sql.*;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import static org.mockito.AdditionalMatchers.gt;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class PierwiastekTest {

    IPierwiastekRepository pierwiastekRepository;



    @Mock
    Connection connectionMock;

    @Mock
    IPierwiastekRepository pierwiastekRepositoryMock;

    @Mock
    PreparedStatement addStmtMock;
    @Mock
    PreparedStatement getByIdStmtMock;
    @Mock
    PreparedStatement getAllStmtMock;
    @Mock
    PreparedStatement deleteStmtMock;
    @Mock
    PreparedStatement updateStmtMock;
    @Mock
    PreparedStatement dropStmtMock;



    @Before
    public void setupDatabase() throws SQLException{

        when(connectionMock.prepareStatement("INSERT INTO Pierwiastek (nazwa, nrOkresu, nrGrupy, liczbaElektronow) VALUES (?, ?, ?, ?)"))
                .thenReturn(addStmtMock);
        when(connectionMock.prepareStatement("SELECT * FROM Pierwiastek WHERE id = ?"))
                .thenReturn(getByIdStmtMock);
        when(connectionMock.prepareStatement("SELECT * FROM Pierwiastek"))
                .thenReturn(getAllStmtMock);
        when(connectionMock.prepareStatement("UPDATE Pierwiastek SET nazwa = ?, nrOkresu = ?, nrGrupy = ?, liczbaElektronow = ? WHERE id = ?"))
                .thenReturn(updateStmtMock);
        when(connectionMock.prepareStatement("DELETE FROM Pierwiastek WHERE id=?"))
                .thenReturn(deleteStmtMock);
        when(connectionMock.prepareStatement("DROP TABLE Pierwiastek"))
                .thenReturn(dropStmtMock);

        pierwiastekRepository = new PierwiastekManagerImpl();
        pierwiastekRepositoryMock = mock(PierwiastekManagerImpl.class);
        pierwiastekRepository.setConnection(connectionMock);

        verify(connectionMock).prepareStatement("INSERT INTO Pierwiastek (nazwa, nrOkresu, nrGrupy, liczbaElektronow) VALUES (?, ?, ?, ?)");
        verify(connectionMock).prepareStatement("SELECT * FROM Pierwiastek WHERE id = ?");
        verify(connectionMock).prepareStatement("SELECT * FROM Pierwiastek");
        verify(connectionMock).prepareStatement("UPDATE Pierwiastek SET nazwa = ?, nrOkresu = ?, nrGrupy = ?, liczbaElektronow = ? WHERE id = ?");
        verify(connectionMock).prepareStatement("DELETE FROM Pierwiastek WHERE id=?");
        verify(connectionMock).prepareStatement("DROP TABLE Pierwiastek");


    }


    @Test
    public void addTestMock() throws SQLException{

        when(addStmtMock.executeUpdate()).thenReturn(1);

        Pierwiastek pierwiastek = new Pierwiastek(8, "Tlen", 2,16,6);


        assertEquals(1, pierwiastekRepository.add(pierwiastek));

        verify(addStmtMock, times(1)).setString(1,"Tlen");
        verify(addStmtMock, times(1)).setInt(2, 2);
        verify(addStmtMock, times(1)).setInt(3, 16);
        verify(addStmtMock, times(1)).setInt(4, 6);
        verify(addStmtMock).executeUpdate();
    }

    /*
   @Test
    public void addOrderTestMock() throws Exception{

        InOrder inorder = inOrder(addStmtMock);
        when(addStmtMock.executeUpdate()).thenReturn(1);

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setNazwa("Tlen");
        pierwiastek.setNrOkresu(2);
        pierwiastek.setNrGrupy(16);
        pierwiastek.setLiczbaElektronow(6);

        inorder.verify(addStmtMock, times(1)).setString(1,"Tlen");
        inorder.verify(addStmtMock, times(1)).setInt(2, 2);
        inorder.verify(addStmtMock, times(1)).setInt(3, 16);
        inorder.verify(addStmtMock, times(1)).setInt(4, 6);
    }

  */

    @Test(expected = IllegalStateException.class)
    public void nullAddingTest() throws SQLException{

        when(addStmtMock.executeUpdate()).thenThrow(new SQLException());

        Pierwiastek pierwiastek = new Pierwiastek(0,null,4,2,2);

        assertEquals(1, pierwiastekRepository.add(pierwiastek));
    }

    @Test
    public void deleteTestMock() throws SQLException{

        when(deleteStmtMock.executeUpdate()).thenReturn(1);
        assertEquals(1, pierwiastekRepository.deleteById(1));

    }

    @Test
    public void updateTestMock() throws SQLException{

        Pierwiastek pierwiastek1 = new Pierwiastek(1,"Wapn",4,2,2);


        doReturn(pierwiastek1).when(pierwiastekRepositoryMock).getPierwiastekById(isA(Integer.class));
        Pierwiastek pierwiastekToUpdate = pierwiastekRepositoryMock.getPierwiastekById(1);
        pierwiastekToUpdate.setNazwa("Potas");
        pierwiastekRepository.updateById(pierwiastekToUpdate);

        Pierwiastek pierwiastek2 = new Pierwiastek(1, "Potas", 4,2,2);


        doReturn(pierwiastek2).when(pierwiastekRepositoryMock).getPierwiastekById(2);

        assertThat(pierwiastekRepositoryMock.getPierwiastekById(2).getNazwa(), is(pierwiastekToUpdate.getNazwa()));
        assertEquals(pierwiastekRepositoryMock.getPierwiastekById(2).getNazwa(), pierwiastekToUpdate.getNazwa());

        verify(updateStmtMock, times(1)).setString(1, "Potas");
        verify(updateStmtMock, times(1)).setInt(2, 4);
        verify(updateStmtMock, times(1)).setInt(3, 2);
        verify(updateStmtMock, times(1)).setInt(4, 2);
        verify(updateStmtMock).executeUpdate();

    }











/*

    @Ignore
    @Test
    public void addTest(){

        Pierwiastek pierwiastek = new Pierwiastek();
        pierwiastek.setId(2);
        pierwiastek.setNazwa("Lit");
        pierwiastek.setNrGrupy(1);
        pierwiastek.setNrOkresu(2);
        pierwiastek.setLiczbaElektronow(1);

        pierwiastekRepository.add(pierwiastek);
        assertNotNull(pierwiastekRepository.getPierwiastekById(pierwiastek.getId()));


    }

    @Ignore
    @Test
    public void updateTest(){
        Pierwiastek pierwiastekToUpdate = pierwiastekRepository.getPierwiastekById(3);

        pierwiastekToUpdate.setNazwa("siarka");
        pierwiastekRepository.updateById(pierwiastekToUpdate);

      //  assertEquals(pierwiastekRepository.getPierwiastekById(3).getNazwa(), pierwiastekToUpdate.getNazwa());


        assertThat(pierwiastekRepository.getPierwiastekById(3).getNazwa(), is(pierwiastekToUpdate.getNazwa()));
        assertNotNull(pierwiastekRepository.getPierwiastekById(1));

        assertFalse("nie powinno mody..",pierwiastekRepository.getPierwiastekById(2).getNazwa().equals(pierwiastekToUpdate.getNazwa()));


    }

    @Ignore
    @Test
    public void findTest(){
       Pierwiastek pierwiastek = pierwiastekRepository.getPierwiastekById(2);

        assertNotNull(pierwiastek);
      //  assertEquals("lit", pierwiastekRepository.getPierwiastekById(2).getNazwa());
          assertThat("lit", is(pierwiastekRepository.getPierwiastekById(2).getNazwa()));

    }

    @Ignore
    @Test
    public void getAllTest(){
        List<Pierwiastek> tabMendelejewa = pierwiastekRepository.getAllPierwiastki();

        assertNotNull(tabMendelejewa);
       Pierwiastek pierwiastek = tabMendelejewa.get(3);
       assertNotNull(pierwiastek);

        try{
            Pierwiastek pierwiastekToCatch = tabMendelejewa.get(0);
        }

        catch(IndexOutOfBoundsException aIndexOutOfBoundsException){
            assertThat(aIndexOutOfBoundsException.getMessage(), is("Index: 3, Size: 3"));
        }
    }

    @Ignore
    @Test
    public void deleteTest(){


        pierwiastekRepository.deleteById(1);

        List<Pierwiastek> pierwiastki = pierwiastekRepository.getAllPierwiastki();

        assertNull(pierwiastekRepository.getPierwiastekById(1).getNazwa());
        assertEquals(true, !pierwiastki.isEmpty());
    }

    @Ignore
    @Before
    public void initRepository(){
       pierwiastekRepository = PierwiastekRepositoryFactory.getInstance();
        Pierwiastek wodor = new Pierwiastek(0, "wodor", 1, 1, 1);

        Pierwiastek hel = new Pierwiastek(1, "hel", 1, 18, 2);
        Pierwiastek lit = new Pierwiastek(2, "lit", 2, 1, 1);
        Pierwiastek magnez = new Pierwiastek(3, "magnez", 2, 2, 2);
        Pierwiastek siarka = new Pierwiastek(4, "siarka", 2, 13, 3);

        pierwiastekRepository.add(wodor);
        pierwiastekRepository.add(hel);
        pierwiastekRepository.add(lit);
        pierwiastekRepository.add(magnez);
        pierwiastekRepository.add(siarka);
    }

    @Ignore
    @After
    public void dropRepository(){
        pierwiastekRepository.dropTable();
    }

*/
}