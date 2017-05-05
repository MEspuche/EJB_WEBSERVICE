package service;

import java.util.List;

import javax.ejb.Local;

import metier.Cargaison;
import metier.Marchandise;

@Local
public interface TransportSOAPServiceLocal {

	public void addCargaison (Cargaison c);
	public void addMarchandise(Marchandise m, long refCargaison);
	public List<Cargaison> getAllCargaison();
	public List<Marchandise> getMarchandiseParMC (String mc);
	public void deleteMarchandise (long refMarchandise);
}
