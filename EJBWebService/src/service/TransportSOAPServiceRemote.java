package service;

import java.util.List;

import javax.ejb.Remote;

import metier.Cargaison;
import metier.Marchandise;

@Remote
public interface TransportSOAPServiceRemote {

	public void addCargaison (Cargaison c);
	public void addMarchandise(Marchandise m, long refCargaison);
	public List<Cargaison> getAllCargaison();
	public List<Marchandise> getMarchandiseParMC (String mc);
	public void deleteMarchandise (long refMarchandise);
}
