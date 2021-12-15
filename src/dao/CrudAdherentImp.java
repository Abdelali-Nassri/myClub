package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import dao.Factory;
import metier.Adherent;
import metier.Admin;
import metier.Equipe;
import metier.Evenement;

public class CrudAdherentImp implements CrudAdherent {
	static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
	




@Override
public boolean checkLogin(String email, String password) throws SQLException {
	

		 Connection con = Factory.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM adherent "
				+ "WHERE email = ? and code = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			
			confirmer( email);
			
			return rs.next();
		} catch (SQLException eb) {
			return false;
		} finally {
			con.close();
			ps.close();
			rs.close();
		}
	}



public void confirmer(String email) throws SQLException {
	

	 Connection con = Factory.dbConnect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	
		ps = con.prepareStatement("update adherent set confirmer=? where email=?");
		ps.setBoolean(1, true);
		ps.setString(2, email);
		ps.executeUpdate();
		con.close();
		
	
		
		
	
}


@Override
public ArrayList<Evenement> getEvenement() throws SQLException {
ArrayList<Evenement> evenements = new ArrayList<Evenement>();	
	
	String query1 = "select * from evenement";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query1);
    rs = ps.executeQuery();
    while(rs.next()){
    	Evenement eq=new Evenement(rs.getDate("date"), rs.getString("debut"), rs.getString("fin"),rs.getString("equipe"));
    	
    	evenements.add(eq);}
    
    con.close();
    return evenements;
}





@Override
public Adherent getProfil(String email) throws SQLException {
	Connection con = Factory.dbConnect();
	PreparedStatement ps = null;
	ResultSet rs = null;
	String query = "SELECT * FROM adherent  WHERE email = ? ";
	
		ps = con.prepareStatement(query);
		ps.setString(1, email);
		rs = ps.executeQuery();
    	Adherent eq=new Adherent(rs.getString("email"), rs.getString("nom"), rs.getString("role"),rs.getString("equipe"),rs.getInt("age"),rs.getBoolean("confirmer"),rs.getDate("date"));
		
		
	
	
		con.close();
		
		return eq;
	
	
}














}
