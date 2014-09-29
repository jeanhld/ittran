package com.example.ittranjunho;

public class Infracao {

	static String placa, cidade, uf, especie, tipo, marca, modelo, local, infracao, obs,
			uri_ft_1,uri_ft_2,uri_ft_3,uri_ft_4,condutor, nf, cnh_ppd, cpf_rg;
	static boolean radio_cnh,radio_ppd,radio_cpf,radio_rg;
	
	public Infracao(){
		Infracao.placa = null;
		Infracao.cidade = null;
		Infracao.uf = null;
		Infracao.especie = null;
		Infracao.tipo = null;
		Infracao.marca = null;
		Infracao.modelo = null;
		Infracao.local = null;
		Infracao.infracao = null;
		Infracao.obs = null;
		Infracao.uri_ft_1 = null;
		Infracao.uri_ft_2 = null;
		Infracao.uri_ft_3 = null;
		Infracao.uri_ft_4 = null;
		Infracao.condutor = null;
		Infracao.nf = null;
		Infracao.cnh_ppd = null;
		Infracao.cpf_rg = null;
		Infracao.radio_cnh = false; //boolean
		Infracao.radio_ppd = false; //boolean
		Infracao.radio_cpf = false; //boolean
		Infracao.radio_rg = false;  //boolean
	}

	public static void setPlaca(String placa){
		Infracao.placa = placa;
	}
	public static void setCidade(String cidade){
		Infracao.cidade = cidade;
	}
	public static void setUF(String uf){
		Infracao.uf = uf;
	}
	public static void setEspecie(String especie){
		Infracao.especie = especie;
	}
	public static void setTipo(String tipo){
		Infracao.tipo = tipo;
	}
	public static void setMarca(String marca){
		Infracao.marca = marca;
	}
	public static void setModelo(String modelo){
		Infracao.modelo = modelo;
	}
	public static void setLocal(String local){
		Infracao.local = local;
	}
	public static void setInfracao(String infra){
		Infracao.infracao = infra;
	}
	public static void setObs(String obs){
		Infracao.obs = obs;
	}
	public static void setFt1(String uri){
		Infracao.uri_ft_1 = uri;
	}
	public static void setFt2(String uri){
		Infracao.uri_ft_2 = uri;
	}
	public static void setFt3(String uri){
		Infracao.uri_ft_3 = uri;
	}
	public static void setFt4(String uri){
		Infracao.uri_ft_4 = uri;
	}
	public static void setCondutor(String condutor){
		Infracao.condutor = condutor;
	}
	public static void setNf(String nf){
		Infracao.nf = nf;
	}
	public static void setCnhPpd(String cnh_ppd){
		Infracao.cnh_ppd = cnh_ppd;
	}
	public static void setCpfRg(String cpf_rg){
		Infracao.cpf_rg = cpf_rg;
	}
	public static void setRadioCnh(boolean cnh){
		Infracao.radio_cnh = cnh;
	}
	public static void setRadioPpd(boolean ppd){
		Infracao.radio_ppd = ppd;
	}
	public static void setRadioCpf(boolean cpf){
		Infracao.radio_cpf = cpf;
	}
	public static void setRadioRg(boolean rg){
		Infracao.radio_rg = rg;
	}
	
	// GETS
	public static String getPlaca(){
		return Infracao.placa;
	}
	public static String getCidade(){
		return Infracao.cidade;
	}
	public static String getUF(){
		return Infracao.uf;
	}
	public static String getEspecie(){
		return Infracao.especie;
	}
	public static String getTipo(){
		return Infracao.tipo;
	}
	public static String getMarca(){
		return Infracao.marca;
	}
	public static String getModelo(){
		return Infracao.modelo;
	}
	public static String getLocal(){
		return Infracao.local;
	}
	public static String getInfracao(){
		return Infracao.infracao;
	}
	public static String getObs(){
		return Infracao.obs;
	}
	public static String getFt1(){
		return Infracao.uri_ft_1;
	}
	public static String getFt2(){
		return Infracao.uri_ft_2;
	}
	public static String getFt3(){
		return Infracao.uri_ft_3;
	}
	public static String getFt4(){
		return Infracao.uri_ft_4;
	}
	public static String getCondutor(){
		return Infracao.condutor;
	}
	public static String getNf(){
		return Infracao.nf;
	}
	public static String getCnhPpd(){
		return Infracao.cnh_ppd;
	}
	public static String getCpfRg(){
		return Infracao.cpf_rg;
	}
	public static boolean getRadioCnh(){
		return Infracao.radio_cnh;
	}
	public static boolean getRadioPpd(){
		return Infracao.radio_ppd;
	}
	public static boolean getRadioCpf(){
		return Infracao.radio_cpf;
	}
	public static boolean getRadioRg(){
		return Infracao.radio_rg;
	}

}
