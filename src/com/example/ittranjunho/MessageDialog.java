package com.example.ittranjunho;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MessageDialog extends Dialog {
	String msg, tittle;
	TextView msg_view;
	Button ok;
	 
    public MessageDialog(Context context, String message, String tittle) {
        super(context);
        this.setTittle(tittle);
        this.setMessage(message);
    }
 
 
    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_message_dialog);
		getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.title_dialog_photos);
		
		msg_view = (TextView) findViewById(R.id.message);
		ok = (Button) findViewById(R.id.btn_ok_dialog);
		
		msg_view.setText(getMessage());
		
		ok.setOnClickListener(new View.OnClickListener() {
		       @Override
		       public void onClick(View v){
		    	   dismiss();
		     }});
		
			
	}


	public String getMessage() {
		return this.msg;
	}


	public void setMessage(String msg) {
		this.msg = msg;
	}
	
	public String getTittle() {
		return this.tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
}
