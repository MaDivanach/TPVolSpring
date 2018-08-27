package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "ville")
@SequenceGenerator(name = "seqVille", sequenceName = "seq_ville", initialValue = 1, allocationSize = 1)
public class Ville {
	@Id
	@Column(name = "id_ville")
	private Long id;
	@Version
	private int version;
	@Column(name = "nom_ville", length = 100)
	private String nom;
	@OneToMany(mappedBy = "key.ville")
	private Set<AeroportVille> aeroportVille;

	public Ville() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Ville other = (Ville) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Set<AeroportVille> getAeroportVille() {
		return aeroportVille;
	}

	public void setAeroportVille(Set<AeroportVille> aeroportVille) {
		this.aeroportVille = aeroportVille;
	}

}
