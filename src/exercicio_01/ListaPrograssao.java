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
import java.util.ListIterator;

import persistencia.Gravacao;
import persistencia.Persistencia;
import persistencia.PersistenciaJSON;

/**
 * @author neo
 *
 */
public class ListaPrograssao {
	
	private List<Progressao> listaProgressao;
	private List<ListaValores> listaValores;
	private Persistencia pers = null;
	
	/**
	 * 
	 */
	public ListaPrograssao() {
		listaProgressao = new ArrayList<Progressao>();
		listaValores = new ArrayList<ListaValores>();
		pers = new Persistencia((Gravacao) new PersistenciaJSON());
	}

	public List<ListaValores> ler(String nome) {
		return pers.ler(nome);
	}

	public void inserir(Progressao progressao) {
		this.listaProgressao.add(progressao);
		ListaValores v = new ListaValores();
		for (int i = 0; i < progressao.getLista().size(); i++) 
			v.setValor(progressao.getLista().get(i));
		this.listaValores.add(v);
	}
	
	public void gravar(String nome) {
		pers.gravar(listaValores, nome);
	}
	
	public String leArquivoRetornaListaCompleta(String nome) {
		StringBuilder builder = new StringBuilder();
		for (ListaValores lista : ler(nome)) {
			builder.append(lista.getValor()).append("\n");
		}
		return builder.toString();
	}
	
	public Double retornaA1() {
		if (this.listaValores.size() == 0)
			return this.listaValores.get(0).retonarPrimeiroValor();
		else 
			return -1.0;
	}
	
	public void returnaRasao() {
		if (this.listaValores.get(0).rasao() != -1) {
			this.listaProgressao.get(0).setRazao(this.listaValores.get(0).rasao());
			this.listaProgressao.get(0).setProgressao(TipoProgressao.PA);
		}else {
			this.listaProgressao.get(0).setRazao(this.listaValores.get(0).rasao());
			this.listaProgressao.get(0).setProgressao(TipoProgressao.PG);
		}
	}
}
