package fr.laposte.superHeroStudent.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class DossierAdmin {
	
	@Id
	private Long id;
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	
	@OneToOne
	Avenger avenger;
	
	private String nom;
	private String email;

}

