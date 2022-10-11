package com.adn.models;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
@Data
@Getter
@Setter
public class Estadistica {

	private double contador_clon_adn;
	private double contador_amigos_adn;
	private double promedio;

//	public Estadistica(double cont_clon_adn, double cont_amigo_adn, double promedio) {
//		super();
//		this.cont_clon_adn = cont_clon_adn;
//		this.cont_amigo_adn = cont_amigo_adn;
//		this.promedio = promedio;
//	}

}
