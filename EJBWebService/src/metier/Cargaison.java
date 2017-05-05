package metier;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="typeCargaison")
@XmlRootElement
@XmlSeeAlso({CargaisonAerienne.class, CargaisonRoutiere.class})//pour qu'on voit aussi les classes filles
@XmlAccessorType(XmlAccessType.FIELD)//pour qu'on puisse mettre @XmlTransient sur un attribut et non sur le getter correspondant
public class Cargaison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8892202980378287011L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long idReference;
	private int distance;
	private Date dateLivraison;

	@XmlTransient
	@OneToMany(mappedBy="maCargaison",cascade=CascadeType.PERSIST)
	private Collection<Marchandise> mesMarchandises;

	
	public Collection<Marchandise> getMesMarchandises() {
		return mesMarchandises;
	}

	public void setMesMarchandises(Collection<Marchandise> mesMarchandises) {
		this.mesMarchandises = mesMarchandises;
	}

	public long getIdReference() {
		return idReference;
	}

	public void setIdReference(long idReference) {
		this.idReference = idReference;
	}

	public int getDistance() {
		return distance;
	}

	public void setDistance(int distance) {
		this.distance = distance;
	}

	public Date getDateLivraison() {
		return dateLivraison;
	}

	public void setDateLivraison(Date dateLivraison) {
		this.dateLivraison = dateLivraison;
	}

	@Override
	public String toString() {
		return "Cargaison [idReference=" + idReference + ", distance=" + distance + ", dateLivraison=" + dateLivraison
				+ "]";
	}

}
