package it.polito.tdp.anagrammi.DAO;

public class TestDB {

	public static void main(String[] args) {

		DizionarioDAO diz = new DizionarioDAO();
		
		System.out.println(diz.isCorrect("abachi"));

	}

}
