package mx.com.ids.empleadosdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.exception.ResourceNotFoundException;
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
	public Country Save(Country country) {
		return countryR.save(country);
	}

	@Override
	public Country FindById(Long id) {
		return countryR.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		countryR.deleteById(id);
	}

	@Override
	public Country update(Country pais) {
		Optional<Country> lista = this.countryR.findById(pais.getCodigo());
		
		if (lista.isPresent()) {
			Country countryU = lista.get();
			countryU.setId(pais.getId());
			countryU.setCodigo(pais.getCodigo());
			countryU.setNombre(pais.getNombre());
			return countryU;
		}else {
			throw new ResourceNotFoundException("Record not found whit id: " + pais.getId());
		}
	}

}
