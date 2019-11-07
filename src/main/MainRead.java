/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package main;

import exercicio_01.ListaPrograssao;

/**
 * @author neo
 *
 */
public class MainRead {
	
	public static void main(String[] args) {
		ListaPrograssao lp= new ListaPrograssao();
		
		String nomeArquivo = "pop"; // nome do arquivo
		
		lp.lerGravarListaValores(nomeArquivo);
		System.out.println(lp);
	}
}
