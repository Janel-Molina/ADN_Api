package com.adn.services;

import com.adn.models.Estadistica;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
public interface IAdnService {

	/**
	 * Metodo validador que valida adn y guarda informacion
	 * @param adn
	 * @return boolean
	 * @throws Exception
	 */
	public boolean isClon(String[] adn) throws Exception;
	
	/**
	 * Metodo que calcula el promedio
	 * @return Estadistica
	 * @throws Exception
	 */
	public Estadistica calcularPromedio() throws Exception;
}
