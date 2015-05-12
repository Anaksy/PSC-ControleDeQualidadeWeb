package unibratec.controlequalidade.beans;

import javax.faces.bean.ManagedBean;

@ManagedBean(name="IndexMB")
public class IndexMB {
	
	public String irAdicionarCategoria(){
		return "/AdicionarCategoria.xhtml";
	}
	
	public String irRemoverCategoria(){
		return "/RemoverCategoria.xhtml";
	}
	
	public String irAtualizarCategoria(){
		return "/AtualizarCategoria.xhtml";
	}
	
	public String irPesquisarCategoria(){
		return "/PesquisarCategoria.xhtml";
	}
	


}
