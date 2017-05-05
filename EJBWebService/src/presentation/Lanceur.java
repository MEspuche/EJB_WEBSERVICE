package presentation;

import java.util.Date;

import javax.xml.ws.Endpoint;

import metier.CargaisonAerienne;
import metier.Marchandise;
import service.TransportSOAPService;
import service.TransportSOAPServiceLocal;

public class Lanceur {

	public static void main(String[] args) {
	
		//Création du serveur
//		String url = "http://localhost:8585/";
		
		//Publication du Web Service
//		Endpoint.publish(url,  new TransportSOAPService());
//		System.out.println(url);
		
		
		Marchandise m1 = new Marchandise();
		m1.setNom("Stylo");
		m1.setPoids(1.56);
		m1.setVolume(0.56);

		Marchandise m2 = new Marchandise();
		m2.setNom("Cahier");
		m2.setPoids(3.67);
		m2.setVolume(5.18);
		
		CargaisonAerienne cargaisonAerienne = new CargaisonAerienne();
		cargaisonAerienne.setDistance(500);
		cargaisonAerienne.setDateLivraison(new Date());
		cargaisonAerienne.setPoidsMax(1000);
//		cargaisonAerienne.getMesMarchandises().add(m1);
//		cargaisonAerienne.getMesMarchandises().add(m2);
		
		TransportSOAPService service = new TransportSOAPService();
		service.addCargaison(cargaisonAerienne);
		service.addMarchandise(m1, 1);
		service.addMarchandise(m2, 1);
	}

}
