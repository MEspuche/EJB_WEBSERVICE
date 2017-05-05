package service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import dao.ITransportLocal;
import dao.Transport;
import metier.Cargaison;
import metier.Marchandise;

/**
 * Session Bean implementation class TransportSOAPService
 */
@WebService(serviceName="TransportWS")
@Stateless
public class TransportSOAPService implements TransportSOAPServiceRemote, TransportSOAPServiceLocal {

	@EJB
	ITransportLocal transport;
	
    /**
     * Default constructor. 
     */
    public TransportSOAPService() {
        // TODO Auto-generated constructor stub
    }

    @WebMethod
	@Override
	public void addCargaison(@WebParam(name="cargaison")Cargaison c) {
		transport.addCargaison(c);
		
	}

    @WebMethod
	@Override
	public void addMarchandise(@WebParam(name="marchandise")Marchandise m, @WebParam(name="refCargaison")long refCargaison) {
		transport.addMarchandise(m, refCargaison);
		
	}

    @WebMethod
	@Override
	public List<Cargaison> getAllCargaison() {
		return transport.getAllCargaison();
	}

    @WebMethod
	@Override
	public List<Marchandise> getMarchandiseParMC(@WebParam(name="motCle")String mc) {
		return transport.getMarchandiseParMC(mc);
	}

    @WebMethod
	@Override
	public void deleteMarchandise(@WebParam(name="refMarchandise")long refMarchandise) {
		transport.deleteMarchandise(refMarchandise);
		
	}

}
