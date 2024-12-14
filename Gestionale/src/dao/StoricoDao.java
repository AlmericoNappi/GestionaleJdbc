package dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.Impiegato;
import model.Storico;

public interface StoricoDao {
	public Storico ricercaPerId(int id);

	public void inserisci(Storico i);

	public boolean aggiorna(Storico st2);

	public boolean elimina(int id);

}
