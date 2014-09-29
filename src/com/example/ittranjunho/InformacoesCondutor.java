package com.example.ittranjunho;

import java.io.IOException;

import org.json.JSONException;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class InformacoesCondutor extends Activity{
	
	// Definindo as variáveis e seus tipos
	// Informações Condutor
	EditText nome_condutor, cnh_ppd, cpf_rg, nf;
	RadioButton radio_cnh, radio_ppd, radio_cpf, radio_rg;
	Button button_back2, button_save;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacoes_condutor);

		//Mensagem com os dados do formulário
	   	//Toast.makeText(getBaseContext(), Lista.Final, Toast.LENGTH_LONG).show();
		
		//Cria button up na action-bar
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
	    // Atribuindo os valores das id às variáveis
	    // Informações Condutor
	    nome_condutor = (EditText) findViewById(R.id.input_nome_condutor);
	    cnh_ppd = (EditText) findViewById(R.id.input_cnh_ppd);
	    cpf_rg = (EditText) findViewById(R.id.input_cpf_rg);
	    nf = (EditText) findViewById(R.id.input_nf);
	    radio_cnh = (RadioButton) findViewById(R.id.radio_cnh);
	    radio_ppd = (RadioButton) findViewById(R.id.radio_ppd);
	    radio_cpf = (RadioButton) findViewById(R.id.radio_cpf);
	    radio_rg = (RadioButton) findViewById(R.id.radio_rg);
		button_back2=(Button)findViewById(R.id.button_back2); 
		button_save=(Button)findViewById(R.id.button_save); 
		
		
		// FUNCIONALIDADE DOS BOTÕES
		// Button Back - redireciona para a tela de Informações da Infração
	    button_back2.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	     	   Intent Iniciar = new Intent(InformacoesCondutor.this,InformacoesInfracao.class);
	     	   InformacoesCondutor.this.startActivity(Iniciar);
	     	   InformacoesCondutor.this.finish();
	     }});
	    
	    	    
	  
	    // Button Save - salva multa e grava em um arquivo json
	       button_save.setOnClickListener(new View.OnClickListener() {
	    	   
	 	    	@Override
	 	    	public void onClick(View v){
	 	    	
	 	    		//Envia para o Json
	 	    		/*
	 	    		JsonAct json = new JsonAct();
	 	    		 
	 	    		try {
						json.insertMulta(Lista.Final);
					} catch (JSONException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					*/
	 	    		
	 	    		// Adicionar elementos na Classe da Infracao
	 	    		Infracao.setCondutor(nome_condutor.getText().toString());
	 	    		Infracao.setCnhPpd(cnh_ppd.getText().toString());
	 	    		Infracao.setCpfRg(cpf_rg.getText().toString());
	 	    		Infracao.setNf(nf.getText().toString());
	 	    		
	 	    		if(radio_cnh.isChecked()){Infracao.setRadioCnh(true);}
	 	    		if(radio_ppd.isChecked()){Infracao.setRadioPpd(true);}
	 	    		if(radio_cpf.isChecked()){Infracao.setRadioCpf(true);}
	 	    		if(radio_rg.isChecked()){Infracao.setRadioRg(true);}
	 	    		
	 	    		JsonAct json_activity = new JsonAct(getApplicationContext());
	 	    		try {
						//json_activity.insertMultaRMCC(Lista.Final);
						json_activity.insertMultaRUSC();
						json_activity.insertMultaRUCC();
						try {
							json_activity.insertMultaRMCC();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						Toast.makeText(getApplicationContext(), "Salvou !", Toast.LENGTH_LONG).show();
					} catch (JSONException e) {
						Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_LONG).show();
		 	    		
						e.printStackTrace();
					}  	    		

	 	    		//Alert - Confirmação de cadastro da multa
	 	     	    AlertDialog.Builder button_save = new AlertDialog.Builder(InformacoesCondutor.this);
		 		   	button_save.setTitle("Salvo");
		 		   	button_save.setMessage("As informações da multa foram salvas com sucesso! \n"
		 		   						   + " Ao confirmar você será redirecionado para uma nova multa.");
		 		   // Button - Ação Positiva - Redireciona para Informações da Infração 
		 		   	button_save.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
		 		       public void onClick(DialogInterface dialog, int id) {
		 		    	   	Intent Salvar = new Intent(InformacoesCondutor.this,InformacoesVeiculo.class);
			 	     	   	InformacoesCondutor.this.startActivity(Salvar);
			 	     	   	finish();
			 	    		}
		 		   	});
		 		   	// Button - Ação Negativa - Permanece na mesma tela
		 		    button_save.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
		 		    	public void onClick(DialogInterface dialog, int id) {
		 		    	   	Intent Salvar = new Intent(InformacoesCondutor.this,InformacoesCondutor.class);
			 	     	   	InformacoesCondutor.this.startActivity(Salvar);
			 	     	   	finish();
			 	    		}
		 		    });
		 		   	button_save.show();
	 	    	
		 	     	
	 	     }});
	
	    
	    
	}

	

	
    

}
