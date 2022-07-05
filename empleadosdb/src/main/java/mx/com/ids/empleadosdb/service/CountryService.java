package mx.com.ids.empleadosdb.service;

import java.util.List;

import mx.com.ids.empleadosdb.model.Country;



public interface CountryService {

	public List<Country> FindAll();
	public void Save(Country country);
	public Country  FindById(Long id);
	public void Delete(Long id);
}
