package com.adn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.adn.models.Adn;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
public interface IAdnRepository extends JpaRepository<Adn, String> {
    /**
     * Consulta para contar los todos los registros de adn por tipo
     * @return Object[][]
     * @throws Exception
     */
	@Query(value = "select a.tipo, count(*) from Adn a group by a.tipo", nativeQuery = true)
	Object[][] contAdn() throws Exception;
}
