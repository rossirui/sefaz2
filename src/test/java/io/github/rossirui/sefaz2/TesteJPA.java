package io.github.rossirui.sefaz2;

import javax.persistence.Persistence;

public class TesteJPA {

	public static void main(String[] args) {

		Persistence.createEntityManagerFactory("sefaz2");
	}

}
