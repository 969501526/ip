package com.clj.model;

public class Position {
	
	private Integer id;
	
	private String country;//国家
	
	private String province;//省份
	
	private String city;//市
	
	private Double lat;//纬度,
	
	private Double lng;//经度
	
	private String ip;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}
	

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	@Override
	public String toString() {
		return "Position [id=" + id + ", country=" + country + ", province=" + province + ", city=" + city + ", lat="
				+ lat + ", lng=" + lng + "]";
	}
	
	

}
