package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="compagnie_aerienne")
public class CompagnieAerienne {
	@Id
	@SequenceGenerator(name = "seqCompagnieAerienne", sequenceName = "seq_compagnie_aerienne", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seqCompagnieAerienne", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_compagnie_aerienne")
	private Long id;
	@Column(name = "nom_compagnie_aerienne", length=50)
	private String nom;
	@OneToMany(mappedBy="key.compagnieAerienne")
	private Set<CompagnieAerienneVol> vols;
	
	
	
	public CompagnieAerienne() {
		super();
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public Set<CompagnieAerienneVol> getVols() {
		return vols;
	}
	public void setVols(Set<CompagnieAerienneVol> vols) {
		this.vols = vols;
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
		CompagnieAerienne other = (CompagnieAerienne) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
