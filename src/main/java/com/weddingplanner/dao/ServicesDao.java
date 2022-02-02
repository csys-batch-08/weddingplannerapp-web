package com.weddingplanner.dao;

import java.util.List;

import com.weddingplanner.model.Services;

public interface ServicesDao {
	public List<Services> showServices();

	public void insertService(Services service);

	public double findPackage(int serviceId);

	public int updateRatingProfile(int ratings);

	public int findServiceId(String serviceName);

	public Services allService(String serviceName);

	public void updateServiceAvailability(String availability);

	public void updateService(Services service);

	public List<Services> showServiceType();

	public List<Services> showServiceList(String serviceType);

	public List<Services> filterByPrice(Double servicePackage);

}
