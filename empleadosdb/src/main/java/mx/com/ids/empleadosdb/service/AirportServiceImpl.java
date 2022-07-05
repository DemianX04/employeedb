package mx.com.ids.empleadosdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.model.Airport;
import mx.com.ids.empleadosdb.repository.AirportRepository;

@Service
public class AirportServiceImpl implements AirportService {

	@Autowired
	AirportRepository airportR;

	@Override
	public List<Airport> FindAll() {
		return (List<Airport>) airportR.findAll();
	}

	@Override
	public void Save(Airport airport) {
		airportR.save(airport);
	}

	@Override
	public Airport FindById(Long id) {
		
		return airportR.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		airportR.deleteById(id);
	}
	
	
}
