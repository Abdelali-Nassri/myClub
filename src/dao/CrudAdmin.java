package dao;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import metier.Adherent;
import metier.Admin;
import metier.Equipe;
import metier.Evenement;

public interface CrudAdmin {

	public boolean checkLoginAdmin(String email,String password) throws SQLException;
	
	public void ajouterEquipe(Equipe aq)throws SQLException;
	public List<Equipe> chercherEquipe(String key)throws SQLException;
	public List<Equipe> getEquipes()throws SQLException;
	public void supprimerEquipe(String nom)throws SQLException;
	
	public void ajouterEvenement(Evenement ev)throws SQLException;
	public void supprimerEvenement(Evenement ev)throws SQLException;
	List<Evenement> chercherEvenement(String date) throws SQLException;
	public List<Evenement> getEvenement()throws SQLException;
	
	public void ajouterMembre(Adherent me)throws SQLException;
	public void supprimerMembre(String email,String role,String equipe)throws SQLException;
	public List<Adherent> chercherMembre(String key)throws SQLException;
	public List<Adherent> getMembres()throws SQLException;
	
	public void uppdateMembre(Adherent me,String exequipe)throws SQLException;
	
	public void uppdateEquipe(int c,String coach,String equipe)throws SQLException;
	
	public void isConfirmed(String email) throws SQLException;

	
}
