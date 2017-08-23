package teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

@Component
public class ProdutoRepositorioJPA implements ProdutoRepositorio {
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void insere(Produto p) {
		// TODO Auto-generated method stub
		em.persist(p);
	}

	@Override
	public Produto consultarPorId(int id) {
		return em.find(Produto.class, id);
	}

	@Override
	public List<Produto> consultarTodos() {
		return em.createQuery("select p from Produto p",Produto.class).getResultList();
	}

}
