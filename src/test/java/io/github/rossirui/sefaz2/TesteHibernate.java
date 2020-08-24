package io.github.rossirui.sefaz2;

import org.junit.jupiter.api.Test;

import dao.UsuarioDAO;
import entities.Usuario;

public class TesteHibernate {
	
	@Test
	public void TestHibernateSalvar() {
		UsuarioDAO dao = new UsuarioDAO();
		
		Usuario usuario = new Usuario();
		
		usuario.setNome("Almeida");
		usuario.setEmail("almeida@mail.com");
		usuario.setSenha("senhaAlmeida");
		
		dao.salvar(usuario);
		
	}

}
