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
import mx.com.ids.empleadosdb.model.Airport;
import mx.com.ids.empleadosdb.service.AirportService;

@RestController
@RequestMapping("/Aereopuertos")
public class AirportController {
	
	@Autowired
	AirportService airportS;
	
	@GetMapping("/airportlist")
	public ResponseEntity<?> airportList(){
		List<Airport> listaA = airportS.FindAll();
		if (listaA.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin Aereopuertos en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(airportS.FindAll());
	}
	
	
	@GetMapping("/airport/{id}")
	public ResponseEntity<Airport> airportById(@PathVariable("id") String id) {
		return ResponseEntity.ok().body(airportS.FindById(id));
	}
	
	
	@DeleteMapping("/deleteAirport/{id}")
	public HttpStatus deleteAirport(@PathVariable("id") String id) {
		this.airportS.Delete(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/updateAirport/{id}")
	public ResponseEntity<Airport> updateAirport(@PathVariable String id,@RequestBody Airport air){
		air.setName(id);
		return ResponseEntity.ok().body(this.airportS.update(air));
	}
	
	@PostMapping("/saveAirport")
	public ResponseEntity<Airport> createAirport(@RequestBody Airport air){
		return ResponseEntity.ok().body(this.airportS.Save(air));
	}

}
