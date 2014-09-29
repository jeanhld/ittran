package com.example.ittranjunho;

public class Lista {
	static String Final = "";
	
	public void addString(String str){
		Final += (str+";");
	}
	
	public String get(){
		return Final;
	}
}
