package com.adn.services;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.adn.models.Adn;
import com.adn.models.Estadistica;
import com.adn.repository.IAdnRepository;
/**
 * 
 * @author Janel Molina Gongora
 *
 */
@Service
public class AdnService implements IAdnService {

	@Autowired
	private IAdnRepository adnRepository;
	
	public boolean isClon(String[] adn) throws Exception {

		boolean isAdn;
		String matrizAdn[][] = new String[adn.length][adn[0].length()];
		Adn adnModel = new Adn();

		try {

			for (int i = 0; i < adn.length; i++) {
				for (int j = 0; j < adn[i].length(); j++) {

					matrizAdn[i][j] = String.valueOf(adn[i].charAt(j));

					System.out.print(matrizAdn[i][j] + " ");
				}
				System.out.println();
			}

			int contSecuencia = 0;

			for (int i = 0; i < matrizAdn.length; i++) {
				for (int j = 0; j < matrizAdn[i].length; j++) {

					// Validación Secuencia Diagonal arriba - abajo
					if (j < matrizAdn[i].length - 3 && i < matrizAdn[i].length - 3) {

						if (matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 1][j + 1])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 2][j + 2])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 3][j + 3])) {
							contSecuencia++;
						}
					}

					// Validación Secuencia Diagonal abajo - arriba
					if (i > 2 && j < matrizAdn[i].length - 3 && matrizAdn[i].length > 3) {

						if (matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i - 1][j + 1])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i - 2][j + 2])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i - 3][j + 3])) {
							contSecuencia++;
						}
					}

					// Validación Secuencia Horizontal
					if (j < matrizAdn[i].length - 3) {

						if (matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i][j + 1])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i][j + 2])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i][j + 3])) {

							contSecuencia++;
						}
					}

					// Validación Secuencia Vertical
					if (i < matrizAdn[i].length - 3) {

						if (matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 1][j])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 2][j])
								&& matrizAdn[i][j].equalsIgnoreCase(matrizAdn[i + 3][j])) {

							contSecuencia++;

						}
					}

				}

			}

			if (contSecuencia >= 2) {

				isAdn = true;
			} else {
				isAdn = false;
			}

			adnModel.setTipo(isAdn);
			adnModel.setAdn(Arrays.stream(adn).collect(Collectors.joining()));

			adnRepository.save(adnModel);

		} catch (Exception e) {
			throw e;
		}

		return isAdn;
	}

	public Estadistica calcularPromedio() throws Exception {

		Estadistica estadistica = new Estadistica();

		Object[][] listObject = adnRepository.contAdn();

		if (listObject != null && listObject.length > 0) {

			for (Object[] object : listObject) {

				if ((Boolean) object[0]) {
					estadistica.setContador_clon_adn(Double.valueOf(object[1].toString()));
				} else {

					estadistica.setContador_amigos_adn(Double.valueOf(object[1].toString()));
				}

			}

			if (estadistica.getContador_amigos_adn() == 0) {
				estadistica.setPromedio(1);
			} else {
				estadistica.setPromedio(
						Math.round((estadistica.getContador_clon_adn() / estadistica.getContador_amigos_adn()) * 10)
								/ 10.0);
			}

		}

		return estadistica;

	}

}
