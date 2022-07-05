package mx.com.ids.empleadosdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.model.Country;
import mx.com.ids.empleadosdb.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService {
	
	@Autowired
	CountryRepository countryR;

	@Override
	public List<Country> FindAll() {
		return (List<Country>) countryR.findAll();
	}

	@Override
	public void Save(Country country) {
		countryR.save(country);
	}

	@Override
	public Country FindById(Long id) {
		return countryR.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		countryR.deleteById(id);
	}

}
