package com.example.ittranjunho;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class ItensActionBar extends Activity {

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.itens_action_bar, menu);
		return true;	
	}
	

	public boolean onOptionsItemSelected(MenuItem item){
		switch (item.getItemId())
		{
			case R.id.action_nova_multa:
				openNovaMulta();
				return true;
			/*case R.id.action_sincronizar:
				openSincronizar();
				return true;*/
			case R.id.action_sobre:
				openSobre();
				return true;
			case R.id.action_sair:
				finish();
				return true;
			default:
				return super.onOptionsItemSelected(item);
		
		}
	}
	
	
	public boolean openNovaMulta(){
		Intent coleta = new Intent (ItensActionBar.this, InformacoesVeiculo.class);
		startActivity(coleta);
		return true;
		
	}
	
/*	public boolean openSincronizar(){
		Intent configuracoes = new Intent(ItensActionBar.this, Sincronizar.class);
		startActivity(configuracoes);
		return true;
	}*/
	
	public boolean openSobre(){
		Intent sobre = new Intent(ItensActionBar.this, Sobre.class);
		startActivity(sobre);
		return true;
	}
	
	
	

}
