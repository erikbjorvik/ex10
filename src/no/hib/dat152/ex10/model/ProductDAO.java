package no.hib.dat152.ex10.model;

import java.util.HashMap;

public class ProductDAO {
	
	private HashMap<Integer, Description> produktListe_no;
	private HashMap<Integer, Description> produktListe_en;
	private HashMap<Integer, Description> produktListe_es;
	private String language = "no"; //Setter no som standard språk
	
	
	/**
	 * Konstruktør som oppretter DAO-objekt med dummydata.
	 */
	public ProductDAO(String lang) {
		
		this.language = lang;
		
		//HashMapene representerer tabeller. En for hvert språk.
		produktListe_no = new HashMap<Integer, Description>();
		produktListe_en = new HashMap<Integer, Description>();
		produktListe_es = new HashMap<Integer, Description>();
		
		Description no1 = new Description(1, "Hvit kopp", 5.5, "", "no", "fin kopp!");
		this.produktListe_no.put(1, no1);
		
		Description no2 = new Description(2, "Sort kopp", 6.5, "", "no", "fin kopp!");
		this.produktListe_no.put(2, no2);
		
		Description no3 = new Description(3, "Gul kopp", 8.5, "", "no", "fin kopp!");
		this.produktListe_no.put(3, no3);
		
		Description en1 = new Description(1, "White Cup", 5.5, "", "en", "Nice white cup!");
		this.produktListe_en.put(1, en1);
		
		Description en2 = new Description(2, "Black cup", 6.5, "", "en", "Nice black cup!");
		this.produktListe_en.put(2, en2);
		
		Description en3 = new Description(3, "Yellow cup", 8.5, "", "en", "Nice yellow cup!");
		this.produktListe_en.put(3, en3);
		
		Description es1 = new Description(1, "copa blanco", 5.5, "", "es", "buena taza!");
		this.produktListe_es.put(1, es1);
		
		Description es2 = new Description(2, "copa negro", 6.5, "", "es", "buena taza!");
		this.produktListe_es.put(2, es2);
		
		Description es3 = new Description(3, "copa amarillo", 8.5, "", "es", "buena taza!");
		this.produktListe_es.put(3, es3);
		
	}
	
	public Description getDescriptionByPno(Integer pno) {
		
		switch (this.language) {
		
		}
		
		return this.produktListe.get(pno);
	}

}
