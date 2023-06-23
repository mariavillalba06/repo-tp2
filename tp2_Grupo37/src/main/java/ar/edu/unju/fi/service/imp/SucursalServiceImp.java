package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Sucursal;
import ar.edu.unju.fi.listas.ListaSucursal;
import ar.edu.unju.fi.service.ISucursalService;
import jakarta.validation.Valid;

@Service
public class SucursalServiceImp implements ISucursalService{
	
	@Autowired
	private ListaSucursal listasucursal;
	
	@Autowired
	private Sucursal sucursal;
	

	@Override
	public List<Sucursal> getLista() {
		return listasucursal.getSucursales();
	}

	@Override
	public void guardar(@Valid Sucursal sucursal) {
		listasucursal.getSucursales().add(sucursal);
		
	}

	@Override
	public Sucursal getBy(String nombre) {
		Sucursal sucursalEncontrada = null;
		for(Sucursal sucu : listasucursal.getSucursales()) {
			if(sucu.getNombre().equals(nombre)) {
				sucursalEncontrada=sucu;
				break;
			}
		}
		return sucursalEncontrada;
	}

	@Override
	public void modificar(Sucursal sucursal) {
		for(Sucursal sucu : listasucursal.getSucursales()) {
			if(sucu.getNombre().equals(sucursal.getNombre())) {
				sucu.setDireccion(sucursal.getDireccion());
				sucu.setEmail(sucursal.getEmail());
				sucu.setFechaInicio(sucursal.getFechaInicio());
				sucu.setProvincia(sucursal.getProvincia());
				sucu.setTelefono(sucursal.getTelefono());
				}
		}
	}

	@Override
	public void eliminar(Sucursal sucursal) {
		listasucursal.getSucursales().remove(sucursal);
		
	}

	@Override
	public Sucursal getSucursal() {
		// TODO Auto-generated method stub
		return sucursal;
	}

}
