package dao;

import java.util.ArrayList;
import java.util.List;

import model.Impiegato;

public interface ImpiegatoDao {

	public Impiegato ricercaPerCodiceFiscale(String codiceFiscale);

	public void inserisci(Impiegato i);

	public boolean aggiorna(Impiegato i);

	public boolean elimina(String codiceFiscale);

}
