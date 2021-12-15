package metier;

import java.sql.Date;

public class Evenement {
	private java.sql.Date date;
	String debut,fin,equipe;
	
	public Evenement(Date date, String debut, String fin, String equipe) {
		super();
		this.date = date;
		this.debut = debut;
		this.fin = fin;
		this.equipe = equipe;
	}

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	public String getDebut() {
		return debut;
	}
	public void setDebut(String debut) {
		this.debut = debut;
	}
	public String getFin() {
		return fin;
	}
	public void setFin(String fin) {
		this.fin = fin;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	
	
}
