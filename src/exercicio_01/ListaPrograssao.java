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
import java.util.stream.Collectors;

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
	
	public boolean lerGravarListaValores(String nome) {
		try {
			this.listaValores = pers.ler(nome);
			persisteValoresListaProgressao();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
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
	
	private void persisteValoresListaProgressao() {
		try {
			Progressao p;
			for (int i = 0; i < this.listaValores.size(); i++) {
				p = new Progressao();
				p.setA1(retornaA1(i)); 																					// set a1
				p.setProgressao(retornaTipoProgressao(i)); 											// set tipo prograssao (PA ou PG)
				List<Double> aux = retornaRasao(i, p.getProgressao());
				p.setRazao(aux.get(0)); 																				// set razao
				aux.remove(0);
				if (aux.size() >= 0)
					p.setListaAlterado(aux);
				p.setQuantidade(this.listaValores.get(i).retornaTamanhoList()); // set quantidade
				p.setSomatorio(this.listaValores.get(i).retornaSomatorio());		// set somatório
				p.setMedia(this.listaValores.get(i).retornaMedia());
				p.setModa(-1);
				p.setMediana(this.listaValores.get(i).retornaMedia());					// set mediana
				p.setLista(this.listaValores.get(i).getValor());
				this.listaProgressao.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * retorna o valor para a variável A1
	 * 
	 * @return Double
	 */
	private Double retornaA1(int index) {
		return this.listaValores.get(index).retonarPrimeiroValor();
	}
	
	private TipoProgressao retornaTipoProgressao(int index) {
		if (this.listaValores.get(index).validaPAouPG())
			if (this.listaValores.get(index).razaoPG())
				return TipoProgressao.PG;		
		
		return TipoProgressao.PA;
	}
	
	public List<Double> retornaRasao(int index, TipoProgressao tipoPrograssao) {
		return this.listaValores.get(index).razao(tipoPrograssao);
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ListaPrograssao: ");
		builder.append(this.listaProgressao.stream().map(Object::toString).collect(Collectors.joining("\n")));
		return builder.toString();
	}
	
	
}
