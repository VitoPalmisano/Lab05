package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RicercaAnagrammi {

	Model model;
	private List<Parola> soluzioni;
	
	public List<Parola> getAnagrammi(String parola, boolean onlyCorrette) {

		model = new Model();
		this.soluzioni = new ArrayList<Parola>();
		
		List<Carattere>usati = new ArrayList<Carattere>();
		
		parola = parola.toLowerCase();
		
		List<Carattere> charRestanti = new ArrayList<Carattere>();
		for(int i=0; i<parola.length(); i++) {
			charRestanti.add(new Carattere(parola.charAt(i)));
		}
		
		for(int i = 0; i<charRestanti.size(); i++) {
			for(int j = i+1; j<charRestanti.size(); j++) {
				if(charRestanti.get(i).getC()==charRestanti.get(j).getC()) {
					charRestanti.get(j).aumentaOrdine();
				}
			}
		}
		
		if(!onlyCorrette)
			this.cerca("", 0, charRestanti, usati);
		else
			this.cercaOnlyCorrect("", 0, charRestanti, usati);
		
		return soluzioni;
	}
	
	private void cerca(String parziale, int livello, List<Carattere> charRestanti, List<Carattere> usati) {
		
		if(charRestanti.size()==0) {
			soluzioni.add(new Parola(parziale, model.isCorrect(parziale)));
		}
		
		boolean maggiore = false;
		
		for(Carattere c1 : charRestanti) {
			for(Carattere c2 : usati) {
				if(c1.getC()==c2.getC() && c2.getOrdine()>c1.getOrdine()) {
					maggiore = true;
				}
			}
			if(!maggiore) {
				String temp = parziale + c1.getC();
				List<Carattere> disponibili = new ArrayList<>(charRestanti);
				disponibili.remove(c1);
				List<Carattere> utilizzati = new ArrayList<>(usati);
				utilizzati.add(c1);
				
				cerca(temp, livello+1, disponibili, utilizzati);
			}
		}
	}
	
	public void cercaOnlyCorrect(String parziale, int livello, List<Carattere> charRestanti, List<Carattere> usati) {
		
		if(charRestanti.size()==0 && model.isCorrect(parziale)) {
			soluzioni.add(new Parola(parziale, true));
		}

		boolean maggiore = false;
		
		for(Carattere c1 : charRestanti) {
			for(Carattere c2 : usati) {
				if(c1.getC()==c2.getC() && c2.getOrdine()>c1.getOrdine()) {
					maggiore = true;
				}
			}
			if(!maggiore) {
				String temp = parziale + c1.getC();
				if(model.esisteCorrispondenza(temp)) {
					List<Carattere> disponibili = new ArrayList<>(charRestanti);
					disponibili.remove(c1);
					List<Carattere> utilizzati = new ArrayList<>(usati);
					utilizzati.add(c1);
					cercaOnlyCorrect(temp, livello+1, disponibili, utilizzati);
				}
			}
		}
	}
}
