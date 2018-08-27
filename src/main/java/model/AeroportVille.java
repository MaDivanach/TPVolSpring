package model;

import javax.persistence.*;

@Entity
@Table(name = "aeroport_ville")
public class AeroportVille {
	@EmbeddedId
	private AeroportVillePK key;
	@Version
	private int version;

	public AeroportVille() {
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
		AeroportVille other = (AeroportVille) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

	public AeroportVillePK getKey() {
		return key;
	}

	public void setKey(AeroportVillePK key) {
		this.key = key;
	}

}
