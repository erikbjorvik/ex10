package no.hib.dat152.ex10.model;

public class Product {
	private int pno;
	private double priceInEuro;
	private String imageFile;
	
	public Product() {
		this.pno = 0;
		this.priceInEuro = 0.0;
		this.imageFile = "";
	}
	
	public Product(Product produkt) {
		this.pno = produkt.getPno();
		this.priceInEuro = produkt.getPriceInEuro();
		this.imageFile = produkt.getImageFile();
	}
	
	public Product(int pno, double priceInEuro, String imageFile) {
		this.pno = pno;
		this.priceInEuro = priceInEuro;
		this.imageFile = imageFile;
	}
	
	public int getPno() {
		return pno;
	}
	
	public void setPno(int pno) {
		this.pno = pno;
	}
	public double getPriceInEuro() {
		return priceInEuro;
	}
	public void setPriceInEuro(double priceInEuro) {
		this.priceInEuro = priceInEuro;
	}
	public String getImageFile() {
		return this.imageFile;
	}
	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	
	
}
