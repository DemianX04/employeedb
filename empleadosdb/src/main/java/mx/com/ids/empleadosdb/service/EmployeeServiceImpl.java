package mx.com.ids.empleadosdb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.com.ids.empleadosdb.exception.ResourceNotFoundException;

import mx.com.ids.empleadosdb.model.Employee;
import mx.com.ids.empleadosdb.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public List<Employee> FindAll() {

		return (List<Employee>) employeeRepository.findAll();
	}

	@Override
	public Employee Save(Employee empleado) {
		return employeeRepository.save(empleado);
		
	}

	@Override
	public Employee FindById(Long id) {
		return employeeRepository.findById(id).orElse(null);
	}

	@Override
	public void Delete(Long id) {
		employeeRepository.deleteById(id);
	}

	@Override
	public Employee update(Employee empleado) {
		Optional<Employee> employeeDb = this.employeeRepository.findById(empleado.getId());
		
		if(employeeDb.isPresent()) {
			Employee employeeUpdate = employeeDb.get();
			employeeUpdate.setId(empleado.getId());
			employeeUpdate.setSurname(empleado.getSurname());
			employeeUpdate.setFirstname(empleado.getFirstname());
			return employeeUpdate;
		}else {
			throw new ResourceNotFoundException("Record not found whit id: " + empleado.getId());
		}
	}

}
