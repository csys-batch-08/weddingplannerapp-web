package com.weddingplanner.model;

import java.io.Serializable;
import java.util.Objects;

public class Venues implements Serializable {

	private static final long serialVersionUID = 1L;
	private String venueName;
	private String venueArea;
	private String venueCity;
	private String venueType;
	private String venueVendorName;
	private long contactNumber;
	private double venuePackage;
	private String availability;
	private String venueImages;
	private int venueId;
	private String venueDescription;

	public String getVenueName() {
		return venueName;
	}

	public void setVenueName(String venueName) {
		this.venueName = venueName;
	}

	public String getVenueArea() {
		return venueArea;
	}

	public void setVenueArea(String venueArea) {
		this.venueArea = venueArea;
	}

	public String getVenueCity() {
		return venueCity;
	}

	public void setVenueCity(String venueCity) {
		this.venueCity = venueCity;
	}

	public String getVenueType() {
		return venueType;
	}

	public void setVenueType(String venueType) {
		this.venueType = venueType;
	}

	public String getVenueVendorName() {
		return venueVendorName;
	}

	public void setVenueVendorName(String venueVendorName) {
		this.venueVendorName = venueVendorName;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public double getVenuePackage() {
		return venuePackage;
	}

	public void setVenuePackage(double venuePackage) {
		this.venuePackage = venuePackage;
	}

	public String getAvailability() {
		return availability;
	}

	public void setAvailability(String availability) {
		this.availability = availability;
	}

	public String getVenueImages() {
		return venueImages;
	}

	public void setVenueImages(String venueImages) {
		this.venueImages = venueImages;
	}

	
	
	
	public int getVenueId() {
		return venueId;
	}

	public void setVenueId(int venueId) {
		this.venueId = venueId;
	}
	

	public String getVenueDescription() {
		return venueDescription;
	}

	public void setVenueDescription(String venueDescription) {
		this.venueDescription = venueDescription;
	}

	public Venues(String venueName, String venueArea, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage, String availability, String venueImages) {
		super();
		this.venueName = venueName;
		this.venueArea = venueArea;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.availability = availability;
		this.venueImages = venueImages;
	}
	

	public Venues(String venueName, String venueArea, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage, String venueImages, int venueId) {
		super();
		this.venueName = venueName;
		this.venueArea = venueArea;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.venueImages = venueImages;
		this.venueId = venueId;
	}

	
	
	
     
	public Venues(String venueName, String venueArea, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage, String availability, String venueImages, String venueDescription) {
		super();
		this.venueName = venueName;
		this.venueArea = venueArea;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.availability = availability;
		this.venueImages = venueImages;
		this.venueDescription = venueDescription;
	}
	

	public Venues(String venueName, String venueType, String venueVendorName, long contactNumber, double venuePackage,
		 String venueImages, int venueId, String venueDescription) {
		super();
		this.venueName = venueName;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.venueImages = venueImages;
		this.venueId = venueId;
		this.venueDescription = venueDescription;
	}

	public Venues() {
		super();
		
	}
	

	public Venues(String venueName, String venueArea, String venueCity, String venueType, String venueVendorName,
			long contactNumber, double venuePackage, String availability, String venueImages, int venueId,
			String venueDescription) {
		super();
		this.venueName = venueName;
		this.venueArea = venueArea;
		this.venueCity = venueCity;
		this.venueType = venueType;
		this.venueVendorName = venueVendorName;
		this.contactNumber = contactNumber;
		this.venuePackage = venuePackage;
		this.availability = availability;
		this.venueImages = venueImages;
		this.venueId = venueId;
		this.venueDescription = venueDescription;
	}

	@Override
	public String toString() {
		return "Venues [venueName=" + venueName + ", venueArea=" + venueArea + ", venueCity=" + venueCity
				+ ", venueType=" + venueType + ", venueVendorName=" + venueVendorName + ", contactNumber="
				+ contactNumber + ", venuePackage=" + venuePackage + ", availability=" + availability + ", venueImages="
				+ venueImages + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(availability, contactNumber, venueArea, venueCity, venueImages, venueName, venuePackage,
				venueType, venueVendorName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Venues other = (Venues) obj;
		return Objects.equals(availability, other.availability) && contactNumber == other.contactNumber
				&& Objects.equals(venueArea, other.venueArea) && Objects.equals(venueCity, other.venueCity)
				&& Objects.equals(venueImages, other.venueImages) && Objects.equals(venueName, other.venueName)
				&& Double.doubleToLongBits(venuePackage) == Double.doubleToLongBits(other.venuePackage)
				&& Objects.equals(venueType, other.venueType) && Objects.equals(venueVendorName, other.venueVendorName);
	}

}
