package com.adn.test.adnRespository;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.adn.models.Adn;
import com.adn.repository.IAdnRepository;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AdnRepositoryUnitTest {

	@Autowired
	private IAdnRepository adnRepository;

	@Test
	@Rollback(false)
	public void test1_saveAdn() throws Exception {

		Adn adn = new Adn();
		adn.setAdn("WSEEWWEWWYEYEYWSSYYSYWEYWESSYYYEEEES");
		adn.setTipo(false);

		Adn savAdn = adnRepository.save(adn);
		assertNotNull(savAdn, "No se encontro datos ");
	}

	@Test
	public void test2_getAdn() throws Exception {

		List<Adn> listAdn = new ArrayList<Adn>();
		listAdn = adnRepository.findAll();
		assertNotNull(listAdn, "No se encontro datos ");
	}

	@Test
	public void test3_getEstadistica() throws Exception {

		Object[][] listObject = adnRepository.contAdn();
		assertNotNull(listObject, "No se encontro datos ");
	}

}
