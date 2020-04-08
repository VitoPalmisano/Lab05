package it.polito.tdp.anagrammi.model;

import java.util.List;
import java.util.Map;
import java.util.Set;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {

	DizionarioDAO diz;
	RicercaAnagrammi ric;
	
	public Model() {
		diz = new DizionarioDAO();
		ric = new RicercaAnagrammi();
	}

	public boolean isCorrect(String anagramma) {
		return diz.isCorrect(anagramma);
	}

	public List<Parola> getAnagrammi(String parola, boolean onlyCorrect) {
		List<Parola> anagrammi = ric.getAnagrammi(parola, onlyCorrect);
		return anagrammi;
	}

	public boolean esisteCorrispondenza(String parziale) {
		return diz.esisteCorrispondenza(parziale);
	}
}
