package metier;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Marchandise implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7171459894241340561L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long numero;
	private String nom;
	private double poids;
	private double volume;

	@ManyToOne
	private Cargaison maCargaison;

	public Cargaison getMaCargaison() {
		return maCargaison;
	}

	public void setMaCargaison(Cargaison maCargaison) {
		this.maCargaison = maCargaison;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getVolume() {
		return volume;
	}

	public void setVolume(double volume) {
		this.volume = volume;
	}

	@Override
	public String toString() {
		return "Marchandise [numero=" + numero + ", nom=" + nom + ", poids=" + poids + ", volume=" + volume + "]";
	}

}
