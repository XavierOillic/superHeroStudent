package fr.laposte.superHeroStudent.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor

public class Avenger {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	
	private String prenom;
	private String nom;
	
	@ManyToOne /* Une eleve suit une seule formation, mais une formation contient plusieurs éléves */
	Formation formation; 

	@ManyToMany(fetch = FetchType.EAGER)
	//@Getter(value = AccessLevel.NONE)  ===> SECURISATION DE L'ACCES AUX DATAS
	//@Setter(value = AccessLevel.NONE)  ===> SECURISATION DE L'ACCES AUX DATAS
	private Set<Competences> comp = new HashSet<>(); /* Permet de faire un tableau sans aucuns DOUBLONS, pour avoir ici un table d'ASSO */
	
	/*public void addCompetences (Competences newCompetence) {
		comp.add(newCompetence);
	}
	public List<Competences> getNewCompetence(){
		return Collections.unmodifiableList(new ArrayList<>(comp));
	}*/ 
	//===> SECURISATION DE L'ACCES AUX DATAS
	

	
}
