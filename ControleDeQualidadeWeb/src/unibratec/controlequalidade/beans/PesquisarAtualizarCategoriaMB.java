package unibratec.controlequalidade.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;
import unibratec.controlequalidade.exceptions.CategoriaNaoCadastradaException;
import unibratec.controlequalidade.negocio.Fachada;
import unibratec.controlequalidade.util.MensagensGui;

@ManagedBean(name="PesquisarAtualizarCategoriaMB")
public class PesquisarAtualizarCategoriaMB {

	private Categoria categoria = new Categoria();
	private Fachada fachada = new Fachada();
	private List<Categoria> listaCategoria;
	private String mensagem;

	public List<Categoria> getListaCategoria() {
		listaCategoria = fachada.listaTodasCategorias();
		return listaCategoria;
	}

	public void setListaCategoria(List<Categoria> listaCategoria) {
		this.listaCategoria = listaCategoria;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public String getMensagem() {
		return mensagem;
	}

	public void setMensagem(String mensagem) {
		this.mensagem = mensagem;
	}
	
	public void popularCategoria(Categoria c){
		try {
			Categoria CategoriaEncontrada = fachada.buscaCategoriaPorNomeCategoria(c.getNomeCategoria());
			this.categoria.setIdCategoria(CategoriaEncontrada.getIdCategoria());
			this.categoria.setNomeCategoria(CategoriaEncontrada.getNomeCategoria());
			this.categoria.setNumeroDeDiasParaVencimento(CategoriaEncontrada.getNumeroDeDiasParaVencimento());
		} catch (CategoriaNaoCadastradaException e) {
			setMensagem("CategoriaNaoCadastradaException");
			e.printStackTrace();
		}
	} 

	public String atualizarCategoria(){
		try {
			fachada.alteraCategoria(this.categoria);
			setMensagem(MensagensGui.CATEGORIA_ATUALIZADA_SUCESSO);
		} catch (CategoriaCadastradaException e) {
			setMensagem("CategoriaCadastradaException");
		} catch (CategoriaNaoCadastradaException e) {
			setMensagem("CategoriaNaoCadastradaException");
			e.printStackTrace();
		}
		return mensagem;
	}
	
	




}
