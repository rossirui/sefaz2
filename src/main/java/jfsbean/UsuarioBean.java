package jfsbean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.UsuarioDAO;
import entities.Usuario;

@ViewScoped
@ManagedBean(name = "usuarioBean")
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	private UsuarioDAO dao = new UsuarioDAO();
	private List<Usuario> usuarios = new ArrayList<Usuario>();
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public UsuarioDAO getDao() {
		return dao;
	}

	public void setDao(UsuarioDAO dao) {
		this.dao = dao;
	}

	public List<Usuario> getUsuarios() {
		return usuarios;
	}
	
	public String salvar() {
		dao.salvar(usuario);
		usuario = new Usuario();

		listar();
		return "";
	}
	
	public String limpar() {
		usuario = new Usuario();

		return "";
	}
	
	public String atualizar() {
		usuario = dao.atualizar(usuario);
		
		return "";
	}
	
	public String deletar() {
		dao.deletar(usuario);
		usuario = new Usuario();
		listar();
		return "";
	}
	
	public String listar() {
		usuarios = dao.listar();
		return "";
	}
 
}
