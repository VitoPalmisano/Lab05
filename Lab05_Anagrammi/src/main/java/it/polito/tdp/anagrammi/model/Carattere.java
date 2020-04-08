package it.polito.tdp.anagrammi.model;

public class Carattere {

	private char c;
	private int ordine;
	
	public Carattere(char c) {
		this.c = c;
		this.ordine = 0;
	}
	
	public void aumentaOrdine() {
		this.ordine++;
	}

	public int getOrdine() {
		return ordine;
	}

	public char getC() {
		return c;
	}

	@Override
	public String toString() {
		return c + ", ordine=" + ordine;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + c;
		result = prime * result + ordine;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Carattere other = (Carattere) obj;
		if (c != other.c)
			return false;
		if (ordine != other.ordine)
			return false;
		return true;
	}
	
	
}
