package com.sopra.TPVolSpring.model;

import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name="client")
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, length = 10, name = "type")
public abstract class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqClient")
	@SequenceGenerator(name = "seqClient", sequenceName = "seq_client", initialValue = 50, allocationSize = 1)
	@Column(name = "id_client")
	private Long id_client;
	
//	@Version
//	private int version;
	
	@Column(name = "nom_client", length=60)
	private String nom;
	
	@Column(name="tel_client",length=15)
	private Integer numeroTel;
		
	@Column(name="fax_client",length=20)
	private Integer numeroFax;
	
	@Column(name="email_client",length=50)
	private String email;
	
	@Embedded
	@AttributeOverrides({ @AttributeOverride(name = "numero", column = @Column(name = "numero_rue_client")),
			@AttributeOverride(name = "rue", column = @Column(name = "rue_client", length = 150)),
			@AttributeOverride(name = "codePostal", column = @Column(name = "code_postal_client", length = 5)),
			@AttributeOverride(name = "ville", column = @Column(name = "ville_client", length = 150)) })
	private Adresse adresse;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_login")
	private Login login;
    
    @OneToMany(mappedBy="client")
    private Set<Reservation> reservations;

	public Client(String typeClient,String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
	}

	public Client(String typeClient, String nom, Integer numeroTel, Integer numeroFax, String email, Adresse adresse, Login login) {
		super();
		this.nom = nom;
		this.numeroTel = numeroTel;
		this.numeroFax = numeroFax;
		this.email = email;
		this.adresse = adresse;
		this.login = login;
	}

	
//	public int getVersion() {
//		return version;
//	}
//
//	public void setVersion(int version) {
//		this.version = version;
//	}

	public Client() {
		super();
	}


	public void setId(Long id_client) {
		this.id_client = id_client;

	}

	public Long getId() {
		return id_client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Integer getNumeroTel() {
		return numeroTel;
	}

	public void setNumeroTel(Integer numeroTel) {
		this.numeroTel = numeroTel;
	}
	
	

	public Long getId_client() {
		return id_client;
	}

	public void setId_client(Long id_client) {
		this.id_client = id_client;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Integer getNumeroFax() {
		return numeroFax;
	}

	public void setNumeroFax(Integer numeroFax) {
		this.numeroFax = numeroFax;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id_client == null) ? 0 : id_client.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (id_client == null) {
			if (other.id_client != null)
				return false;
		} else if (!id_client.equals(other.id_client))
			return false;
		return true;
	}
	
	

	
}
