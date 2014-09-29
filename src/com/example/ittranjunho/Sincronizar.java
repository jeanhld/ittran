/*package com.example.ittranjunho;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import com.example.ittranjunho.ClientRestEnviaDados.HttpAsyncTask;

import android.app.ActionBar;
import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Sincronizar extends ClientRestEnviaDados {

	
	Button enviar;
	
	DadosMulta dados_multa;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sincronizar);
		
		//Cria button up na action-bar
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    
	    // Atribuindo os valores das id às variáveis
		button_enviar = (Button)findViewById(R.id.button_enviar); 
	
		button_enviar.setOnClickListener(this);
	    
	    
	}

	public static String POST(String url, DadosMulta dados_multa){
		InputStream inputStream = null;
		String result = "";
		try {
			
			// 1. create HttpClient
			HttpClient httpclient = new DefaultHttpClient();
			
			// 2. make POST request to the given URL
		    HttpPost httpPost = new HttpPost(url);
		    
		    String json = "";
		    

		    // 3. build jsonObject
		    JSONObject jsonObject = new JSONObject();
		    // Condutor
		    jsonObject.accumulate("nome_condutor", dados_multa.getNomeCondutor());
		    jsonObject.accumulate("cnh_ppd", dados_multa.getCnhPpd());
		    jsonObject.accumulate("cpf_rg", dados_multa.getCpfRg());
		    jsonObject.accumulate("nf", dados_multa.getNF());
		    
		    // 4. convert JSONObject to JSON to String
		    json = jsonObject.toString();

		    
		    // ** Alternative way to convert Person object to JSON string usin Jackson Lib 
		    // ObjectMapper mapper = new ObjectMapper();
		    // json = mapper.writeValueAsString(person); 
		    
		    // 5. set json to StringEntity
		    StringEntity se = new StringEntity(json);
		    
		    // 6. set httpPost Entity
		    httpPost.setEntity(se);
		    
		    // 7. Set some headers to inform server about the type of the content   
		    httpPost.setHeader("Accept", "application/json");
		    httpPost.setHeader("Content-type", "application/json");
		    
			// 8. Execute POST request to the given URL
			HttpResponse httpResponse = httpclient.execute(httpPost);
			
			// 9. receive response as inputStream
			inputStream = httpResponse.getEntity().getContent();
			
		    
			// 10. convert inputstream to string
			if(inputStream != null)
				result = convertInputStreamToString(inputStream);
			else
				result = "Did not work!";
		
		} catch (Exception e) {
			Log.d("InputStream", e.getLocalizedMessage());
		}
		return result;
	}
	
	 @Override
		public void onClick(View view) {
		
			switch(view.getId()){
				case R.id.button_save:
					if(!validate())
						Toast.makeText(getBaseContext(), "Alguns campos obrigatórios não foram preenchidos!", Toast.LENGTH_LONG).show();
					// call AsynTask to perform network operation on separate thread
					new HttpAsyncTask().execute("http://192.168.119.242:8000/rest/");
				break;
			}
			
		}
	
    public boolean isConnected(){
    	ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
    	    NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
    	    if (networkInfo != null && networkInfo.isConnected()) 
    	    	return true;
    	    else
    	    	return false;	
    }
   
    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
             
        	dados_multa = new DadosMulta();
        	// Condutor
        	dados_multa.setNomeCondutor(nome_condutor.getText().toString());
        	dados_multa.setCnhPpd(cnh_ppd.getText().toString());
        	dados_multa.setCpfRg(cpf_rg.getText().toString());
        	dados_multa.setCpfRg(nf.getText().toString());

            return POST(urls[0],dados_multa);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
        	Toast.makeText(getBaseContext(), "Multa salva com sucesso!", Toast.LENGTH_LONG).show();
       }
    }
	
	
	private boolean validate(){
		// Condutor
		if(nome_condutor.getText().toString().trim().equals(""))
			return false;
		else if(cnh_ppd.getText().toString().trim().equals(""))
			return false;
		else if(cpf_rg.getText().toString().trim().equals(""))
			return false;
		else if(nf.getText().toString().trim().equals(""))
			return false;
		
		else
			return true;	
	}
	private static String convertInputStreamToString(InputStream inputStream) throws IOException{
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;
        
        inputStream.close();
        return result;
        
    }
	
	
	
	

}
*/