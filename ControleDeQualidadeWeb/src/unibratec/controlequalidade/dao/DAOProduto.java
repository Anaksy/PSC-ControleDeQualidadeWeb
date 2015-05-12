package unibratec.controlequalidade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import unibratec.controlequalidade.entidades.EstadoProdutoEnum;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.ProdutoNaoEncontradoExcecption;

public class DAOProduto extends DAOGenerico<Produto> implements IDAOProduto {

	public DAOProduto(EntityManager em) {
		super(em);
	}
	
	@Override
	public List<Produto> pesquisarProdutoPorEstadoList(EstadoProdutoEnum estadoProduto) throws ProdutoNaoEncontradoExcecption {

		TypedQuery<Produto> query = this.entityManager.createNamedQuery(
				"Produto.findByEstado", this.classePersistente);

		query.setParameter("estadoProduto", estadoProduto);
		
		if (query.getResultList().isEmpty() || query.getResultList() == null) {
			throw new ProdutoNaoEncontradoExcecption("Produto não encontrado.");
		}
		else {
			return query.getResultList();
		}
//
//		try {
//
//			return query.getResultList();
//
//		} catch (NoResultException e) {
//
//			e.printStackTrace();
//			e.getMessage();
//
//			throw new ProdutoNaoEncontradoExcecption("Produto não encontrado.");
//
//		}

	}

	@Override
	public Produto pesquisarProdutoPorEstado(Produto produto) throws ProdutoNaoEncontradoExcecption {

		TypedQuery<Produto> query = this.entityManager.createNamedQuery(
				"Produto.findByEstado", this.classePersistente);

		query.setParameter("estadoProduto", produto.getEstadoProduto());
		
		if (query.setMaxResults(1).getSingleResult() == null) {
			throw new ProdutoNaoEncontradoExcecption("Produto não encontrado.");
		}
		else {
			return query.setMaxResults(1).getSingleResult();
		}
//		
//		try {
//
//			return query.setMaxResults(1).getSingleResult();
//
//		} catch (NoResultException e) {
//
//			e.printStackTrace();
//			e.getMessage();
//
//			throw new ProdutoNaoEncontradoExcecption("Produto não encontrado.");
//
//		}

	}
}
