package mx.com.ids.empleadosdb.service;

import java.util.List;
import mx.com.ids.empleadosdb.model.Employee;

public interface EmployeeService {

	public List<Employee> FindAll();
	Employee Save(Employee empleado);
	public Employee FindById(Long id);
	public void Delete(Long id);
	Employee update(Employee empleado);
	
}
