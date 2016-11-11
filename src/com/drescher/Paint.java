package com.drescher;

public class Paint {
	public int coveragePerGallon; //in sq feet
	public int pricePerGallon;
	public String sku;
	
	public Paint(int coveragePerGallon, int pricePerGallon, String sku) {
		this.coveragePerGallon = coveragePerGallon;
		this.pricePerGallon = pricePerGallon;
		this.sku = sku;
	}

	public int getCoveragePerGallon() {
		return coveragePerGallon;
	}

	public void setCoveragePerGallon(int coveragePerGallon) {
		this.coveragePerGallon = coveragePerGallon;
	}

	public int getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(int pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}	
}
