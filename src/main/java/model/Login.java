package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "login")
@SequenceGenerator(name = "seqLogin", sequenceName = "seq_login", initialValue = 1, allocationSize = 1)
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqLogin")
	@Column(name = "id_login")
	private Long id_login;
	@Column(name = "login")
	private String login;
	@Column(name = "motDePasse")
	private String motDePasse;
	@Column(name = "admin")
	private Boolean admin;

	@OneToOne(mappedBy = "login", fetch = FetchType.LAZY)
	@JoinColumn(name = "id_client")
	private Client client;

	public Login(String login, String motDePasse, Boolean admin) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
	}

	public Login(String login, String motDePasse, Boolean admin, Client client) {
		super();
		this.login = login;
		this.motDePasse = motDePasse;
		this.admin = admin;
		this.client = client;
	}

	public Login() {
		super();
	}

	public void setId(Long id_login) {
		this.id_login = id_login;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public Boolean getAdmin() {
		return admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	public Long getId() {
		return id_login;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + ((client == null) ? 0 : client.hashCode());
		result = prime * result + ((id_login == null) ? 0 : id_login.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((motDePasse == null) ? 0 : motDePasse.hashCode());
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
		Login other = (Login) obj;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (id_login == null) {
			if (other.id_login != null)
				return false;
		} else if (!id_login.equals(other.id_login))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (motDePasse == null) {
			if (other.motDePasse != null)
				return false;
		} else if (!motDePasse.equals(other.motDePasse))
			return false;
		return true;
	}

}
