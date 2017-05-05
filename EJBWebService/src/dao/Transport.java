package dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import metier.Cargaison;
import metier.Marchandise;

@Stateless
public class Transport implements ITransportLocal {

	@PersistenceContext(name = "bddcargaison-pu")
	private EntityManager em;

	@Override
	public void addCargaison(Cargaison c) {
		em.persist(c);
	}

	@Override
	public void addMarchandise(Marchandise m, long refCargaison) {
		Cargaison c = em.find(Cargaison.class, refCargaison);
		Collection<Marchandise> col = new ArrayList<Marchandise>();
		col.add(m);
		c.setMesMarchandises(col);
		m.setMaCargaison(c);
		em.persist(c);
	}

	@Override
	public List<Cargaison> getAllCargaison() {
		Query q = em.createQuery("SELECT c FROM Cargaison c");
		return q.getResultList();
	}

	@Override
	public List<Marchandise> getMarchandiseParMC(String mc) {
		Query q = em.createQuery("SELECT m FROM Marchandise m WHERE m.nom LIKE ?");
		q.setParameter(1, "%"+mc+"%");
		return q.getResultList();
	}

	@Override
	public void deleteMarchandise(long refMarchandise) {
		Marchandise m = em.find(Marchandise.class, refMarchandise);
		em.remove(m);
	}

}
