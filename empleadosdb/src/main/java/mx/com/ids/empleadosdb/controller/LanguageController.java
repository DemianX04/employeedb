package mx.com.ids.empleadosdb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ids.empleadosdb.exception.Mensaje;
import mx.com.ids.empleadosdb.model.Language;
import mx.com.ids.empleadosdb.service.LanguageService;

@RestController
@RequestMapping("/Languages")
public class LanguageController {
	
	@Autowired
	LanguageService languageS;
	
	@GetMapping("/languagelist")
	public ResponseEntity<?> languageList(){
		List<Language> listaL = languageS.FindAll();
		
		if (listaL.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin Lenguajes en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(languageS.FindAll());
	}
	
	
	@GetMapping("/language/{id}")
	public ResponseEntity<Language> languageById(@PathVariable("id") long codigo) {
		return ResponseEntity.ok().body(languageS.FindById(codigo));
	}
	
	
	@DeleteMapping("/deleteLanguage/{id}")
	public HttpStatus deleteLanguage(@PathVariable("id") long codigo) {
		this.languageS.Delete(codigo);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateLanguage/{id}")
	public ResponseEntity<Language> updateLanguage(@PathVariable long codigo,@RequestBody Language leng){
		leng.setCodigo(codigo);
		return ResponseEntity.ok().body(this.languageS.update(leng));
	}
	
	@PostMapping("/saveLanguage")
	public ResponseEntity<Language> createlanguage(@RequestBody Language leng){
		return ResponseEntity.ok().body(this.languageS.Save(leng));
	}
}
