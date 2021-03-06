package com.sopra.TPVolSpring.model;

import java.io.Serializable;

import javax.persistence.*;

import com.sopra.TPVolSpring.model.Aeroport;
import com.sopra.TPVolSpring.model.Vol;

@Embeddable
public class EscalePK implements Serializable {
	@ManyToOne
	@JoinColumn(name = "id_aeroport")
	private Aeroport aeroport;
	@ManyToOne
	@JoinColumn(name = "id_vol")
	private Vol vol;

	public EscalePK() {
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aeroport == null) ? 0 : aeroport.hashCode());
		result = prime * result + ((vol == null) ? 0 : vol.hashCode());
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
		EscalePK other = (EscalePK) obj;
		if (aeroport == null) {
			if (other.aeroport != null)
				return false;
		} else if (!aeroport.equals(other.aeroport))
			return false;
		if (vol == null) {
			if (other.vol != null)
				return false;
		} else if (!vol.equals(other.vol))
			return false;
		return true;
	}

	public Aeroport getAeroport() {
		return aeroport;
	}

	public void setAeroport(Aeroport aeroport) {
		this.aeroport = aeroport;
	}

	public Vol getVol() {
		return vol;
	}

	public void setVol(Vol vol) {
		this.vol = vol;
	}

}
