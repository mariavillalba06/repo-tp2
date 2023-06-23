package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Empleado;
import ar.edu.unju.fi.repository.IEmpleadoRepository;
import ar.edu.unju.fi.service.IEmpleadoService;

@Service
public class EmpleadoServiceImp implements IEmpleadoService{
	
	@Autowired
	private IEmpleadoRepository empleadoRepository;
	
	@Autowired
	private Empleado empleado;

	/**
	 * Guarda un nuevo empleado.
	 * @param objeto de tipo Empleado a guardar.
	 */
	@Override
	public void guardarEmpleado(Empleado empleado) {
		empleado.setEstado(true);
		empleadoRepository.save(empleado);
	}

	/**
	 * Obtiene una lista de todos los empleados activos.
	 * @return lista de empleados activos.
	 */
	@Override
	public List<Empleado> getListaEmpleados() {
		return empleadoRepository.findByEstado(true);
	}

	/**
	 * Busca un empleado por su ID.
	 * @param id del empleado a buscar.
	 * @return objeto de tipo Empleado encontrado.
	 */
	@Override
	public Empleado findEmpleadoById(Long id) {
		empleado = empleadoRepository.findById((long) id).get();
		return empleado;
	}

	/**
	 * Crea un nuevo objeto Empleado.
	 * @return objeto de tipo Empleado inicializado.
	 */
	@Override
	public Empleado nuevoEmpleado() {
		return new Empleado();
	}

	/**
	 * Elimina un empleado.
	 * @param objeto de tipo Empleado a eliminar.
	 */
	@Override
	public void eliminarEmpleado(Empleado empleado) {
		empleado.setEstado(false);
		empleadoRepository.save(empleado);
	}

	/**
	 * Modifica un empleado existente.
	 * @param objeto de tipo Empleado a modificar.
	 */
	@Override
	public void modificarEmpleado(Empleado empleado) {
		empleado.setEstado(true);
		empleadoRepository.save(empleado);
	}

}
