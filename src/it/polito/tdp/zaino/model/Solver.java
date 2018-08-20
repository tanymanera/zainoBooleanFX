package it.polito.tdp.zaino.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import it.polito.tdp.zaino.model.Pezzo;

public class Solver {

	private Zaino zaino ;
	
	private int numCalls = 0 ;


	/**
	 * Inizializza un nuovo problema dello zaino
	 */
	public Solver(Zaino z) {
		this.zaino = z ;
	}


	/**
	 * calcola il costo/valore del contenuto corrente dello zaino
	 * 
	 * @param parziale contenuto attuale dello zaino
	 * @return costo/valore del contenuto
	 */
	private int costo(boolean[] parziale) {
		int result = 0;
		for (int i = 0; i < zaino.getPezzi().size(); i++) {
			if (parziale[i]) {
				Pezzo p = zaino.getPezzi().get(i);
				result += p.getCosto();
			}
		}
		return result;
	}
	
	private int peso(boolean[] parziale) {
		int result = 0;
		for (int i = 0; i < zaino.getPezzi().size(); i++) {
			if (parziale[i]) {
				Pezzo p = zaino.getPezzi().get(i);
				result += p.getPeso();
			}
		}
		return result;
	}

	private void scegli(boolean[] parziale, int livello, boolean[] best) {
		// E -- sequenza di istruzioni che vengone eseguite sempre
		// da usare solo in casi rari, stampe di prova
		
		numCalls++ ;

		/**
		 * //A if(condizione di terminazione){ doSomething(); return;
		 * 
		 * for()/while() { //B genera nuova soluzione parziale
		 * 
		 * if(filtro){//C scegliPezzo(..., level+1, ...); }
		 * 
		 * // D backtraking; }
		 */

		if (costo(parziale) > costo(best)) {
			System.arraycopy(parziale, 0, best, 0, parziale.length);
		}

		while (livello < zaino.getPezzi().size()) {
			parziale[livello] = true;
			if (peso(parziale) <= zaino.getCapienza()) {

				scegli(parziale, livello + 1, best);
			}
			parziale[livello] = false;
			livello++;
		}
	}

	public Set<Pezzo> risolvi() {
		numCalls = 0;
		
		boolean[] parziale = new boolean[zaino.getPezzi().size()];
		Arrays.fill(parziale, Boolean.FALSE);
		boolean[] best = new boolean[zaino.getPezzi().size()];
		Arrays.fill(best, Boolean.FALSE);
		scegli(parziale, 0, best);
		Set<Pezzo> result = new HashSet<>();
		for(int i=0; i < best.length; i++) {
			if(best[i]) {
				result.add(zaino.getPezzi().get(i));
			}
		}
		return result;
	}
	
	public int getNumCalls() {
		return numCalls;
	}


	public static void main(String[] args) {

		Zaino z = new Zaino("Prova", 15);
		z.add(new Pezzo(12, 4, "Verde"));
		z.add(new Pezzo(2, 2, "Azzurro"));
		z.add(new Pezzo(1, 1, "Salmone"));
		z.add(new Pezzo(4, 10, "Giallo"));
		z.add(new Pezzo(1, 2, "Grigio"));
		
		Solver s = new Solver(z) ;

		Set<Pezzo> soluzione = s.risolvi();

		System.out.println(soluzione);
		System.out.println(s.getNumCalls()+ " chiamate");


	}




}
