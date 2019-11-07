/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package main;

import exercicio_01.ListaPrograssao;
import exercicio_01.Progressao;
import exercicio_01.TipoProgressao;

/**
 * @author neo
 *
 */
public class Main {

	public static void main(String[] args) {
		Progressao p;
		ListaPrograssao listaProgressa = new ListaPrograssao();
		
		String nomeArquivo = "pop"; // nome do arquivo

//	System.out.print("Insira nome do arquivo: ");
//	fileName = imput.nextLine();
//	System.out.print("Insira nome do arquivo: ");
//	extName = imput.nextLine();
		
		
//		p = new Progressao();
//		p.setA1(10);
//		p.setRazao(2);
//		p.setQuantidade(2);
//		p.setProgressao(TipoProgressao.PA);
//		listaProgressa.inserir(p);
		
		p = new Progressao();
		p.setA1(20);
		p.setRazao(3);
		p.setQuantidade(6);
		p.setProgressao(TipoProgressao.PA);
		listaProgressa.inserir(p);
		
		p = new Progressao();
		p.setA1(2);
		p.setRazao(3);
		p.setQuantidade(7);
		p.setProgressao(TipoProgressao.PG);
		System.out.println(p);
		listaProgressa.inserir(p);		
		
		listaProgressa.gravar(nomeArquivo);	
	}
}
