package fr.laposte.superHeroStudent;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import fr.laposte.superHeroStudent.model.Avenger;
import fr.laposte.superHeroStudent.model.Competences;
import fr.laposte.superHeroStudent.model.DossierAdmin;
import fr.laposte.superHeroStudent.model.Formation;
import fr.laposte.superHeroStudent.repository.AvengerRepo;
import fr.laposte.superHeroStudent.repository.CompetenceRepo;
import fr.laposte.superHeroStudent.repository.DossierAdminRepo;
import fr.laposte.superHeroStudent.repository.FormationRepo;

@SpringBootTest
class TestsRelationsAvecConstructor {
	
	private AvengerRepo avengers;
	private CompetenceRepo competences;
	private DossierAdminRepo dossierAdmin;
	private FormationRepo formation;
	
	public TestsRelationsAvecConstructor(AvengerRepo avengers, CompetenceRepo competences,DossierAdminRepo dossierAdmin, FormationRepo formation ) {
		
		this.avengers = avengers;
		this.competences = competences;
		this.dossierAdmin = dossierAdmin;
		this.formation = formation;
		
	}
	@BeforeEach
	void Cleaning () {
		
		dossierAdmin.deleteAll();
		avengers.deleteAll();
		competences.deleteAll();
		formation.deleteAll();
		
	}

	@Test
	void avecConstructor() {
		
		
		/*for (Avenger av : avengers.findAll()) {
			avengers.delete(av);
		}*/
		// ===========================> FORMATIONS
		Formation catchEnnemy = new Formation();
		catchEnnemy.setLibelle("Doc Oc");
		catchEnnemy.setLibelle("red Skull");
		formation.save(catchEnnemy);
		
		Formation killThanos = new Formation();
		killThanos.setLibelle("Thanos");
		formation.save(killThanos); 
		
		// ===============================> HEROS
		Avenger spiderman = new Avenger();
		spiderman.setFormation(catchEnnemy);
		spiderman.setPrenom("Peter");
		spiderman.setNom("Parker");
		avengers.save(spiderman);
		
		Avenger captainAmerica = new Avenger();
		captainAmerica.setFormation(catchEnnemy);
		captainAmerica.setPrenom("Steve");
		captainAmerica.setNom("Rogers");
		avengers.save(captainAmerica); 
		
		Avenger teamAvenger = new Avenger();
		teamAvenger.setFormation(killThanos);
		teamAvenger.setPrenom("The Avengers");
		teamAvenger.setNom("The Gathering");
		avengers.save(teamAvenger); 
		
		// =================================> DOSSIER ADMINISTRATIF
		DossierAdmin dossSpider = new DossierAdmin();
		dossSpider.setAvenger(spiderman);
		dossSpider.setEmail("spider@avenger.com");
		dossSpider.setNom("SpiderMan");
		dossierAdmin.save(dossSpider);
		
		DossierAdmin dossCaptain = new DossierAdmin();
		dossCaptain.setAvenger(captainAmerica);;
		dossCaptain.setEmail("captain@avenger.com");
		dossCaptain.setNom("Cap'tain America");
		dossierAdmin.save(dossCaptain);
		
		DossierAdmin dossAvenger = new DossierAdmin();
		dossAvenger.setAvenger(teamAvenger);;;
		dossAvenger.setEmail("team@avenger.com");
		dossAvenger.setNom("The Avengers, the Gathering");
		dossierAdmin.save(dossAvenger); 
		
		// =====================================> COMPETENCES
		Competences intelligence = new Competences();
		intelligence.setLibelle("Tactique");
		intelligence.setLibelle("LeaderShip");
		intelligence.setNiveau(100);
		competences.save(intelligence);
		
		Competences physique = new Competences();
		physique.setLibelle("Force");
		physique.setLibelle("Agilité");
		physique.setNiveau(100);
		competences.save(physique); 
		
		// =====================================> ASSOCIATIONS COMPETENCES - HEROS
		spiderman.getComp().add(intelligence);
		spiderman.getComp().add(physique);
		avengers.save(spiderman);
		
		captainAmerica.getComp().add(physique);
		captainAmerica.getComp().add(intelligence);
		avengers.save(captainAmerica);
		
		teamAvenger.getComp().add(physique);
		teamAvenger.getComp().add(intelligence);
		avengers.save(teamAvenger);
		
		
		for (Avenger a : avengers.findAll()) {
			System.out.println(a);
		}	
		
		
		

	}
}
