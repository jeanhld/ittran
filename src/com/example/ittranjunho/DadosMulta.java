package com.example.ittranjunho;

public class DadosMulta {
	
	private String placa;
	private String estado;
	private String cidade;
	private String especie;
	private String tipo;
	private String marca;
	private String modelo;
	private String local_infracao;
	private String infracao;
	private String observacoes;
	private String nome_condutor;
	private String cnh_ppd;
	private String cpf_rg;
	private String nf;
	// verificar radio button

	// INFORMAÇÕES DO VEÍCULO
	//Placa
	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	//Estado
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	// Cidade
	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	//Espécie
	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}	
	
	//Tipo
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	//Marca
	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}	
	
	//Modelo
		public String getModelo() {
			return modelo;
		}

		public void setModelo(String modelo) {
			this.modelo = modelo;
		}
		
	//INFORMAÇÕES DA INFRAÇÃO
	//Local da Infração
		public String getLocalInfracao() {
			return local_infracao;
		}

		public void setLocalInfracao(String local_infracao) {
			this.local_infracao = local_infracao;
		}
		
	//Infração
		public String getInfracao() {
			return infracao;
		}

		public void setInfracao(String infracao) {
			this.infracao = infracao;
		}
		
	//Observações
		public String getObservacoes() {
			return observacoes;
		}

		public void setObservacoes(String observacoes) {
			this.observacoes = observacoes;
		}
		
	//INFORMAÇÕES DO CONDUTOR
	//Nome Condutor
		public String getNomeCondutor() {
			return nome_condutor;
		}

		public void setNomeCondutor(String nome_condutor) {
			this.nome_condutor = nome_condutor;
		}
	//CNH ou PPD
		public String getCnhPpd() {
			return cnh_ppd;
		}

		public void setCnhPpd(String cnh_ppd) {
			this.cnh_ppd = cnh_ppd;
		}
		
	//CPF ou RG
		public String getCpfRg() {
			return cpf_rg;
		}

		public void setCpfRg(String cpf_rg) {
			this.cpf_rg = cpf_rg;
		}

	// NF
		public String getNF() {
			return nf;
		}

		public void setNF(String nf) {
			this.nf = nf;
		}
		
	
	@Override
	public String toString() {
		return "DadosMulta [placa=" + placa + ", modelo=" + modelo + "obsercacoes=" + observacoes +
				", nome_condutor=" + nome_condutor + ", cnhp_ppd=" + cnh_ppd + ", cpf_rg=" + cpf_rg + ", nf" + nf + "]";
	}
	
	/*@Override
	public String toString() {
		return "DadosMulta [placa=" + placa + ", estado=" + estado + ", cidade=" + cidade + 
				",especie=" + especie + ", tipo=" + tipo + ", marca=" + marca + ", modelo=" + modelo +
				", local_infracao=" + local_infracao + ", infracao=" + infracao + "obsercacoes=" + observacoes +
				", nome_condutor=" + nome_condutor + ", cnhp_ppd=" + cnh_ppd + ", cpf_rg=" + cpf_rg + ", nf" + nf + "]";
	}*/

}
