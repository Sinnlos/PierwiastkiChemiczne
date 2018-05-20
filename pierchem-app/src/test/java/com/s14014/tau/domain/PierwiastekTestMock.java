/*package com.s14014.tau.domain;

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
public class PierwiastekTestMock {


   /* IPierwiastekRepository pierwiastekRepository;



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
        when(connectionMock.prepareStatement("SELECT id, nazwa, nrOkresu, nrGrupy, liczbaElektronow FROM Pierwiastek"))
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


    abstract class AbstractResultSet implements ResultSet{

        int i = 0;

        @Override
        public int getInt(String s) throws SQLException{
            return 1;
        }

        @Override
        public String getString(String columnLabel) throws SQLException{
            return "Hel";
        }

        @Override
        public boolean next() throws SQLException{

            if (i == 1)
                return false;
            i++;
            return true;
        }
    }

    abstract class AbstractResultSetAll implements ResultSet {
        int i = 0;

        @Override
        public int getInt(String s) throws SQLException {
            return 1;
        }

        @Override
        public String getString(String columnLabel) throws SQLException {
            return "Hel";
        }

        @Override
        public boolean next() throws SQLException {
            if (i == 1)
                return false;
            i++;
            return true;
        }
    }


    @Test
    public void getByIdTest() throws SQLException{

        PierwiastekTest.AbstractResultSet mockedResultSet = mock(PierwiastekTest.AbstractResultSet.class);
        when(mockedResultSet.next()).thenCallRealMethod();
        when(mockedResultSet.getInt("id")).thenCallRealMethod();
        when(mockedResultSet.getInt("nazwa")).thenCallRealMethod();
        when(mockedResultSet.getInt("nrOkresu")).thenCallRealMethod();
        when(mockedResultSet.getInt("nrGrupy")).thenCallRealMethod();
        when(mockedResultSet.getInt("liczbaElektronow")).thenCallRealMethod();
        when(getByIdStmtMock.executeQuery()).thenReturn(mockedResultSet);

        assertNotNull(pierwiastekRepository.getPierwiastekById(1));


        verify(getByIdStmtMock, times(1)).executeQuery();
        verify(mockedResultSet, times(1)).getInt("id");
        verify(mockedResultSet, times(1)).getString("nazwa");
        verify(mockedResultSet, times(1)).getInt("nrOkresu");
        verify(mockedResultSet, times(1)).getInt("nrGrupy");
        verify(mockedResultSet, times(1)).getInt("liczbaElektronow");
        verify(mockedResultSet, times(2)).next();
    }

    @Test
    public void getAllTest() throws SQLException{

        PierwiastekTest.AbstractResultSetAll mockedResultSetAll = mock(PierwiastekTest.AbstractResultSetAll.class);
        when(mockedResultSetAll.next()).thenCallRealMethod();
        when(mockedResultSetAll.getInt("id")).thenCallRealMethod();
        when(mockedResultSetAll.getString("nazwa")).thenCallRealMethod();
        when(mockedResultSetAll.getInt("nrOkresu")).thenCallRealMethod();
        when(mockedResultSetAll.getInt("nrGrupy")).thenCallRealMethod();
        when(mockedResultSetAll.getInt("liczbaElektronow")).thenCallRealMethod();
        when(getAllStmtMock.executeQuery()).thenReturn(mockedResultSetAll);

        assertEquals(1, pierwiastekRepository.getAllPierwiastki().size());

        verify(getAllStmtMock, times(1)).executeQuery();
        verify(mockedResultSetAll, times(1)).getInt("id");
        verify(mockedResultSetAll, times(1)).getString("nazwa");
        verify(mockedResultSetAll, times(1)).getInt("nrOkresu");
        verify(mockedResultSetAll, times(1)).getInt("nrGrupy");
        verify(mockedResultSetAll, times(1)).getInt("liczbaElektrownow");
        verify(mockedResultSetAll, times(2)).next();
    }


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


}
*/