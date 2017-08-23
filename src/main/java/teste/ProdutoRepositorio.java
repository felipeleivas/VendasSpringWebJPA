package teste;

import java.util.List;

public interface ProdutoRepositorio {
	void insere(Produto p);
	Produto consultarPorId(int id);
	List<Produto> consultarTodos();
}
