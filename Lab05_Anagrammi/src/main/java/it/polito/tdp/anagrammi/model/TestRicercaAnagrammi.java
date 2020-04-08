package it.polito.tdp.anagrammi.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TestRicercaAnagrammi {

	public static void main(String[] args) {

		RicercaAnagrammi ric = new RicercaAnagrammi();
		
		List<Parola> lista = ric.getAnagrammi("cucuzza", false);
		
		for(Parola p : lista) {
			System.out.println(p);
		}
		
		List<Carattere> rim = new LinkedList<>();
		List<Carattere> usati = new ArrayList<>();
		
		Carattere a = new Carattere('a');
		Carattere b = new Carattere('b');
		Carattere c1 = new Carattere('c');
		Carattere c2 = new Carattere('c');
		Carattere c3 = new Carattere('c');
		
		c2.aumentaOrdine();
		
		rim.add(a);
		rim.add(b);
		usati.add(c1);
		rim.add(c2);
		rim.add(c3);
		
		System.out.println(usati.contains(c2));
		
		
	}

}
