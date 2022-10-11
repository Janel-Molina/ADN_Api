package com.adn.test.adnservice;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.adn.models.Estadistica;
//import com.adn.models.Estadistica;
import com.adn.services.IAdnService;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
@SpringBootTest
class AdnServiceUnitTest {

	@Autowired
	IAdnService adnService;

	@Test
	void test1_isClonTest() throws Exception {

		String[] adn = { "WSYEWW", "EWWYYE", "EYWSSW", "WSYWEY", "WESSYY", "YWEYSS" };
		assertEquals(adnService.isClon(adn), false);
	}
	
	@Test
	void test2_isClonTest() throws Exception {

		String[] adn = { "WSYEWW","EWWYYY","EYWSSY","WSYWEY","WESSYY","YEEEES" };
		assertEquals(adnService.isClon(adn), true);
	}

	@Test
	public void test3_calcularPromedioTest() throws Exception {
		
		Estadistica estadistica = new Estadistica();
		estadistica = adnService.calcularPromedio();
		assertNotNull(estadistica, "No se encontro datos ");
	}

}
