package teste;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ProdutoRepositorio2 extends CrudRepository<Produto, Integer>{
	List<Produto> findAll();
}
