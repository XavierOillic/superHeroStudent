package fr.laposte.superHeroStudent.repository;

import org.springframework.data.repository.CrudRepository;

import fr.laposte.superHeroStudent.model.Competences;

public interface CompetenceRepo extends CrudRepository<Competences, Long>{
	/* Dans les Diamants, je ne met que des TYPE */
}
