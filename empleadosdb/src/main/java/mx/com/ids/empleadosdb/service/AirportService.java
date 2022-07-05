package mx.com.ids.empleadosdb.service;

import java.util.List;

import mx.com.ids.empleadosdb.model.Airport;



public interface AirportService {
	
	public List<Airport> FindAll();
	public void Save(Airport airport);
	public Airport FindById(Long id);
	public void Delete(Long id);

}
