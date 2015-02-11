package com.geoblink.beans;

public class GeoblinkStoreBean {

	private int id;

	private String nameStore;

	private String city;

	private String longitude;

	private String latitude;

	private String telephone;

	private String sales;

	public GeoblinkStoreBean() {
	}

	public GeoblinkStoreBean(int id) {
		this.id = id;
	}

	public GeoblinkStoreBean(int id, String name, String city) {
		this.id = id;
		this.nameStore = name;
		this.city = city;

	}

	public GeoblinkStoreBean(String name, String city, String latitude,
			String longitude, String telephone, String sales) {
		this.nameStore = name;
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

	public String toString() {
		return String
				.format("GeoblinkStoreBean[id=%d, Name='%s', City='%s', Longitude='%s', Latitude='%s', Telephone='%s', Sales:'%10.2f' ]",
						id, nameStore, city, longitude, latitude, telephone, sales);
	}

	public GeoblinkStoreBean copyFrom(GeoblinkStoreBean store) {
		if (store.nameStore != null) {
			this.nameStore = store.nameStore;
		}
		if (store.city != null) {
			this.city = store.city;
		}
		if (store.latitude != null) {
			this.latitude = store.latitude;
		}
		if (store.longitude != null) {
			this.longitude = store.longitude;
		}
		if (store.telephone != null) {
			this.telephone = store.telephone;
		}
		if (store.sales != null) {
			this.sales = store.sales;
		}
		return this;
	}

	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}
		if (!(object instanceof GeoblinkStoreBean)) {
			return false;
		}
		GeoblinkStoreBean store = (GeoblinkStoreBean) object;

		return !((Integer)id != null ? !((Integer)id).equals(store.id)
				: ((Integer)store.id) != null)
				&& !(nameStore != null ? !nameStore.equals(store.nameStore)
						: store.nameStore != null)
				&& !(city != null ? !city.equals(store.city)
						: store.city != null)
				&& !(longitude != null ? !longitude.equals(store.longitude)
						: store.longitude != null)
				&& !(latitude != null ? !latitude.equals(store.latitude)
						: store.latitude != null)
				&& !(telephone != null ? !telephone.equals(store.telephone)
						: store.telephone != null)
				&& !(sales != null ? !sales.equals(store.sales)
						: store.sales != null);

	}

	public int hashCode() {
		int result = ((Integer)id) != null ? ((Integer)id).hashCode() : 0;
		result = 31 * result + (nameStore != null ? nameStore.hashCode() : 0);
		result = 31 * result + (city != null ? city.hashCode() : 0);
		result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
		result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
		result = 31 * result + (telephone != null ? telephone.hashCode() : 0);
		result = 31 * result + (sales != null ? sales.hashCode() : 0);
		return result;
	}

}
