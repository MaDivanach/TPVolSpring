package model;

import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name = "aeroport")
@SequenceGenerator(name = "seqAeroport", sequenceName = "seq_aeroport", initialValue = 1, allocationSize = 1)
public class Aeroport {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqAeroport")
	@Column(name = "id_aeroport")
	private Long id;
	@Version
	private int version;
	@Column(name = "nom_aeroport", length = 50)
	private String nom;
	@OneToMany(mappedBy = "arrivee")
	private Set<Vol> arrivees;
	@OneToMany(mappedBy = "depart")
	private Set<Vol> departs;
	@OneToMany(mappedBy = "key.aeroport")
	private Set<AeroportVille> aeroportVille;
	@OneToMany(mappedBy = "key.aeroport")
	private Set<Escale> escales;

	public Aeroport() {
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
		Aeroport other = (Aeroport) obj;
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

	public Set<Escale> getEscales() {
		return escales;
	}

	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}

	public String getDescription() {
		return "Aeroport de " + this.getNom();
	}
}
