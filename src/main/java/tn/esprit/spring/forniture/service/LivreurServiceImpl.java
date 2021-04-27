package tn.esprit.spring.forniture.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import tn.esprit.spring.forniture.entity.Furniture;
import tn.esprit.spring.forniture.entity.Livreur;
import tn.esprit.spring.forniture.repository.LivreurRepository;


@Service
public class LivreurServiceImpl implements ILivreurService {

	@Autowired
	LivreurRepository livreurRepository;

	private static final Logger L = LogManager.getLogger(ILivreurService.class);

	@Override
	public Livreur save(Livreur liv) {
		return livreurRepository.save(liv);
	}

	@Override
	public List<Livreur> findall() {
		List<Livreur> a = (List<Livreur>) livreurRepository.findAll();

		for (Livreur Livreurs : a) {
			L.info("Livreurs :" + Livreurs);

		}
		return a;

	}

	@Override
	public void delete(long id) {
		livreurRepository.deleteById(id);

	}

	@Override
	public Livreur updateLiv(Livreur Liv,long id) {
		
		Livreur fur=	livreurRepository.findById(id).get();
		Liv.setId(fur.getId());
		return livreurRepository.save(Liv);
	}
	

	@Override
	public Iterable<Livreur> findalll() {
		
		
		return livreurRepository.findAll();
	}
	
	@Override
	public Optional<Livreur> getById(long id) {
		
		return (Optional<Livreur>) livreurRepository.findById(id);
	}

}
