package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import metier.Adherent;
import metier.Admin;
import metier.Equipe;
import metier.Evenement;

public interface CrudAdherent {

	public boolean checkLogin(String email,String password) throws SQLException;
	
	
	public List<Evenement> getEvenement()throws SQLException;
	
	public Adherent getProfil(String email) throws SQLException;

	
}
