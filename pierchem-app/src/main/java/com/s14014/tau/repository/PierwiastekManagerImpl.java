package com.s14014.tau.repository;

import com.s14014.tau.domain.*;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.lang.IllegalStateException;

@Component
public class PierwiastekManagerImpl implements IPierwiastekRepository{

    private Connection connection;

    private PreparedStatement addPierwiastekStmt;
    private PreparedStatement getAllPierwiastekStmt;
    private PreparedStatement deletePierwiastekStmt;
    private PreparedStatement updatePierwiastekStmt;
    private PreparedStatement getPierwiastekByIdStm;
    private PreparedStatement dropTableStm;

    public PierwiastekManagerImpl() throws SQLException {
        this.connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/workdb");
        checkDatabaseAndSetConnection(this.connection);
    }

    void checkDatabaseAndSetConnection(Connection connection) throws SQLException{
        if (!isDatabaseReady()) {
            createTables();
        }

        setConnection(connection);
    }

    public PierwiastekManagerImpl(Connection connection){
        try{
            this.connection = connection;
            if(!isDatabaseReady()){
                createTables();
            }

            setConnection(connection);


        } catch (SQLException e){
            e.printStackTrace();
        }
    }



    public void createTables() throws SQLException{
        connection.createStatement().executeUpdate(
            "CREATE TABLE " + 
            "Pierwiastek(id integer GENERATED BY DEFAULT AS IDENTITY, " +
            "nazwa varchar(30) NOT NULL, " +
            "nrOkresu integer NOT NULL, " +
            "nrGrupy integer NOT NULL, " +
            "liczbaElektronow integer NOT NULL)"
        );      
    }

    public boolean isDatabaseReady() {
        boolean tableExists = false;

        try {
            ResultSet rs = connection.getMetaData().getTables(null, null, null, null);

            while (rs.next()) {
                if ("Pierwiastek".equalsIgnoreCase(rs.getString("TABLE_NAME"))) {
                    tableExists = true;
                    break;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return tableExists;
    }

    public void setConnection(Connection connection) throws SQLException {
        this.connection = connection;
        
        addPierwiastekStmt= connection.
        prepareStatement("INSERT INTO Pierwiastek (nazwa, nrOkresu, nrGrupy, liczbaElektronow) VALUES (?, ?, ?, ?)");
        
        getAllPierwiastekStmt = connection.
        prepareStatement("SELECT * FROM Pierwiastek");

        updatePierwiastekStmt = connection.
        prepareStatement("UPDATE Pierwiastek SET nazwa = ?, nrOkresu = ?, nrGrupy = ?, liczbaElektronow = ? WHERE id = ?");


        deletePierwiastekStmt = connection.
        prepareStatement("DELETE FROM Pierwiastek WHERE id=?");

        getPierwiastekByIdStm = connection.
        prepareStatement("SELECT * FROM Pierwiastek WHERE id = ?");

        dropTableStm = connection.
        prepareStatement("DROP TABLE Pierwiastek");
    }

    @Override
    public int add(Pierwiastek p){
        int count = 0;

        try{
            addPierwiastekStmt.setString(1, p.getNazwa());
            addPierwiastekStmt.setInt(2, p.getNrOkresu());
            addPierwiastekStmt.setInt(3, p.getNrGrupy());
            addPierwiastekStmt.setInt(4, p.getLiczbaElektronow());
            count = addPierwiastekStmt.executeUpdate();
        } catch(SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());      
        }

        return count;
    }


	@Override
	public List<Pierwiastek> getAllPierwiastki() {

        List<Pierwiastek> tablMend = new ArrayList<>();

        try{
            ResultSet rs = getAllPierwiastekStmt.executeQuery();

            while (rs.next()){

                Pierwiastek p = new Pierwiastek();

                p.setId(rs.getInt("id"));
                p.setNazwa(rs.getString("nazwa"));
                p.setNrOkresu(rs.getInt("nrOkresu"));
                p.setNrGrupy(rs.getInt("nrGrupy"));
                p.setLiczbaElektronow(rs.getInt("liczbaElektronow"));
                tablMend.add(p);
            }
        }

        catch(SQLException e){
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());      
        }

        return tablMend;

        
	}

	@Override
	public int deleteById(int id) {
        int count = 0;

		try{

            deletePierwiastekStmt.setInt(1, id);
            count = deletePierwiastekStmt.executeUpdate();
            
        }

        catch(SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());      
        }

        return count;

    }





	@Override
	public int updateById(Pierwiastek p) {

        int count = 0;

		try{

            updatePierwiastekStmt.setString(1, p.getNazwa());
            updatePierwiastekStmt.setInt(2, p.getNrOkresu());
            updatePierwiastekStmt.setInt(3, p.getNrGrupy());
            updatePierwiastekStmt.setInt(4, p.getLiczbaElektronow());
            updatePierwiastekStmt.setInt(5, p.getId());

            count = updatePierwiastekStmt.executeUpdate();
            
            
        } catch(SQLException e) {
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());     
        }

        return count;

    }

	@Override
	public Connection getConnection() {
		return connection;
	}

	@Override
	public Pierwiastek getPierwiastekById(int id) {

        Pierwiastek pierwiastek = new Pierwiastek();
        
        try{
            getPierwiastekByIdStm.setLong(1, id);
            ResultSet rs = getPierwiastekByIdStm.executeQuery();

            while(rs.next()){
                pierwiastek.setId(rs.getInt("id"));
                pierwiastek.setNazwa(rs.getString("nazwa"));
                pierwiastek.setNrOkresu(rs.getInt("nrOkresu"));
                pierwiastek.setNrGrupy(rs.getInt("nrGrupy"));
                pierwiastek.setLiczbaElektronow(rs.getInt("liczbaElektronow"));
            }
        }

        catch (SQLException e){

            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }

        return pierwiastek;
	}

	@Override
	public void dropTable() {
        
        try{
            dropTableStm.executeUpdate();
        }

        catch (SQLException e){
            throw new IllegalStateException(e.getMessage() + "\n" + e.getStackTrace().toString());
        }
	}
}
