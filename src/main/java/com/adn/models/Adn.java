package com.adn.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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

@Entity
@Table(name = "Adn")
public class Adn {
	@Id
	private String adn;
	private boolean tipo;

}
