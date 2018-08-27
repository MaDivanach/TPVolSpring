package model;

import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "escale")
public class Escale {
	@EmbeddedId
	private EscalePK key;
	@Version
	private int version;
	@Column(name = "heure_depart")
	@Temporal(TemporalType.TIME)
	private Date heureDepart;
	@Column(name = "heure_arrivee")
	@Temporal(TemporalType.TIME)
	private Date heureArrivee;

	public Escale() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		Escale other = (Escale) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public EscalePK getKey() {
		return key;
	}

	public void setKey(EscalePK key) {
		this.key = key;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public Date getHeureDepart() {
		return heureDepart;
	}

	public void setHeureDepart(Date heureDepart) {
		this.heureDepart = heureDepart;
	}

	public Date getHeureArrivee() {
		return heureArrivee;
	}

	public void setHeureArrivee(Date heureArrivee) {
		this.heureArrivee = heureArrivee;
	}

}
