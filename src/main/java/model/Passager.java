package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "passager")
@Embeddable
public class Passager {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqPassager")
	@SequenceGenerator(name = "seqPassager", sequenceName = "seq_passager", initialValue = 100, allocationSize = 1)
	@Column(name = "id_passager")
	private Long idPassager;
	@Version
	private int version;
	@Column(name = "nom_passager", length = 50, nullable = false)
	@NotEmpty
	@Length(min = 3, max = 50)
	private String nom;
	@Column(name = "prenom_passager", length = 50)
	@NotEmpty
	@Length(min = 3, max = 50)
	private String prenom;
	@OneToMany(mappedBy = "passager")
	private Set<Reservation> reservations;

	public Passager() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Embedded

	private Adresse adresse;

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Long getIdPassager() {
		return idPassager;
	}

	public void setIdPassager(Long idPassager) {
		this.idPassager = idPassager;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idPassager == null) ? 0 : idPassager.hashCode());
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
		Passager other = (Passager) obj;
		if (idPassager == null) {
			if (other.idPassager != null)
				return false;
		} else if (!idPassager.equals(other.idPassager))
			return false;
		return true;
	}

}
