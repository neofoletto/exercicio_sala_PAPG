/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package persistencia;

import java.util.List;

import exercicio_01.ListaValores;

public class Persistencia {

	private Gravacao g;
	
	public Persistencia(Gravacao g) {
		this.g = g;
	}
	
	public boolean gravar(List<ListaValores> lista, String nome) {
		return g.gravar(lista, nome);
	}
	
	public List<ListaValores> ler(String nome) {
		return g.ler(nome);
	}
}
