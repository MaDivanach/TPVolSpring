package com.sopra.TPVolSpring.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="vol")
public class Vol {
	
	@Id
	@SequenceGenerator(name = "seqVol", sequenceName = "seq_vol", initialValue = 100, allocationSize = 1)
	@GeneratedValue(generator = "seqVol", strategy = GenerationType.SEQUENCE)
	@Column(name = "id_vol")
	private Long id;
	@Column(name = "date_depart")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateDepart;
	@Column(name = "date_arrivee")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateArrivee;
	@Column(name = "heure_depart")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	private Date heureDepart;
	@Column(name = "heure_arrivee")
	@Temporal(TemporalType.TIME)
	@DateTimeFormat(pattern = "HH:mm")
	
	private Date heureArrivee;
	@ManyToOne
	@JoinColumn(name = "arrivee_id")
	private Aeroport arrivee;
	@ManyToOne
	@JoinColumn(name = "depart_id")
	private Aeroport depart;
	@OneToMany(mappedBy = "vol")
	private Set<Reservation> reservations;
	@OneToMany(mappedBy = "key.vol")
	private Set<Escale> escales;
	@OneToMany(mappedBy="key.vol")
	private Set<CompagnieAerienneVol> compagnieAeriennes;
	@Version
	private int version;
	
	
	
	public Vol() {
		super();
	}
	
	
	public int getVersion() {
		return version;
	}


	public void setVersion(int version) {
		this.version = version;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(Date dateDepart) {
		this.dateDepart = dateDepart;
	}
	public Date getDateArrivee() {
		return dateArrivee;
	}
	public void setDateArrivee(Date dateArrivee) {
		this.dateArrivee = dateArrivee;
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
	public Aeroport getArrivee() {
		return arrivee;
	}
	public void setArrivee(Aeroport arrivee) {
		this.arrivee = arrivee;
	}
	public Aeroport getDepart() {
		return depart;
	}
	public void setDepart(Aeroport depart) {
		this.depart = depart;
	}
	public Set<Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}
	public Set<Escale> getEscales() {
		return escales;
	}
	public void setEscales(Set<Escale> escales) {
		this.escales = escales;
	}
	public Set<CompagnieAerienneVol> getCompagnieAeriennes() {
		return compagnieAeriennes;
	}
	public void setCompagnieAeriennes(Set<CompagnieAerienneVol> compagnieAeriennes) {
		this.compagnieAeriennes = compagnieAeriennes;
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
		Vol other = (Vol) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
