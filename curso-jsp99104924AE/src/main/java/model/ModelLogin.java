package model;

import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class ModelLogin implements Serializable{

	private static final long serialVersionUID = 1L;
	private Long id;
	private String nome;
	private String email;
	private String login;
	private String senha;
	private Boolean userAdmin;
	
	//private String perfil;
	
	//private String sexo;
	
	private String fotouser;
	
	private String extensaofotouser;
	
	private String cep;
	
	private String logradouro;
	
	private String bairro;
	
	private String localidade;
	
	private String uf;
	
	private String numero;
	
	private Date dataNascimento;
	
	private Double rendamensal;
	
	private List<ModelTelefone> telefones = new ArrayList<ModelTelefone>();
	
	private List<ModelProduto> produtos = new ArrayList<ModelProduto>();
	
	
	public void setTelefones(List<ModelTelefone> telefones) {
		this.telefones = telefones;
	}
	
	public List<ModelTelefone> getTelefones() {
		return telefones;
	}
	
	
	public void setProdutos(List<ModelProduto> produtos) {
		this.produtos = produtos;
	}
	
	public List<ModelProduto> getProdutos() {
		return produtos;
	}
	
	public void setRendamensal(Double rendamensal) {
		this.rendamensal = rendamensal;
	}
		
	public Double getRendamensal() {
		return rendamensal;
	}
	
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Date getDataNascimento() {
		return dataNascimento;
	}
	
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	
	
	
	
	public void setFotouser(String fotouser) {
		this.fotouser = fotouser;
	}
	
	public String getFotouser() {
		return fotouser;
	}
	
	public void setExtensaofotouser(String extensaofotouser) {
		this.extensaofotouser = extensaofotouser;
	}
	
	public String getExtensaofotouser() {
		return extensaofotouser;
	}
	
	
	
	
	public boolean isNovo() {
		
		if(this.id == null) {
			return true; //inserir
		}else if(this.id != null && this.id > 0) {
			return false; //atualizar
		}
		
		return id == null;
	}
	
	public void setUserAdmin(Boolean userAdmin) {
		this.userAdmin = userAdmin;
	}
	
	public Boolean getUserAdmin() {
		return userAdmin;
	}
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public String getMostraTelefoneRel() {
		
		String fone = "Telefone:\n\n";
		
		for (ModelTelefone modelTelefone : telefones) {
			fone += modelTelefone.getNumero() + "\n";
		}
		
		return fone;
	}
	
	
public String getMostraProdutoRel() {
		
		String produto = "Produto:\n\n";
		
		for (ModelProduto modelProduto : produtos) {
			produto += modelProduto.getNomeproduto() + "\n";
		}
		
		return produto;
	}
	

}
