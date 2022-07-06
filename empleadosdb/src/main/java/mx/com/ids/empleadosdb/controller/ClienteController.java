package mx.com.ids.empleadosdb.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.com.ids.empleadosdb.exception.Mensaje;
import mx.com.ids.empleadosdb.model.Airport;
import mx.com.ids.empleadosdb.model.Country;
import mx.com.ids.empleadosdb.model.Employee;
import mx.com.ids.empleadosdb.model.Language;
import mx.com.ids.empleadosdb.repository.AirportRepository;
import mx.com.ids.empleadosdb.repository.CountryRepository;
import mx.com.ids.empleadosdb.repository.EmployeeRepository;
import mx.com.ids.empleadosdb.repository.LanguageRepository;

@RestController
@RequestMapping("/Clientes")
public class ClienteController {

	@Autowired
	EmployeeRepository employeR;
	
	@Autowired
	CountryRepository conutryR;
	
	@Autowired
	LanguageRepository languageR;
	
	@Autowired
	AirportRepository airportR;
	
	
	@PostMapping("/apiv1/clientes/add")
	public ResponseEntity<?> addClient(@Valid @RequestBody Map<String,String> json, BindingResult result){
		if(result.hasErrors()){
            return new ResponseEntity<>(new Mensaje("Campos mal o email invalido"), HttpStatus.BAD_REQUEST);
        }
		
		Employee empleado = new Employee(json.get("firstname"),json.get("surname"));
		Country pais = new Country(json.get("nombre"));
		Airport aero = new Airport(json.get("aereopuerto"));
		Language leng = new Language(json.get("lenguaje"));
		airportR.save(aero);
		employeR.save(empleado);
		conutryR.save(pais);
		languageR.save(leng);
		
		
		
		return new ResponseEntity<>(new Mensaje("Empleado guardado"), HttpStatus.CREATED);
	}
}
