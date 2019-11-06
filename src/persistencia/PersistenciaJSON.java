/**
                    GNU GENERAL PUBLIC LICENSE
                       Version 3, 29 June 2007

 Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
 Everyone is permitted to copy and distribute verbatim copies
 of this license document, but changing it is not allowed.
 */
package persistencia;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.reflect.TypeToken;

import exercicio_01.ListaValores;

import java.lang.reflect.Type;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class PersistenciaJSON implements Gravacao {

	private Gson gson;

	private String setNome(String nome) {
		if (nome.length() != 0) {
			return nome + ".json";
		}
		return "pa_pg.json";
	}

	public boolean gravar(List<ListaValores> lista, String nome) {
		Gson gson = new GsonBuilder().create();
		try {
			FileWriter writer = new FileWriter(setNome(nome));
			writer.write(gson.toJson(lista) + "" + System.lineSeparator());
			writer.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public List<ListaValores> ler(String nome) {
		gson = new GsonBuilder().create();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(setNome(nome)));
			Type listType = new TypeToken<ArrayList<ListaValores>>() {
			}.getType();
			List<ListaValores> lista = new ArrayList<ListaValores>();
			lista = gson.fromJson(bufferedReader, listType);
			return lista;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
