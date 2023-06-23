package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Empleado;

public interface IEmpleadoService {
	
	public void guardarEmpleado(Empleado empleado);
	 
	public List<Empleado> getListaEmpleados();
	
	public Empleado findEmpleadoById(Long id);
	
	public void eliminarEmpleado(Empleado empleado);
	
	void modificarEmpleado(Empleado empleado);

	public Empleado nuevoEmpleado();
}
