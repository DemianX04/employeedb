package mx.com.ids.empleadosdb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.com.ids.empleadosdb.model.Airport;

@Repository
public interface AirportRepository extends CrudRepository<Airport, String> {

}
