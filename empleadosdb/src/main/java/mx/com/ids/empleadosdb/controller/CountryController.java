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
import mx.com.ids.empleadosdb.model.Country;
import mx.com.ids.empleadosdb.service.CountryService;

@RestController
@RequestMapping("/country")
public class CountryController {

	@Autowired
	CountryService countryS;
	
	@GetMapping("/countrylist")
	public ResponseEntity<?> listCountry(){
		List<Country> listaEmpleados = countryS.FindAll();
		
		if (listaEmpleados.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin paises en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(countryS.FindAll());
	}
	
	
	@GetMapping("/country/{id}")
	public ResponseEntity<Country> countryById(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(countryS.FindById(id));
	}
	
	
	@DeleteMapping("/deleteCountry/{id}")
	public HttpStatus deleteCountry(@PathVariable("id") long id) {
		this.countryS.Delete(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/countryupdate/{id}")
	public ResponseEntity<Country> updateCountry(@PathVariable long id,@RequestBody Country pais){
		pais.setCodigo(id);
		return ResponseEntity.ok().body(this.countryS.update(pais));
	}
	
	@PostMapping("/savecountry")
	public ResponseEntity<Country> createCountry(@RequestBody Country pais){
		return ResponseEntity.ok().body(this.countryS.Save(pais));
	}
}
