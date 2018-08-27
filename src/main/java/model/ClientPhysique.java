package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Physique")
public class ClientPhysique extends Client {

	@Column(name="prenom_client_physique")
	private String prenom;

	public ClientPhysique() {
		super();
	}

	public ClientPhysique(String typeClient,String prenom, String nom, Integer numeroTel, Integer numeroFax, String email,
			Adresse adresse, String titre) {
		super(typeClient, nom, numeroTel, numeroFax, email, adresse);
		this.prenom = prenom;
	}

	public ClientPhysique(String typeClient,String prenom, String nom, Integer numeroTel, Integer numeroFax, String email,
			Adresse adresse, Login login, String titre) {
		super(typeClient, nom, numeroTel, numeroFax, email, adresse, login);
		this.prenom = prenom;
	}

	public ClientPhysique(String typeClient, String prenom, String nom, Integer numeroTel, Integer numeroFax, String email,
			Adresse adresse) {
		super(typeClient, nom, numeroTel, numeroFax, email, adresse);
		this.prenom = prenom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

}
