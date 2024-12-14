package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Storico;

public class StoricoDaoImpl implements StoricoDao{
	private List<Storico> listaStorici = new ArrayList<>();

	public Storico ricercaPerId(int id) {

		for (int i = 0; i < listaStorici.size(); i++) {
			Storico st = listaStorici.get(i);
			if (st.getIdStorico() == id)
				return st;
		}

		return null;
	}

	public void inserisci(Storico i) {

		listaStorici.add(i);
	}

	public boolean aggiorna(Storico st2) {
		for (int i = 0; i < listaStorici.size(); i++) {
			Storico st = listaStorici.get(i);
			if (st.getIdStorico() == st2.getIdStorico())
				{
					st.setDataFine(st2.getDataFine());
					st.setDataInizio(st2.getDataInizio());
					st.setIdRuolo(st2.getIdRuolo());
					st.setMatricola(st2.getMatricola());
					return true;
				}
		}
		return false;
	
	}

	public boolean elimina(int id) {


		for (int i = 0; i < listaStorici.size(); i++) {
			Storico st = listaStorici.get(i);
			if (st.getIdStorico() == id) {
				listaStorici.remove(i);
				return false;
			}
	
		}		
		return false;
	}

	public static void main(String[] args) {
		
		StoricoDao stDao = new StoricoDaoImpl();
		
		Storico s = new Storico();
		s.setDataFine(new Date());
		s.setDataInizio(new Date());
		s.setIdRuolo(1);
		s.setIdStorico(1);
		s.setMatricola(1);
		
		stDao.inserisci(s);
	
		Storico s1 = new Storico();
		s1.setDataFine(new Date());
		s1.setDataInizio(new Date());
		s1.setIdRuolo(1);
		s1.setIdStorico(1);
		s1.setMatricola(12);
		stDao.aggiorna(s1);
		
		stDao.elimina(1);
		
		Storico res = stDao.ricercaPerId(1);

		if (res != null)
			System.out.println("storico trovato:" + res.getMatricola());
		else
			System.out.println("storico non trovato");
	}
}
