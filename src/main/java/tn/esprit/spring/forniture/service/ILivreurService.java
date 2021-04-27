package tn.esprit.spring.forniture.service;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.forniture.entity.Livreur;

public interface ILivreurService {
	public Livreur save(Livreur liv);
	public List <Livreur> findall();
	public void delete (long id );
	public Livreur updateLiv(Livreur Liv,long id);
	public Optional<Livreur> getById(long id);
	public Iterable<Livreur> findalll();
}
