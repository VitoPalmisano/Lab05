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
	private Set<Parola> soluzioni;
	
	public Set<Parola> getAnagrammi(String parola) {
		
		model = new Model();
		this.soluzioni = new HashSet<Parola>();
		
		parola = parola.toLowerCase();
		
		List<Character> charRestanti = new LinkedList<Character>();
		for(int i=0; i<parola.length(); i++) {
			charRestanti.add(parola.charAt(i));
		}
		
		this.cerca("", 0, charRestanti);
		
		return soluzioni;
	}
	
	private void cerca(String parziale, int livello, List<Character> charRestanti) {
		
		if(charRestanti.size()==0) {
			soluzioni.add(new Parola(parziale, model.isCorrect(parziale)));
		}
		
		for(Character ch : charRestanti) {
			String temp = parziale + ch;
			List<Character> disponibili = new LinkedList<>(charRestanti);
			disponibili.remove(ch);
			
			cerca(temp, livello+1, disponibili);
		}
	}
	
}
