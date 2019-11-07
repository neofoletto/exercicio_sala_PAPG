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
		return this.valor.get(0);
	}
	
	protected Integer retornaTamanhoList() {
		return this.valor.size();
	}
	
	/**
	 * Retorna somatório da lista.
	 * 
	 * @param valor
	 * @return double
	 */
	protected Double retornaSomatorio() {
		double soma = 0;
		for (Double v : this.valor) 
			soma += v;
		return soma;
	}

	/***
	 * Retorna média de todos so valores da lista
	 * @return double
	 */
	protected Double retornaMedia() {
		return retornaSomatorio() / this.valor.size();
	}

	protected Double retornaMediana() {
		if (this.valor.size() % 2 != 0)
			return this.valor.get((this.valor.size() / 2) + 1);
		else 
			return (this.valor.get((this.valor.size() / 2)) + this.valor.get(((this.valor.size() / 2 ) + 1))) / 2;
	}
	
	public List<Double> razao(TipoProgressao tipoPrograssao) {
		List<Double> change = new ArrayList<Double>();
		
		switch (tipoPrograssao) {
		case PA:
			for (int i = 0; i < this.valor.size() - 1; i++) {
				if (i == 0)
					change.add(this.valor.get(i + 1) - this.valor.get(i));
				else {					
					if (change.get(0) != (this.valor.get(i + 1) - this.valor.get(i)))
						change.add(this.valor.get(i + 1));
					if (i == this.valor.size() - 2)
						if (change.get(0) != (this.valor.get(i + 1) - this.valor.get(0)))
							change.add(this.valor.get(0));
				}
			}
			break;
		case PG:
			for (int i = 0; i < this.valor.size() - 1; i++) {
				if (i == 0)
					change.add(this.valor.get(i + 1) / this.valor.get(i));
				else {					
					if (change.get(0) != (this.valor.get(i + 1) / this.valor.get(i)))
						change.add(this.valor.get(i + 1));
					if (i == this.valor.size() - 2)
						if (change.get(0) != (this.valor.get(i + 1) / this.valor.get(0)))
							change.add(this.valor.get(0));
				}
			}
			break;
		} 
		return change;
	}
	
	/**
	 * Ao retornar falso, indica que existe apenas dois valores no array,
	 * logo não pode ser definida a progressão como sendo PA ou PG.
	 * 
	 * @return true  -> PA ou PG
	 * @return false -> Houver apenas dois valores em this.valor
	 */
	public boolean validaPAouPG() {
		if (!razaoPA() && !razaoPG())
			return false;
		return true;
	}
	
	/**
	 * Valida se a razao encontrada na progressão é aritimética.
	 * 
	 * @return true  -> progressão aritimética
	 * @return false -> não conforme
	 */
	public boolean razaoPA() {
		double result = this.valor.get(0) - this.valor.get(1);
		if (this.valor.size() != 2)
			if (this.valor.get(1) - this.valor.get(2) == result)
				return true;
		return false;
	}
	
	/**
	 * Valida se a razao encontrada na progressão é aritimética.
	 * 
	 * @return true  -> progressão geométrica
	 * @return false -> não conforme
	 */
	public boolean razaoPG() {
		double result = this.valor.get(0) / this.valor.get(1);
		if (this.valor.size() != 2)
			if (this.valor.get(1) / this.valor.get(2) == result)
				return true;
		return false;
	}
	
	
	
}
