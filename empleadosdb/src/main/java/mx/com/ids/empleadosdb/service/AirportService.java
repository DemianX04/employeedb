package mx.com.ids.empleadosdb.service;

import java.util.List;

import mx.com.ids.empleadosdb.model.Airport;



public interface AirportService {
	
	public List<Airport> FindAll();
	public Airport Save(Airport airport);
	public Airport FindById(String nombre);
	public void Delete(String nombre);
	Airport update(Airport airport);

}
