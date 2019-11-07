/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package exercicio_01;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author neo
 *
 */
public class Progressao {

	private double a1;
	private double razao;
	private int quantidade;
	private TipoProgressao progressao;
	private List<Double> lista;
	private double porcentoAlterado;
	
	private double somatorio;
	private double media;
	private double moda;
	private double mediana;	
	
	public Progressao() {
		lista = new ArrayList<Double>();
	}
	
	public double getA1() {
		return a1;
	}
	public void setA1(double a1) {
		this.a1 = a1;
	}
	public double getRazao() {
		return razao;
	}
	public void setRazao(double razao) {
		this.razao = razao;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public TipoProgressao getProgressao() {
		return progressao;
	}
	public List<Double> getLista() {
		return lista;
	}
	
	// PROTECTED
	protected void setLista(List<Double> lista) {
		this.lista = lista;
	}
	protected double getPorcentoAlterado() {
		return porcentoAlterado;
	}
	protected void setPorcentoAlterado(double porcentoAlterado) {
		this.porcentoAlterado = porcentoAlterado;
	}
	protected double getSomatorio() {
		return somatorio;
	}
	protected void setSomatorio(double somatorio) {
		this.somatorio = somatorio;
	}
	protected double getMedia() {
		return media;
	}
	protected void setMedia(double media) {
		this.media = media;
	}
	protected double getModa() {
		return moda;
	}
	protected void setModa(double moda) {
		this.moda = moda;
	}
	protected double getMediana() {
		return mediana;
	}
	protected void setMediana(double mediana) {
		this.mediana = mediana;
	}

	public void setProgressao(TipoProgressao progressao) {
		ListaValores v = new ListaValores();
		this.progressao = progressao;
		switch (progressao) {
		case PA:
			pa(v);
			break;
		case PG:
			pg(v);
			break;
		}
	}

	private void pa(ListaValores v) {
		double valor = 0;
		for (int i = 0; i < quantidade; i++) {
			if (i == 0) 
				valor = this.a1;
			else 
				valor = this.lista.get(this.lista.size() - 1) + this.razao;
			this.lista.add(valor);
		}
	}
	
	private void pg(ListaValores v) {
		double valor = 0;
		for (int i = 0; i < quantidade; i++) {
			if (i == 0) 
				valor = this.a1;
			else 
				valor = this.lista.get(this.lista.size() - 1) * this.razao;
			this.lista.add(valor);
		}
	}

	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#,0%");
		StringBuilder builder = new StringBuilder();
		builder.append("Progressao [a1=");
		builder.append(a1);
		builder.append(", razao=");
		builder.append(razao);
		builder.append(", quantidade=");
		builder.append(quantidade);
		builder.append(", progressao=");
		builder.append(progressao);
		builder.append(", lista=");
		builder.append("[");
		builder.append(this.lista.stream().map(Object::toString).collect(Collectors.joining(", ")));
		builder.append(']');
		builder.append(", porcentoAlterado=");
		builder.append(df.format(porcentoAlterado));
		builder.append(", somatorio=");
		builder.append(somatorio);
		builder.append(", media=");
		builder.append(media);
		builder.append(", moda=");
		builder.append(moda);
		builder.append(", mediana=");
		builder.append(mediana);
		builder.append("]");
		return builder.toString();
	}
}
