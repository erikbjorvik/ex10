package no.hib.dat152.ex10.model;

import java.util.HashMap;

public class ProductDAO {
	
	private HashMap<Integer, Description> produktListe_no;
	private HashMap<Integer, Description> produktListe_en;
	private HashMap<Integer, Description> produktListe_es;
	
	private HashMap<Integer,Description> gjeldende; 
	
	
	/**
	 * Konstruktør som oppretter DAO-objekt med dummydata.
	 */
	public ProductDAO(String lang) {
		
		//HashMapene representerer tabeller. En for hvert språk.
		produktListe_no = new HashMap<Integer, Description>();
		produktListe_en = new HashMap<Integer, Description>();
		produktListe_es = new HashMap<Integer, Description>();
		
		Product hvitKopp = new Product(1, 5.5, "hvit-kopp.jpg");
		Product svartKopp = new Product(2, 6.5, "svart-kopp.jpg");
		Product gulKopp = new Product(3, 9.5, "gul-kopp.jpg");
		
		Description no1 = new Description(hvitKopp, "Hvit kopp", "no", "fin kopp!");
		this.produktListe_no.put(1, no1);
		
		Description no2 = new Description(svartKopp, "Svart kopp", "no", "fin kopp!");
		this.produktListe_no.put(2, no2);
		
		Description no3 = new Description(gulKopp, "Gul kopp", "no", "fin kopp!");
		this.produktListe_no.put(3, no3);
		
		Description en1 = new Description(hvitKopp, "White cup", "en", "Nice white cup!");
		this.produktListe_en.put(1, en1);
		
		Description en2 = new Description(svartKopp, "Black cup",  "en", "Nice black cup!");
		this.produktListe_en.put(2, en2);
		
		Description en3 = new Description(gulKopp, "Yellow kopp",  "en", "Nice yellow cup!");
		this.produktListe_en.put(3, en3);
		
		Description es1 = new Description(hvitKopp, "Blanco taza", "es", "buena taza!");
		this.produktListe_es.put(1, es1);
		
		Description es2 = new Description(svartKopp, "Negro taza", "es", "buena taza!");
		this.produktListe_es.put(2, es2);
		
		Description es3 = new Description(gulKopp, "Amarilla taza", "es", "buena taza!");
		this.produktListe_es.put(3, es3);
		
		//Setter gjeldende.
		switch (lang) {
		case "no":
			this.gjeldende = this.produktListe_no;
			break;
		case "en":
			this.gjeldende = this.produktListe_en;
			break;
		case "es":
			this.gjeldende = this.produktListe_es;
			break;
		default:
			this.gjeldende = this.produktListe_no;
			break;
		}
		
	}
	
	public Description getDescriptionByPno(Integer pno) {
		return this.gjeldende.get(pno);
	}
	
	public HashMap<Integer,Description> getMap() {
		return this.gjeldende;
	}

}
