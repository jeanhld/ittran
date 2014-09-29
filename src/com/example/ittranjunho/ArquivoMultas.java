package com.example.ittranjunho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ArquivoMultas {
	
	public static void main(String[] args) {    
	      try {    
	         // Gravando no arquivo    
	         File arquivo;    
	    
	         arquivo = new File("arquivo_multas.txt");    
	         FileOutputStream fos = new FileOutputStream(arquivo);    
	         String texto = "quero gravar este texto no arquivo";    
	         fos.write(texto.getBytes());    
	         texto = "\nquero gravar este texto AQUI TAMBEM";    
	         fos.write(texto.getBytes());    
	         fos.close();    
	    
	         // Lendo do arquivo    
	         arquivo = new File("arquivo.txt");    
	         FileInputStream fis = new FileInputStream(arquivo);    
	    
	         int ln;    
	         while ( (ln = fis.read()) != -1 ) {    
	            System.out.print( (char)ln );    
	         }    
	    
	         fis.close();    
	      }    
	      catch (Exception ee) {    
	         ee.printStackTrace();    
	      }    
	   }  

}
