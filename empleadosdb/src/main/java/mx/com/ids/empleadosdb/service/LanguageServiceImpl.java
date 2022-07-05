package mx.com.ids.empleadosdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.exception.ResourceNotFoundException;

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
	public Language Save(Language lenguaje) {
		return language.save(lenguaje);
	}

	@Override
	public Language FindById(Long id) {
		return language.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		language.deleteById(id);
	}

	@Override
	public Language update(Language lenguaje) {
		Optional<Language> lista = this.language.findById(lenguaje.getCodigo());
		
		if (lista.isPresent()) {
			Language languageU = lista.get();
			languageU.setId(lenguaje.getId());
			languageU.setCodigo(lenguaje.getCodigo());
			languageU.setLenguaje(lenguaje.getLenguaje());
			return languageU;
		}else {
			throw new ResourceNotFoundException("Record not found whit id: " + lenguaje.getId());
		}
	}
	
	
	
}
