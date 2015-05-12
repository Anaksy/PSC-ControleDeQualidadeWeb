package unibratec.controlequalidade.negocio;

import java.util.Calendar;
import java.util.List;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.entidades.Lote;
import unibratec.controlequalidade.entidades.Produto;
import unibratec.controlequalidade.exceptions.ProdutoNaoEncontradoExcecption;
import unibratec.controlequalidade.exceptions.ProdutoNaoPrestesAVencerException;
import unibratec.controlequalidade.exceptions.dataDeValidadeMenorPermitidaCategoriaException;

public interface IFachada {
	
	public void inserirProdutoLote(Produto produto, Lote lote, Calendar dataValidade, int qtdProdutos) throws dataDeValidadeMenorPermitidaCategoriaException;
	
	public void inserirCategoria(Categoria categoria);
	
	public List<Produto> getListaProdutoPrestesVencer() throws ProdutoNaoEncontradoExcecption;
	
	public Produto getProdutoPrestesVencer(Produto produto) throws ProdutoNaoPrestesAVencerException, ProdutoNaoEncontradoExcecption;
		
	public void setDescontoProdutoPrestesVencer(Produto produto, double desconto);
	

}
