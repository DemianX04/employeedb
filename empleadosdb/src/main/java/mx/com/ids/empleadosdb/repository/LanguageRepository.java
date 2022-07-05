package mx.com.ids.empleadosdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.ids.empleadosdb.model.Language;

@Repository
public interface LanguageRepository  extends CrudRepository<Language, Long> {

}
