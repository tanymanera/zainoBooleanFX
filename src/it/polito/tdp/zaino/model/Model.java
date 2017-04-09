package it.polito.tdp.zaino.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import it.polito.tdp.zaino.db.ZainoDAO;

public class Model {
	
	private List<Zaino> problemi ;
	private Zaino problemaCorrente = null ;
	
	// statistiche
	private int numCalls ;
	private long elapsedTime ;
	
	public Model() {
		ZainoDAO dao = new ZainoDAO() ;
		this.problemi = dao.listZaino() ;
	}

	public List<Zaino> getProblemi() {
		return problemi;
	}

	public Zaino getProblemaCorrente() {
		return problemaCorrente;
	}

	public int getNumCalls() {
		return numCalls;
	}

	public long getElapsedTime() {
		return elapsedTime;
	}

	public void selezionaZaino(Zaino z) {
		this.problemaCorrente = z ;
		
		ZainoDAO dao = new ZainoDAO() ;
		List<Pezzo> pezzi = dao.listPezzo(z) ;
		
		z.setPezzi(pezzi);
	}
	
	// variante con numero massimo di pezzi
	public void selezionaZaino(Zaino z, int maxPezzi) {
		this.problemaCorrente = z ;
		
		ZainoDAO dao = new ZainoDAO() ;
		List<Pezzo> pezzi = dao.listPezzo(z) ;
		
		z.setPezzi(new ArrayList<Pezzo>());
		int cnt = 0 ;
		for(Pezzo p: pezzi) {
			if(cnt>=maxPezzi)
				// ne ho già messi max
				break ;
			z.add(p);
			
			cnt++ ;
		}
	}


	public Set<Pezzo> solve() {
		Solver s = new Solver(this.problemaCorrente) ;
		
		long start = System.nanoTime() ;
		Set<Pezzo> soluzione = s.risolvi() ;
		long stop = System.nanoTime() ;
		this.numCalls = s.getNumCalls() ;
		this.elapsedTime = (stop-start)/1000000 ;
		
		return soluzione ;
	}
	
	

	
	
}
