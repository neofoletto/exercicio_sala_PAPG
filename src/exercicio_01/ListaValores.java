/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package exercicio_01;

import java.util.ArrayList;
import java.util.List;
/**
 * @author neo
 *
 */
public class ListaValores {

	private List<Double> valor;
	
	/**
	 * 
	 */
	public ListaValores() {
		valor = new ArrayList<Double>();
	}

	public List<Double> getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor.add(valor);
	}
	
	public Double retonarPrimeiroValor() {
		return valor.get(0);
	}
	
	public Double rasao() {
		double razao = 0;
		int count = 0;
		for (int i = 0; i < valor.size() - 1; i++) {
			if (i == 0)
				razao = valor.get(i) - valor.get(i + 1);
			else {
				double aux = valor.get(i) - valor.get(i + 1);
				if (razao == aux)
					count++;
			}
		}
		if (count > 2)
			return razao;
		else
			return -1.0;
	}
}
