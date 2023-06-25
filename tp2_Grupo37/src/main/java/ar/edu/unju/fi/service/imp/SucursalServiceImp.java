package ar.edu.unju.fi.service.imp;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.repository.ISucursalRepository;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService{
	
	@Autowired
	private ISucursalRepository sucursalRepository;
	
	@Autowired
	private Sucursal sucursal;
	

	@Override
	public List<Sucursal> getLista() {
		return sucursalRepository.findByEstado(true);
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal getById(Long id) {
		sucursal = sucursalRepository.findById(id).get();
		return sucursal;
	}

	@Override
	public void modificar(Sucursal sucursal) {
		sucursal.setEstado(true);
		sucursalRepository.save(sucursal);
	}

	@Override
	public void eliminar(Sucursal sucursal) {
		sucursal.setEstado(false);
		sucursalRepository.save(sucursal);
	}

	@Override
	public Sucursal getSucursal() {
		return new Sucursal();
	}

	@Override
	public List<Sucursal> filtroSucursal(LocalDate fechaInicio,LocalDate fechaFin) {
		
		return sucursalRepository.buscarPorRangoFechas(fechaInicio,fechaFin);
	}
}
