package teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VendasController {
	
	private ProdutoRepositorio pr;
	@Autowired
	
	public VendasController(ProdutoRepositorio pr) {
		this.pr = pr;
	}
	@RequestMapping("show")
	public List<Produto> showProdutos(){
		
		return pr.consultarTodos();
	}
}
