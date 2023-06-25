package ar.edu.unju.fi.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.entity.Provincia;
import ar.edu.unju.fi.repository.IProvinciaRepository;
import ar.edu.unju.fi.service.IProvinciaService;

@Service
public class ProvinciaServiceImp implements IProvinciaService{
	
	@Autowired
	private IProvinciaRepository provinciaRepository;
	
	@Autowired
	private Provincia provincia;

	@Override
	public void guardarProvincia(Provincia provincia) {
		provincia.setEstado(true);
		provinciaRepository.save(provincia);
	}

	@Override
	public List<Provincia> getListaProvincias() {
		return provinciaRepository.findByEstado(true);
	}

	@Override
	public Provincia findProvinciaById(Long id) {
		provincia = provinciaRepository.findById(id).get();
		return provincia;
	}

	@Override
	public void eliminarProvincia(Provincia provincia) {
		provincia.setEstado(false);
		provinciaRepository.save(provincia);
	}

	@Override
	public void modificarProvincia(Provincia provincia) {
		provincia.setEstado(true);
		provinciaRepository.save(provincia);
	}

	@Override
	public Provincia nuevaProvincia() {
		return new Provincia();
	}
	
}
