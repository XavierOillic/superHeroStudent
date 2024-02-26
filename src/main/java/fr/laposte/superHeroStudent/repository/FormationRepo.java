package fr.laposte.superHeroStudent.repository;

import org.springframework.data.repository.CrudRepository;

import fr.laposte.superHeroStudent.model.Formation;

public interface FormationRepo extends CrudRepository<Formation, Long> {

}
