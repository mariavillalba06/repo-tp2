package ar.edu.unju.fi.service;

import java.time.LocalDate;
import java.util.List;

import ar.edu.unju.fi.entity.Sucursal;
import jakarta.validation.Valid;

public interface ISucursalService {
	
	//Lista de sucursales
	List<Sucursal> getLista();
	
	//Guardar un objeto Sucursal
	void guardar(@Valid Sucursal sucursal);
	
	//Obtener una sucursal por su Id
	Sucursal getById(Long id);
	
	//Modificar un objeto sucursal
	void modificar(Sucursal sucursal);
	
	//Eliminar un objeto Sucursal
	void eliminar(Sucursal sucursalEncontrada);
	
	//Obtener un objeto sucursal
	Sucursal getSucursal();
	
	//Filtrar por fecha de inicio y final
	List<Sucursal> filtroSucursal(LocalDate fechaInicio,LocalDate fechaFin);
}
