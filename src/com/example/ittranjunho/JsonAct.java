package com.example.ittranjunho;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.output.ByteArrayOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Environment;
import android.util.Base64;

public class JsonAct{
	String arquivo,numMulta;
	JSONObject json,cabecalho_json,veiculo_json,infracao_json,condutor_json;
	String agente,placa,infracao,modelo,marca,data,especie,tipo,obs,local,uri_foto1,uri_foto2,uri_foto3,uri_foto4,
	cidade,uf,condutor,cpf_rg,cnh_ppd;
	String radio_cnh, radio_ppd,radio_cpf,radio_rg;
	
	private Context context;
	
	JsonAct(Context context){
		this.context = context;
	}
	
	public void insertMultaRUCC() throws JSONException{
		json = new JSONObject();
		
		// Criar dicionario de cabeçalho da multa
		cabecalho_json = createCabecalho();
		
		// Criar dicionario de Informacoes do Veiculo
		veiculo_json = createVeiculo();
		
		// Criar dicionario de Informacoes da Infracao
		infracao_json = createInfracao();
		
		//Criar dicionario de Informacoes do Condutor
		condutor_json = createCondutor();

		// Insere os dicionarios criados no arquivo json
		json.put("cabecalho", cabecalho_json);
		json.put("veiculo", veiculo_json);
		json.put("infracao", infracao_json);
		json.put("condutor", condutor_json);
		
		try {
			
			writeFile("RUCC-"+getDate()+".json");
	 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void insertMultaRUSC() throws JSONException{	

		json = new JSONObject();
		
		// Criar dicionario de Informacoes do Veiculo
		veiculo_json = createVeiculo();
		
		// Criar dicionario de Informacoes da Infracao
		infracao_json = createInfracao();
		
		//Criar dicionario de Informacoes do Condutor
		condutor_json = createCondutor();

		// Insere os dicionarios criados no arquivo json
		json.put("veiculo", veiculo_json);
		json.put("infracao", infracao_json);
		json.put("condutor", condutor_json);
		
		try {
			writeFile("RUSC-"+getDate()+".json");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public void insertMultaRMCC() throws JSONException, IOException{
		JSONObject multa = new JSONObject();
		
		// Criar dicionario de cabeçalho da multa
		cabecalho_json = createCabecalho();
		
		// Criar dicionario de Informacoes do Veiculo
		veiculo_json = createVeiculo();
		
		// Criar dicionario de Informacoes da Infracao
		infracao_json = createInfracao();
		
		//Criar dicionario de Informacoes do Condutor
		condutor_json = createCondutor();

		// Insere os dicionarios criados no arquivo json
		multa.put("cabecalho", cabecalho_json);
		multa.put("veiculo", veiculo_json);
		multa.put("infracao", infracao_json);
		multa.put("condutor", condutor_json);
		
		File jsonOld = new File(Environment.getExternalStorageDirectory(), "RMCC.json");
		if(jsonOld.exists()){
	        FileInputStream stream = new FileInputStream(jsonOld);
	        String jsonStr = null;
	        try {
	            FileChannel fc = stream.getChannel();
	            MappedByteBuffer bb = fc.map(FileChannel.MapMode.READ_ONLY, 0, fc.size());
	
	            jsonStr = Charset.defaultCharset().decode(bb).toString();
	          }
	          finally {
	            stream.close();
	          }
		
			
			String myjson_stampi = jsonStr.toString();
			                      
	        JSONObject jsonObjMain = new JSONObject(myjson_stampi);
	
	        JSONArray jsonArray_stampi = jsonObjMain.getJSONArray("multas");
	
	        jsonArray_stampi.put( multa );
	            
	        json = new JSONObject();
	        json.put("multas", jsonArray_stampi);
		}
            
        writeFile("RMCC.json");
	}
	
	public void writeFile(String name) throws IOException{
		
		FileWriter file = new FileWriter("../sdcard0/multas/"+name);
		file.write(json.toString());
		file.flush();
		file.close();
	
	}
	
	public JSONObject createVeiculo() throws JSONException{
		JSONObject json_vei = new JSONObject();
		json_vei.put("placa", Infracao.getPlaca()); 
		json_vei.put("cidade", Infracao.getCidade());
		json_vei.put("estado", Infracao.getUF());
		json_vei.put("especie", Infracao.getEspecie());
		json_vei.put("tipo", Infracao.getTipo());
		json_vei.put("marca", Infracao.getMarca());
		json_vei.put("modelo", Infracao.getModelo());
		
		return json_vei;
	}
	
	public JSONObject createInfracao() throws JSONException{
		JSONObject json_infra = new JSONObject();
		json_infra.put("local", Infracao.getLocal());
		json_infra.put("infracao", Infracao.getInfracao());
		json_infra.put("observacao", Infracao.getObs());
		if (Infracao.getFt1() != null){
			try {
				json_infra.put("foto1", converToByte(Infracao.getFt1().toString()));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return json_infra;
	}

	public JSONObject createCondutor() throws JSONException{
		JSONObject json_cond = new JSONObject();
		json_cond.put("nome", Infracao.getCondutor());
		json_cond.put("boolean_cnh", Infracao.getRadioCnh());
		json_cond.put("boolean_ppd", Infracao.getRadioPpd());
		json_cond.put("boolean_cpf", Infracao.getRadioCpf());
		json_cond.put("boolean_rg", Infracao.getRadioRg());
		json_cond.put("cnh_ppd", Infracao.getCnhPpd());
		json_cond.put("cpf_rg", Infracao.getCpfRg());
		
		return json_cond;
	}
	
	public JSONObject createCabecalho() throws JSONException{
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		String[] date_split= date.toString().split(" "); 
		this.arquivo = date.toString();
		// splitString(lista);
		
		JSONObject json_cab = new JSONObject();
		json_cab.put("idDispositivo", "id");
		json_cab.put("idAgente", "id_do_agente");
		json_cab.put("data", date_split[0]);
		json_cab.put("hora", date_split[1]);
		
		return json_cab;
	}
	
	public String getNumMulta(JSONObject json){
		 return Integer.toString(json.length()+1);
	}
	
	public String getDate(){
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date date = new Date();
		
		return date.toString();
	}
	
	private String converToByte(String uri_foto) throws FileNotFoundException {
		InputStream inputStream = new FileInputStream(uri_foto);
		byte[] bytes;
		byte[] buffer = new byte[8192];
		int bytesRead;
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		try {
		    while ((bytesRead = inputStream.read(buffer)) != -1) {
		    output.write(buffer, 0, bytesRead);
		}
		} catch (IOException e) {
		e.printStackTrace();
		}
		bytes = output.toByteArray();
		String encodedString = Base64.encodeToString(bytes, Base64.DEFAULT);
		
		return encodedString;
	}
}
