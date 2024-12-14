package dao;

import java.util.ArrayList;
import java.util.List;

import model.Impiegato;
import model.Ruolo;

public interface RuoloDao {
	public Ruolo ricercaPerId(int id);

	public void inserisci(Ruolo i);

	public boolean aggiorna(Ruolo r2);

	public boolean elimina(int idRuolo);
}
