package metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("AERIENNE")
public class CargaisonAerienne extends Cargaison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1990076051689277408L;
	private double poidsMax;

	public double getPoidsMax() {
		return poidsMax;
	}

	public void setPoidsMax(double poidsMax) {
		this.poidsMax = poidsMax;
	}

}
