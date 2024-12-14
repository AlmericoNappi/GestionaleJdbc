package dao;

import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public class ImpiegatoDaoImpl implements ImpiegatoDao{

	private List<Impiegato> listaImpiegato = new ArrayList<>();
	
	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale) {
//		- ricercaPerCodiceFiscale, prende in ingresso un codice fiscale  cerca 
//		un impiegato, dentro listaImpiegato, con quel codice. Ritornare l'impiegato
//		cercato, altrimenti null.

		for (int i = 0; i < listaImpiegato.size(); i++) {
			Impiegato imp = listaImpiegato.get(i);
			if (imp.getCodiceFiscale().equals(codiceFiscale))
				return imp;
		}

		return null;
	}

	public void inserisci(Impiegato i) {
//		inserisci, prende in ingresso un'istanza i di Impiegato e l'aggiunge in 
//		listaImpiegato.
		listaImpiegato.add(i);
	}

	public boolean aggiorna(Impiegato imp2) {
//		- aggiorna,  prende in ingresso un'istanza i di Impiegato, la cerca, tramite
//		codice fiscale in listaImpiegato, e se la trova aggiorna il contenuto con l'istanza
//		i. Ritornare vero, se l'istanza è stata trovata.

		for (int i = 0; i < listaImpiegato.size(); i++) {
			Impiegato imp = listaImpiegato.get(i);
			if (imp.getCodiceFiscale().equals(imp2.getCodiceFiscale()))
			{
				imp.setCognome(imp2.getCognome());
				imp.setNome(imp2.getNome());
				imp.setMatricola(imp2.getMatricola());
				return true;
			}

			
		}

		return false;
	}

	public boolean elimina(String codiceFiscale) {
//	- elimina, prende in ingresso un codice fiscale e cerca, dentro listaImpiegato,
//	 un impiegato con quel codice fiscale. Se lo trova lo elimina. Ritorna vero se
//	 ha trovato un impiegato con quel codice.

		for (int i = 0; i < listaImpiegato.size(); i++) {
			Impiegato imp = listaImpiegato.get(i);
			if (imp.getCodiceFiscale().equals(codiceFiscale))
			{
				listaImpiegato.remove(i);
				return false;
			}
	
		}		
		return false;
	}

	public static void main(String[] args) {

		ImpiegatoDao impDao = new ImpiegatoDaoImpl();

		
		
		
		Impiegato imp = new Impiegato();
		imp.setCodiceFiscale("ggg");
		imp.setCognome("Pagano");
		imp.setNome("Antonio");
		imp.setMatricola(124);

		impDao.inserisci(imp);
		
//		Impiegato imp3 = new Impiegato();
//		imp3.setCodiceFiscale("ggg");
//		imp3.setCognome("Rossi");
//		imp3.setNome("Mario");
//		imp3.setMatricola(124);
//		
//		impDao.aggiorna(imp3);
		
		impDao.elimina("ggg");
		
		Impiegato res = impDao.ricercaPerCodiceFiscale("ggg");

		if (res != null)
			System.out.println("impiegato trovato:" + res.getCognome());
		else
			System.out.println("impiegato non trovato");
	}
}
