package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("El")
public class ClientEl extends Client {

	@Column(name="prenom_client_el")
	private String prenom;

	public ClientEl() {
		super();

	}

	
	public ClientEl(String typeClient, String prenom , String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, String titre) {
		super(typeClient, nom, numeroTel, numeroFax, email, adresse);
		this.prenom=prenom;
	}
	public ClientEl(String typeClient, String prenom , String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Login login, String titre) {
		super(typeClient, nom, numeroTel, numeroFax, email, adresse, login);
		this.prenom=prenom;
	}
	public ClientEl(String typeClient, String prenom, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse) {
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
