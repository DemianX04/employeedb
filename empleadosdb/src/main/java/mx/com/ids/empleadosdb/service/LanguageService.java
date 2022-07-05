package mx.com.ids.empleadosdb.service;

import java.util.List;

import mx.com.ids.empleadosdb.model.Language;

public interface LanguageService {
	
	public List<Language> FindAll();
	public Language Save(Language lenguaje);
	public Language FindById(Long id);
	public void Delete(Long id);
	Language update(Language lenguaje); 
}
