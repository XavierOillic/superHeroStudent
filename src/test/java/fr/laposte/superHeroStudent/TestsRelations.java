package fr.laposte.superHeroStudent;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.laposte.superHeroStudent.model.Avenger;
import fr.laposte.superHeroStudent.model.Competences;
import fr.laposte.superHeroStudent.model.DossierAdmin;
import fr.laposte.superHeroStudent.model.Formation;
import fr.laposte.superHeroStudent.repository.AvengerRepo;
import fr.laposte.superHeroStudent.repository.CompetenceRepo;
import fr.laposte.superHeroStudent.repository.DossierAdminRepo;
import fr.laposte.superHeroStudent.repository.FormationRepo;

public class TestsRelations {

	@Autowired 
	private AvengerRepo student;
	
	@Autowired
	private CompetenceRepo competence;
	
	@Autowired
	private DossierAdminRepo dossier;
	
	@Autowired
	private FormationRepo formation;
	
	@BeforeEach
	void Cleaning () {
		student.deleteAll();
		competence.deleteAll();
		dossier.deleteAll();
		formation.deleteAll();
	}
	@Test
	void freeTest() {
		//Création de la Session
		Formation cda = new Formation();
		cda.setLibelle("cda24");
		formation.save(cda);
		
		// Création des apprenants pour la session de formation
		Avenger hulk = new Avenger();
			hulk.setFormation(cda);
			hulk.setPrenom("Bruce");
			hulk.setNom("Banner");
		student.save(hulk);
		
		Avenger thor = new Avenger();
			thor.setFormation(cda);
			thor.setPrenom("Dieu");
			thor.setNom("Tonnerre");
		student.save(thor);
		
		DossierAdmin dossThor = new DossierAdmin();
			dossThor.setAvenger(thor);
			dossThor.setEmail("thor@avenger.com");
			dossThor.setNom("Thor");
		dossier.save(dossThor);
		
		DossierAdmin dossHulk = new DossierAdmin();
			dossHulk.setAvenger(hulk);
			dossHulk.setEmail("hulk@avenger.com");
			dossHulk.setNom("Bruce Banner");
		dossier.save(dossHulk);
		
		//Création des Compétences
		Competences tonnerre = new Competences();
			tonnerre.setLibelle("Foudre");
			tonnerre.setNiveau(1500);
		competence.save(tonnerre);
		
		Competences force = new Competences();
			force.setLibelle("Puissance");
			force.setNiveau(20000);
		competence.save(force);
		
		//Attribution de competences
		thor.getNewCompetence().add(tonnerre);
		thor.getNewCompetence().add(force);
		student.save(thor);
		
		hulk.getNewCompetence().add(force);
		student.save(hulk);
		
	}
	
	
}
