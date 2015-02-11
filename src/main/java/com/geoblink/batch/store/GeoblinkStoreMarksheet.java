package com.geoblink.batch.store;

public class GeoblinkStoreMarksheet {

	private int id;

	private String nameStore;

	private String city;

	private String longitude;

	private String latitude;

	private String telephone;

	private String sales;

	public GeoblinkStoreMarksheet() {
	}

	public GeoblinkStoreMarksheet(String nameStore, String city, String latitude,
			String longitude, String telephone, String sales) {
		this.nameStore = nameStore;
		this.city = city;
		this.latitude = latitude;
		this.longitude = longitude;
		this.telephone = telephone;
		this.sales = sales;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNameStore() {
		return this.nameStore;
	}

	public void setNameStore(String name) {
		this.nameStore = name;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;

	}

	public String getSales() {
		return sales;
	}

	public void setSales(String sales) {
		this.sales = sales;
	}

}
