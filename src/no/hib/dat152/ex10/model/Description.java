package no.hib.dat152.ex10.model;

public class Description extends Product {
	
	private String langCode;
	private String text;
	
	
	public Description() {
		super();
		this.langCode = "";
		this.text = "";
	}
	
	public Description(int pno, String pName, double priceInEuro, String imageFile, String langCode, String text) {
		super(pno,pName,priceInEuro,imageFile);
		this.langCode = langCode;
		this.text = text;
	}
	
	public String getLangCode() {
		return langCode;
	}
	public void setLangCode(String langCode) {
		this.langCode = langCode;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	
	
	
}
