package ar.edu.unju.fi.service;

import java.util.List;

import ar.edu.unju.fi.entity.Provincia;


public interface IProvinciaService {
	
	public void guardarProvincia(Provincia provincia);
	 
	public List<Provincia> getListaProvincias();
	
	public Provincia findProvinciaById(Long id);
	
	public void eliminarProvincia(Provincia provincia);
	
	void modificarProvincia(Provincia provincia);

	public Provincia nuevaProvincia();
}
