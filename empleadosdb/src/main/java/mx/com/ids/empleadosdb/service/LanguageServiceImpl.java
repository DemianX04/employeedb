package mx.com.ids.empleadosdb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.model.Language;
import mx.com.ids.empleadosdb.repository.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	LanguageRepository language;

	@Override
	public List<Language> FindAll() {
		return (List<Language>) language.findAll();
	}

	@Override
	public void Save(Language lenguaje) {
		language.save(lenguaje);
	}

	@Override
	public Language FindById(Long id) {
		return language.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		language.deleteById(id);
	}
	
	
	
}
