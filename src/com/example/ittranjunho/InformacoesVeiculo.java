package com.example.ittranjunho;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class InformacoesVeiculo extends Activity {

	// Definindo as variáveis e seus tipos
	Button button_next1;
	EditText edit_placa, edit_modelo;
	Spinner spin_estado, spin_cidade, spin_especie, spin_tipo, spin_marca;
	String placa, estado, cidade, especie, tipo, marca, modelo, nomeArq;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacoes_veiculo);

		//Cria button up na action-bar
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
		
	    // Atribuindo os valores das ids às variáveis	    
	    button_next1 = (Button) findViewById(R.id.button_next1);
		edit_placa = (EditText) findViewById(R.id.edit_placa);
		spin_estado = (Spinner) findViewById(R.id.spnestado);
		spin_cidade = (Spinner) findViewById(R.id.spncidade);
		spin_especie = (Spinner) findViewById(R.id.spnespecie);
		spin_tipo = (Spinner) findViewById(R.id.spntipo);
		spin_marca = (Spinner) findViewById(R.id.spnmarca);
		edit_modelo = (EditText) findViewById(R.id.edit_modelo);
		
	    
		// Ação ao botão - Redireciona para a tela Informacoes da Infracao
		button_next1=(Button)findViewById(R.id.button_next1); 
	    button_next1.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	    	   
	    	   // fazer o if para validar os campos obrigatórios
	    	   
	    	   // Adiciona os elementos na Clasee Infracao
	    	   Infracao.setPlaca(edit_placa.getText().toString());
	    	   Infracao.setCidade(spin_cidade.getSelectedItem().toString());
	    	   Infracao.setUF(spin_estado.getSelectedItem().toString());
	    	   Infracao.setEspecie(spin_especie.getSelectedItem().toString());
	    	   Infracao.setTipo(spin_tipo.getSelectedItem().toString());
	    	   Infracao.setMarca(spin_marca.getSelectedItem().toString());
	    	   Infracao.setModelo(edit_modelo.getText().toString());
	    	   
	     	   Intent next = new Intent(InformacoesVeiculo.this,InformacoesInfracao.class);
	     	   InformacoesVeiculo.this.startActivity(next);
	     	   finish();
	     }});
	    
	  
	 	
	}
}
