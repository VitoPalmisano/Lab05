package it.polito.tdp.anagrammi.model;

public class TestModel {

	public static void main(String[] args) {

		Model model = new Model();
		
		// System.out.println(model.isCorrect("abachii"));

		System.out.println(model.getAnagrammi("dog", true));
		
		System.out.println(model.getAnagrammi("gto", true));
		
		System.out.println(model.getAnagrammi("capra", true));
		
		System.out.println(model.getAnagrammi("mamma", true));
	}

}
