package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Usuario;
import jpautil.JpaUtil;

public class UsuarioDAO {
	
	public void salvar(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		entityManager.persist(usuario);
		entityTransaction.commit();
		
		entityManager.close();
	}
	
	public Usuario atualizar(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Usuario retorno = entityManager.merge(usuario);
		entityTransaction.commit();
		
		entityManager.close();
		
		return retorno;

	}

	public void deletar(Usuario usuario) {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		Object id = JpaUtil.getPrimaryKey(usuario);
		
		entityManager
			.createQuery("delete from Usuario where id=" + id)
			.executeUpdate();
		entityTransaction.commit();
		
		entityManager.close();
	}
	
	public List<Usuario> listar() {
		EntityManager entityManager = JpaUtil.getEntityManager();
		EntityTransaction entityTransaction = entityManager.getTransaction();
		entityTransaction.begin();
		
		List<Usuario> lista = entityManager
								.createQuery("from Usuario")
								.getResultList();
		entityTransaction.commit();
		
		entityManager.close();
		
		return lista;
	}
	
}
