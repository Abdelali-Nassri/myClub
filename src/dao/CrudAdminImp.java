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

public class CrudAdminImp implements CrudAdmin {
	static Connection con = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;
	




@Override
public boolean checkLoginAdmin(String email, String password) throws SQLException {
	

		 Connection con = Factory.dbConnect();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String query = "SELECT * FROM admin "
				+ "WHERE email = ? and password = ?";
		try {
			ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			rs = ps.executeQuery();
			return rs.next();
		} catch (SQLException eb) {
			return false;
		} finally {
			con.close();
			ps.close();
			rs.close();
		}
	}

@Override
public void ajouterEquipe(Equipe aq) throws SQLException {
	String query = "INSERT INTO equipe (nom, coach,membres,sport,genre,tranche,niveau) VALUES (?,?,?,?,?,?,?)";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query);
    ps.setString(1, aq.getNom());
    ps.setString(2, aq.getCoach());
    ps.setInt(3, aq.getMembres());
    ps.setString(4, aq.getSport());
    ps.setString(5, aq.getGenre());
    ps.setString(6, aq.getTranche());
    ps.setString(7, aq.getNiveau());


    ps.executeUpdate();
    
    
    con.close();
	
}

@Override
public ArrayList<Equipe> getEquipes() throws SQLException {
ArrayList<Equipe> equipes = new ArrayList<Equipe>();	
	
	String query1 = "select * from equipe";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query1);
    rs = ps.executeQuery();
    while(rs.next()){
    	Equipe eq=new Equipe(rs.getString("nom"), rs.getString("sport"), rs.getString("genre"),rs.getString("tranche"),rs.getString("niveau"));
    	eq.setCoach(rs.getString("coach"));
    	eq.setMembres(rs.getInt("membres"));
    	equipes.add(eq);}
    
    con.close();
    return equipes;
}

@Override
public void supprimerEquipe(String nom) throws SQLException {
	String query2 = "DELETE FROM equipe WHERE nom=?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query2);
    ps.setString(1, nom);
    ps.executeUpdate();
    String equipe ="none";
    ps = con.prepareStatement("update adherent set equipe = ? where equipe = ?");
    ps.setString(1, equipe);
    ps.setString(2, nom);
    ps.executeUpdate();
    
    con.close();
	
}

@Override
public ArrayList<Equipe> chercherEquipe(String key) throws SQLException {
ArrayList<Equipe> equipes = getEquipes();
if(key.equals(null)) {return equipes;}
ArrayList<Equipe> equipesSearch = new ArrayList<Equipe>();
	for (Equipe equipe : equipes) {
		if(equipe.getNom().contains(key) || equipe.getSport().contains(key) || equipe.getCoach().contains(key)) {
			equipesSearch.add(equipe);
		}
	}
    return equipesSearch;
}

@Override
public void ajouterMembre(Adherent me) throws SQLException {
	String query = "INSERT INTO adherent (email, nom,age,role,equipe,confirmer,date,code) VALUES (?,?,?,?,?,?,?,?)";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query);
    ps.setString(1, me.getEmail());
    ps.setString(2, me.getNom());
    ps.setInt(3, me.getAge());
    ps.setString(4, me.getRole());
    ps.setString(5, me.getEquipe());
    ps.setBoolean(6, me.isConfirmer());
    ps.setDate(7, me.getDate());
    ps.setInt(8, me.getCode());


    ps.executeUpdate();
    
    
    con.close();
    if(me.getRole().equals("Coach")) {
	uppdateEquipe(1,me.getNom(),me.getEquipe());}
    if(me.getRole().equals("Joueur")) {
    	uppdateEquipe(11,"none",me.getEquipe());}
}

@Override
public void supprimerMembre(String email,String role,String equipe) throws SQLException {
	String query2 = "DELETE FROM adherent WHERE email=?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query2);
    ps.setString(1, email);
    ps.executeUpdate();
    System.out.println(role);
    System.out.println(equipe);
    con.close();
    if(role.equals("Coach")) {
    	System.out.println(role);
        System.out.println(equipe);
    	uppdateEquipe(2,"none",equipe);}
    else if(role.equals("Joueur")) {
        	uppdateEquipe(22,"",equipe);}
}

@Override
public ArrayList<Adherent> chercherMembre(String key) throws SQLException {
	ArrayList<Adherent> membres = getMembres();
	if(key.equals(null)) {return membres;}
	ArrayList<Adherent> membreSearch = new ArrayList<Adherent>();
		for (Adherent membre : membres) {
			if(membre.getNom().contains(key) || membre.getEmail().contains(key) || membre.getRole().contains(key)) {
				membreSearch.add(membre);
			}
		}
	    return membreSearch;
}

@Override
public ArrayList<Adherent> getMembres() throws SQLException {
ArrayList<Adherent> membres = new ArrayList<Adherent>();	
	
	String query1 = "select * from adherent";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query1);
    rs = ps.executeQuery();
    while(rs.next()){
    	Adherent eq=new Adherent(rs.getString("email"), rs.getString("nom"), rs.getString("role"),rs.getString("equipe"),rs.getInt("age"),rs.getBoolean("confirmer"),rs.getDate("date"));
    	membres.add(eq);}
    
    con.close();
    return membres;
	
}

@Override
public void uppdateEquipe(int c,String coach, String equipe) throws SQLException {
	int i=1;
	String query2 ;
	con =Factory.dbConnect();
	if(c==1) {
	query2 = "update equipe set membres = membres + ? , coach = ? WHERE nom=?";
    ps = con.prepareStatement(query2);
    ps.setInt(1, i);
    ps.setString(2, coach);
    ps.setString(3, equipe);}
	if(c==11) {
		query2 = "update equipe set membres = membres + ?  WHERE nom=?";
	    ps = con.prepareStatement(query2);
	    ps.setInt(1, i);
	    ps.setString(2, equipe);}
	if(c==2) {
		query2 = "update equipe set membres = membres - ? , coach = ? WHERE nom=?";
	    ps = con.prepareStatement(query2);
	    ps.setInt(1, i);
	    ps.setString(2, coach);
	    ps.setString(3, equipe);}
	if(c==22) {
		query2 = "update equipe set membres = membres - ?  WHERE nom=?";
	    ps = con.prepareStatement(query2);
	    ps.setInt(1, i);
	    ps.setString(2, equipe);}
    ps.executeUpdate();
    
  
    
    con.close();
	
}

@Override
public void uppdateMembre(Adherent me,String exequipe) throws SQLException {
	String query = "update adherent set age=?,role=?,equipe=?,confirmer=? where email =?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query);
    ps.setInt(1, me.getAge());
    ps.setString(2, me.getRole());
    ps.setString(3, me.getEquipe());
    ps.setBoolean(4, me.isConfirmer());
    ps.setString(5, me.getEmail());


    ps.executeUpdate();
   con.close();
    if(me.getEquipe().equals(exequipe) && me.getRole().equals("Coach")) {}
    if(!me.getEquipe().equals(exequipe) && me.getRole().equals("Coach")) {uppdateEquipe(2, "none", exequipe);uppdateEquipe(1, me.getNom(), me.getEquipe());}
    if(!me.getEquipe().equals(exequipe) && me.getRole().equals("Joueur")) {uppdateEquipe(22,"", exequipe);uppdateEquipe(11,"", exequipe);}

}

@Override
public void isConfirmed(String email) throws SQLException {

	String query = "update adherent set confirmer=? where email =?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query);
    boolean isc =true;
    ps.setBoolean(1, isc);
    ps.setString(2, email);
    

    ps.executeUpdate();
    
    con.close();
	
}

@Override
public void ajouterEvenement(Evenement ev) throws SQLException {
	String query = "INSERT INTO evenement (date, debut,fin,equipe) VALUES (?,?,?,?)";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query);
    ps.setDate(1, ev.getDate());
    ps.setString(2, ev.getDebut());
    ps.setString(3, ev.getFin());
    ps.setString(4, ev.getEquipe());
   


    ps.executeUpdate();
    
    
    con.close();
	
	
}

@Override
public void supprimerEvenement(Evenement ev) throws SQLException {
	String query2 = "DELETE FROM evenement WHERE date=? and debut=? and fin=? and equipe =?";
	con =Factory.dbConnect();
    ps = con.prepareStatement(query2);
    ps.setDate(1, ev.getDate());
    ps.setString(2, ev.getDebut());
    ps.setString(3, ev.getFin());
    ps.setString(4, ev.getEquipe());

    ps.executeUpdate();
    
    
    con.close();
	
}


@Override
public ArrayList<Evenement> chercherEvenement(String date) throws SQLException {
	ArrayList<Evenement> evenements = getEvenement();

	ArrayList<Evenement> evenementsSearch = new ArrayList<Evenement>();
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	  

	  //convert String to LocalDate
	if(!date.equals("")) {
		LocalDate localDate = LocalDate.parse(date, formatter);
		for (Evenement evenement : evenements) {
			
				
				if(evenement.getDate().toLocalDate().equals(localDate) ) {
				evenementsSearch.add(evenement);
				
			
		}
		}
	}else {return evenements;}
	    return evenementsSearch;
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







}
