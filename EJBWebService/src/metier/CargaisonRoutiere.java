package metier;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ROUTIERE")
public class CargaisonRoutiere extends Cargaison implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2768290059504477338L;
	private double temperatureCargaison;

	public double getTemperatureCargaison() {
		return temperatureCargaison;
	}

	public void setTemperatureCargaison(double temperatureCargaison) {
		this.temperatureCargaison = temperatureCargaison;
	}

	@Override
	public String toString() {
		return "CargaisonRoutiere [temperatureCargaison=" + temperatureCargaison + "]";
	}

}
