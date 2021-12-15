package metier;

public class Equipe {
	private String nom,sport,genre,tranche,niveau,coach;
	private int membres;

	

	public Equipe(String nom, String sport, String genre, String tranche, String niveau) {
		super();
		this.nom = nom;
		this.sport = sport;
		this.genre = genre;
		this.tranche = tranche;
		this.niveau = niveau;
		this.coach = "none";
		this.membres = 0;
	}
	

	public String getCoach() {
		return coach;
	}


	public void setCoach(String coach) {
		this.coach = coach;
	}


	public int getMembres() {
		return membres;
	}


	public void setMembres(int membres) {
		this.membres = membres;
	}


	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTranche() {
		return tranche;
	}

	public void setTranche(String tranche) {
		this.tranche = tranche;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	
}
