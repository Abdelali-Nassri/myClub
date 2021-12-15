package metier;

import java.sql.Date;

import com.mysql.fabric.xmlrpc.base.Data;

public class Adherent {

	private String email,nom,role,equipe;
	private int age,code;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	private boolean confirmer;
	private Date date;
	public Adherent(String email, String nom, String role, String equipe, int age, boolean confirmer, Date date) {
		super();
		this.email = email;
		this.nom = nom;
		this.role = role;
		this.equipe = equipe;
		this.age = age;
		this.confirmer = confirmer;
		this.date = date;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getEquipe() {
		return equipe;
	}
	public void setEquipe(String equipe) {
		this.equipe = equipe;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isConfirmer() {
		return confirmer;
	}
	public void setConfirmer(boolean confirmer) {
		this.confirmer = confirmer;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
