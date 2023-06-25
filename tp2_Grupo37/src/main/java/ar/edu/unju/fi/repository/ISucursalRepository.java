package ar.edu.unju.fi.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ar.edu.unju.fi.entity.Sucursal;

@Repository
public interface ISucursalRepository extends CrudRepository<Sucursal, Long>{
	
	public List<Sucursal> findByEstado(boolean estado);
	
	@Query("SELECT s FROM Sucursal s WHERE s.fechaInicio >= :fechaInicio AND s.fechaFin <= :fechaFin")
	List<Sucursal> buscarPorRangoFechas(@Param("fechaInicio") LocalDate fechaInicio, @Param("fechaFin") LocalDate fechaFin);
	
}
