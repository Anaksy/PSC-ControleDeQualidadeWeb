package unibratec.controlequalidade.beans;

import javax.faces.bean.ManagedBean;
import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;
import unibratec.controlequalidade.negocio.Fachada;
import unibratec.controlequalidade.util.MensagensGui;

@ManagedBean(name="AdicionarCategoriaMB")
public class AdicionarCategoriaMB {
	
	private Categoria categoria = new Categoria();
	private Fachada fachada = new Fachada();
	private String mensagem;
	
	
	public String criarCategoria(){
		try {
			fachada.inserirCategoria(categoria);
			setMensagem(MensagensGui.CATEGORIA_CADASTRADA_SUCESSO);
		} catch (CategoriaCadastradaException e) {
			setMensagem(MensagensGui.CATEGORIA_CADASTRADA_FALHA);
		}
		return mensagem;
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

	public void setMensagem(String menssagem) {
		this.mensagem = menssagem;
	}

}
