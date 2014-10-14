package com.example.ittranjunho;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;

public class EditLocalInfracao extends Dialog {
	String rua,numero,bairro, changes;
	EditText edit_rua,edit_numero,edit_bairro,edit_cidade_estado;
	 
    public EditLocalInfracao(Context context, String rua, String num, String bairro) {
        super(context);
        this.setRua(rua);
        this.setNumero(num);
        this.setBairro(bairro);
    }
 
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_edit_local_infracao);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_dialog);
		
		Button btn_cancel = (Button) findViewById(R.id.btn_cancel);
		Button btn_change = (Button) findViewById(R.id.btn_change);
		
		edit_rua = (EditText) findViewById(R.id.et_rua);
		edit_numero = (EditText) findViewById(R.id.et_numero);
		edit_bairro = (EditText) findViewById(R.id.et_bairro);
		
		edit_rua.setText(this.getRua());
		edit_numero.setText(this.getNumero());
		edit_bairro.setText(this.getBairro());
		
		btn_cancel.setOnClickListener(new View.OnClickListener() {
		       @Override
		       public void onClick(View v){
		    	   dismiss();
		     }});
		
		btn_change.setOnClickListener(new View.OnClickListener() {

			@Override
		       public void onClick(View v){
					changeAddress();
					dismiss();
		     }});
		
			
	}
    
    public void changeAddress(){
    	this.setRua(edit_rua.getText().toString().trim());
		this.setNumero(edit_numero.getText().toString().trim());
		this.setBairro(edit_bairro.getText().toString().trim());
		
		changeLabel(this.rua, this.numero, this.bairro);
    }
    
    

	private void changeLabel(String rua, String numero, String bairro) {
		
		setChanges(rua+", "+numero+" - "+bairro);
		InformacoesInfracao.local_infracao.setText(this.changes);
		
	}


	public String getRua() {
		return this.rua;
	}


	public void setRua(String rua) {
		this.rua = rua;
	}
	
	public String getChanges() {
		return this.changes;
	}

	public void setChanges(String changes) {
		this.changes = changes;
	}


	public String getNumero() {
		return this.numero;
	}


	public void setNumero(String numero) {
		this.numero = numero;
	}


	public String getBairro() {
		return this.bairro;
	}


	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

}
