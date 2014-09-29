package com.example.ittranjunho;

import java.lang.reflect.Field;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.Button;
import android.widget.TextView;

public class Login extends Activity {

	//private static final Bundle ViewConfiguration = null;

		private final String TAG = "Activity_ittran_index";
		
		// Definindo variáveis e seus tipos
		TextView login, password;
		Button button_entrar;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);

		// atribuindo os valores das id às variáveis
		login = (TextView) findViewById(R.id.inputLogin);
		password = (TextView) findViewById(R.id.inputPassword);
		button_entrar = (Button) findViewById(R.id.button_entrar); 
		
				
		// Ao clicar no botão efetuar validação do login
	    button_entrar.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	    	   //pegar as informações digitadas em login e password para validar ao clicar em entrar (fazer)
	    	   
	    	   
	     	   // Intent para redirecionar para a página de Cadastro da Multa -> Informações do Veículo
	    	   Intent Iniciar = new Intent(Login.this,InformacoesVeiculo.class);
	     	   Login.this.startActivity(Iniciar);
	     	   Login.this.finish();
	     }});
		
	    // Configuração para forçar o menu Overflow ficar na action-bar em alguns dispositivos
	    try{
			ViewConfiguration config = ViewConfiguration.get(this);
			Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
			if(menuKeyField != null){
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		}
		catch (Exception e){
			
		}
	}


	
	public String getTAG() {
	return TAG;
	}


	

	

}
