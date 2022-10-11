package com.adn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adn.models.SecuenciaAdn;
import com.adn.services.IAdnService;
import com.adn.models.Estadistica;
import com.adn.util.Constantes;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
@RestController
@RequestMapping(path = "/")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE })
public class AdnControllers {

	@Autowired
	private IAdnService adnService;

	/**
	 * Endpoint que valida secuencia adn
	 * @param adnRequest
	 * @return boolean
	 * @throws Exception
	 */
	@PostMapping(path = "/clon/")
	public ResponseEntity<String> validacionAdn(@RequestBody SecuenciaAdn adnRequest) throws Exception {

		ResponseEntity<String> adnResponse;

		try {

			if (adnRequest.getAdn() != null) {

				String[] adn = adnRequest.getAdn().toArray(new String[0]);
				boolean isAdn = true;

				for (String secAdn : adn) {

					if (adn.length != secAdn.length() || !secAdn.matches(Constantes.SEC_ADN)) {
						isAdn = false;
						break;
					}
				}

				if (isAdn) {
					boolean isClon = adnService.isClon(adn);

					if (isClon) {
						adnResponse = new ResponseEntity<String>(HttpStatus.OK);
					} else {
						adnResponse = new ResponseEntity<String>(HttpStatus.FORBIDDEN);
					}

				} else {

					adnResponse = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
				}

			} else {
				adnResponse = new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
			}

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

		return adnResponse;
	}

	/**
	 * Endpoint que retorna las estadisticas de adn
	 * @return Estadistica
	 * @throws Exception
	 */
	@GetMapping(path = "/estadisticas")
	public ResponseEntity<?> getEstadisticas() throws Exception {

		Estadistica estadistica = new Estadistica();
		try {

			estadistica = adnService.calcularPromedio();

			return ResponseEntity.ok(estadistica);

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
		}

	}

}
