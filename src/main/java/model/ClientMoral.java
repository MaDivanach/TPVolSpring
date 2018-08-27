package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Moral")
public class ClientMoral extends Client {

	@Column(name="siret_client")
	private String siret;
	
	public ClientMoral(String typeClient, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, String siret, String titre) {

		super(typeClient, nom, numeroTel, numeroFax, email, adresse);
		this.siret = siret;
	}



	public ClientMoral(String typeClient, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, String siret,
			Login login, String titre) {

		super(typeClient, nom, numeroTel, numeroFax, email, adresse, login);
		this.siret = siret;
	}

	public ClientMoral() {
		super();
	}

	public String getSiret() {
		return siret;
	}

	public void setSiret(String siret) {
		this.siret = siret;
	}


}
