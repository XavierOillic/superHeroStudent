package fr.laposte.superHeroStudent.repository;

import org.springframework.data.repository.CrudRepository;

import fr.laposte.superHeroStudent.model.Avenger;

public interface AvengerRepo extends CrudRepository<Avenger, Long>{

}
