package unibratec.controlequalidade.negocio;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.ProdutoNaoEncontradoExcecption;
import unibratec.controlequalidade.exceptions.ProdutoNaoPrestesAVencerException;
import unibratec.controlequalidade.exceptions.dataDeValidadeMenorPermitidaCategoriaException;

public class Fachada implements IFachada {

	private NegocioLote negocioLote;
	private NegocioProduto negocioProduto;
	private NegocioCategoria negocioCategoria;
	private NegocioVenda negocioVenda;
	private NegocioProdutoLote npl;
	
	public Fachada(EntityManager em) {
		this.negocioLote = new NegocioLote(em);
		this.negocioProduto = new NegocioProduto(em);
		this.negocioCategoria = new NegocioCategoria(em);
		this.negocioVenda = new NegocioVenda(em);
	}
	
	@Override
	public void inserirProdutoLote(Produto produto, Lote lote, Calendar dataValidade, int qtdProdutos) throws dataDeValidadeMenorPermitidaCategoriaException {
		npl.associaLoteProduto(lote, produto, dataValidade, qtdProdutos);
		negocioLote.gerarLote(lote);
		negocioProduto.inserirProduto(produto);
		
	}

	@Override
	public void inserirCategoria(Categoria categoria) {
		negocioCategoria.inserirCategoria(categoria);
		
	}

	@Override
	public List<Produto> getListaProdutoPrestesVencer() throws ProdutoNaoEncontradoExcecption {
		return negocioVenda.retornaListaProdutosPrestesAVencer();
	}

	@Override
	public Produto getProdutoPrestesVencer(Produto produto) throws ProdutoNaoPrestesAVencerException, ProdutoNaoEncontradoExcecption {
		
		return negocioVenda.retornaProdutoPrestesAVencer(produto);
	}

	@Override
	public void setDescontoProdutoPrestesVencer(Produto produto, double desconto) {
		negocioVenda.darDescontoProdutoPrestesAVencer(produto, desconto);
		
	}

}
