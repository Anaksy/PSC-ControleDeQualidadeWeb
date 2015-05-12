package unibratec.controlequalidade.beans;

import javax.faces.bean.ManagedBean;

import unibratec.controlequalidade.entidades.Categoria;
import unibratec.controlequalidade.exceptions.CategoriaCadastradaException;
import unibratec.controlequalidade.exceptions.CategoriaNaoCadastradaException;
import unibratec.controlequalidade.negocio.Fachada;
import unibratec.controlequalidade.util.MensagensGui;

@ManagedBean(name="RemoverCategoriaMB")
public class RemoverCategoriaMB {
	
	private Categoria categoria = new Categoria();
	private Fachada fachada = new Fachada();
	private String mensagem;
	
	
	public String removerCategoria(){
		try {
			fachada.removeCategoria(categoria);
			setMensagem(MensagensGui.CATEGORIA_REMOVIDA_SUCESSO);
		} catch (CategoriaNaoCadastradaException e) {
			setMensagem(MensagensGui.CATEGORIA_REMOVIDA_FALHA);
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
