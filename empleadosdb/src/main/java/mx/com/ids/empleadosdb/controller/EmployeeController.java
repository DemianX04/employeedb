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
import mx.com.ids.empleadosdb.model.Employee;
import mx.com.ids.empleadosdb.service.EmployeeService;

@RestController
@RequestMapping("/Employes")
public class EmployeeController {
	
	@Autowired
	EmployeeService employeS;
	
	@GetMapping("/listaempleados")
	public ResponseEntity<?> listarEmpleados(){
		List<Employee> listaEmpleados = employeS.FindAll();
		
		if (listaEmpleados.isEmpty()) {
			return new ResponseEntity<>(new Mensaje("Sin productos en la base de datos"), HttpStatus.BAD_REQUEST);
		}
		return ResponseEntity.ok().body(employeS.FindAll());
	}
	
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<Employee> empleadoPorId(@PathVariable("id") long id) {
		return ResponseEntity.ok().body(employeS.FindById(id));
	}
	
	
	@DeleteMapping("/borrar/{id}")
	public HttpStatus borrarEmpleado(@PathVariable("id") long id) {
		this.employeS.Delete(id);
		return HttpStatus.OK;
	}
	
	@PutMapping("/actualizarproducto/{id}")
	public ResponseEntity<Employee> updateProduct(@PathVariable long id,@RequestBody Employee empleado){
		empleado.setId(id);
		return ResponseEntity.ok().body(this.employeS.update(empleado));
	}
	
	@PostMapping("/registrarempleado")
	public ResponseEntity<Employee> createEmploye(@RequestBody Employee empleado){
		return ResponseEntity.ok().body(this.employeS.Save(empleado));
	}
	
}
