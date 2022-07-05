package mx.com.ids.empleadosdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.exception.ResourceNotFoundException;
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
	public Airport Save(Airport airport) {
		return airportR.save(airport);
	}

	@Override
	public Airport FindById(String nombre) {
		
		return airportR.findById(nombre).orElse(null);
	}

	@Override
	public void Delete(String nombre) {
		airportR.deleteById(nombre);
	}

	@Override
	public Airport update(Airport airport) {
		Optional<Airport> lista = this.airportR.findById(airport.getName());
		
		if (lista.isPresent()) {
			Airport airportU = lista.get();
			airportU.setId(airport.getId());
			airportU.setName(airport.getName());
			return airportU;
		}else {
			throw new ResourceNotFoundException("Record not found whit id: " + airport.getId());
		}
	}
	
	
}
