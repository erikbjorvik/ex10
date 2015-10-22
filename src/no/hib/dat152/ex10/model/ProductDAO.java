package no.hib.dat152.ex10.model;

import java.util.HashMap;

public class ProductDAO {
	
	private HashMap<Integer, Description> produktListe;
	
	
	/**
	 * Konstruktør som oppretter DAO-objekt med dummydata.
	 */
	public ProductDAO() {
		produktListe = new HashMap<Integer, Description>();
		
		Description d1 = new Description(1, "Hvit kopp", 5.5, "", "no", "fin kopp!");
		this.produktListe.put(1, d1);
		
		Description d2 = new Description(2, "Sort kopp", 6.5, "", "no", "fin kopp!");
		this.produktListe.put(2, d2);
		
		Description d3 = new Description(3, "Gul kopp", 8.5, "", "no", "fin kopp!");
		this.produktListe.put(3, d3);
		
	}
	
	public Description getDescriptionByPno(Integer pno) {
		return this.produktListe.get(pno);
	}

}
