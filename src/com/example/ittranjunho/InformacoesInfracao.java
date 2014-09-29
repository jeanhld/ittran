package com.example.ittranjunho;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Locale;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.format.Time;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class InformacoesInfracao extends Activity {
	
	 // Activity request codes
	static final int REQUEST_IMAGE_CAPTURE = 1;
    private static final int ONLY_STREET = 1;
    private static final int STREET_ONENUMB_NEIGHBORHOOD = 2;
    private static final int STREET_TWONUMB_NEIGHBORHOOD = 3;
    
    boolean first = true;
    boolean imgC1 = false,imgC2 = false,imgC3 = false,imgC4 = false;
    static String streetGps, name;
    static Uri uriSavedImage;
    
	final Context context = this;
	EditText edit_rua, edit_numero, edit_bairro, edit_cidade_estado;
	
	//Definindo as variáveis e seus tipos
	static TextView local_infracao, id_infracao;
	EditText observacoes;
	Button button_next2, button_back1, button_edit, button_cancel, button_change, buttonCamera;
	ImageView imgCam1,imgCam2,imgCam3,imgCam4;
	Uri uriImg1 = null,uriImg2 = null,uriImg3 = null,uriImg4 = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_informacoes_infracao);
		
		//Mensagem com os dados do formulário
		//Toast.makeText(getBaseContext(), Lista.Final, Toast.LENGTH_LONG).show();

		//Cria button up na action-bar
		ActionBar actionBar = getActionBar();
	    actionBar.setDisplayHomeAsUpEnabled(true);
	    
	    // Inicia serviço de GPS para obter endereço atual
	    InitGps();
	    
		
		// Atribuindo os valores das id às variáveis
	    local_infracao = (TextView) findViewById(R.id.edit_local_infracao);
	    id_infracao = (TextView) findViewById(R.id.lbl_id_infracao);
        observacoes = (EditText) findViewById(R.id.txt_observacao);
		button_back1=(Button)findViewById(R.id.button_back1); 
		button_next2=(Button)findViewById(R.id.button_next2); 
		button_edit=(Button)findViewById(R.id.btn_edit);
		buttonCamera=(Button)findViewById(R.id.buttonCamera);
		imgCam1=(ImageView)findViewById(R.id.imgCam1);
		imgCam2=(ImageView)findViewById(R.id.imgCam2);
		imgCam3=(ImageView)findViewById(R.id.imgCam3);
		imgCam4=(ImageView)findViewById(R.id.imgCam4);
		
		
		// FUNCIONALIDADE DOS BOTÕES
		// Button Back - redireciona para a tela de Informações do Veículo
	    button_back1.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	     	   Intent Iniciar = new Intent(InformacoesInfracao.this,InformacoesVeiculo.class);
	     	   InformacoesInfracao.this.startActivity(Iniciar);
	     	   InformacoesInfracao.this.finish();
	     }});
	    
	    // Button Next - redireciona para a tela de Informações do Condutor
	    button_next2.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	    	   
	    	   // Adiciona os elementos na Classe Infracao
	    	   Infracao.setLocal(local_infracao.getText().toString());
	    	   Infracao.setInfracao(id_infracao.getText().toString());
	    	   Infracao.setObs(observacoes.getText().toString());
	    	   
	    	   addUriList();
	      	   
	     	   Intent Iniciar = new Intent(InformacoesInfracao.this,InformacoesCondutor.class);
	     	   InformacoesInfracao.this.startActivity(Iniciar);
	     	   finish();
	     	   
	     }});
	    
	    
	    
	    // Button Edit - redireciona para a tela Editar Local da Infração
	   button_edit.setOnClickListener(new View.OnClickListener() {

	    	// Chamando o evento onClick para acessar a tela Editar Local da Infração
	    	@Override
	    	public void onClick(View v){
	    		
	    		String[] list = getSplitAddress(local_infracao.getText().toString());
	    		String rua = list[0];
	    		String numero = list[1];
	    		String bairro = list[2];

	    		EditLocalInfracao mydialog = new EditLocalInfracao(context, rua, numero, bairro);
	            mydialog.show();
	    	}
	    });
	   
	   buttonCamera.setOnClickListener(new View.OnClickListener() {
	       @Override
	       public void onClick(View v){
	    	   if(ifFreeCam()){
	    		   captureImage();
	    	   }
	    	   else{
	    		   MessageDialog dialog = new MessageDialog(context, "Você pode adicionar somente 4 fotos.", "");
	    		   dialog.show();
	    	   }    	  
	     }});
	    
	}
	
	public void InitGps(){
		final LocationManager locationManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        LocationListener locationListener = new LocationListener() {
            public void onLocationChanged(Location location) {
            	if(first == true){
            		first = false;
            		getAddress(location.getLatitude(), location.getLongitude());
            	}
            	else{
            		locationManager.removeUpdates(this);
            		return;
            	}
            }
            public void onStatusChanged(String provider, int status, Bundle extras) {}
            public void onProviderEnabled(String provider) {}
            public void onProviderDisabled(String provider) {}
          };
          locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 0, locationListener);	
	}
	
	public void getAddress(double latitude, double longitude){
		Address address = null;
		Geocoder geocoder = new Geocoder(this, Locale.getDefault());
		try {
			List<Address> addresses = geocoder.getFromLocation(latitude, longitude, 1);
			address = addresses.get(0);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		streetGps = address.getAddressLine(0);
		local_infracao.setText(streetGps);
		
	}
	
	public void captureImage() {
		Time date = new Time();
		date.setToNow();
		InformacoesInfracao.name = date.format("%d%m%Y_%H%M%S")+".jpg";
		
		/*File imagesFolder = new File(Environment.getExternalStorageDirectory(), "Imagens_Multas");
	    imagesFolder.mkdirs(); 
	    File output = new File(imagesFolder, InformacoesInfracao.name);
	    Uri uriSavedImage = Uri.fromFile(output);	*/
		
		Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		//takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
	    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);

	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{
	    super.onActivityResult(requestCode, resultCode, data);
	    if (resultCode == RESULT_OK)
	    {
	    	Bitmap bitmap = null;
	        Uri imageUri = data.getData();
	        try {
				bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        final Uri contentUri = data.getData();
            final String[] proj = { MediaStore.Images.Media.DATA};
            final Cursor cursor = managedQuery(contentUri, proj, null, null, null);
            final int column_index = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
            cursor.moveToLast();
            final String path = cursor.getString(column_index);
	        setImage(bitmap, Uri.parse(path));
	    }
	}
	
	private void setImage(Bitmap img, Uri uri_img) {
		if(this.imgC1 == false){
	    	imgCam1.setImageBitmap(img);
	    	this.imgC1 = true;
	    	this.uriImg1 = uri_img;
	    }
	    else if(this.imgC2 == false){
	    	imgCam2.setImageBitmap(img);
	    	this.imgC2 = true;
	    	this.uriImg2 = uri_img;
	    }
	    else if(this.imgC3 == false){
	    	imgCam3.setImageBitmap(img);
	    	this.imgC3 = true;
	    	this.uriImg3 = uri_img;
	    }
	    else if(this.imgC4 == false){
	    	imgCam4.setImageBitmap(img);
	    	this.imgC4 = true;
	    	this.uriImg4 = uri_img;
	    }
		
	}
	
	public boolean ifFreeCam(){
		return this.imgC4 == false;	
	}
	
	public void dialogFullPhotos(Context ctx){
		AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
		builder.setMessage("Você só pode adicionar 4 fotos.").setTitle("asd");
		builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
	           public void onClick(DialogInterface dialog, int id) {
	               dialog.cancel();
	           }
	       });
		AlertDialog dialog = builder.create();
	}

	public String[] getSplitAddress(String endereco){
		String[] list = {"","",""};
		int length = getLengthList(endereco);
		if(length == ONLY_STREET){
			list[0] = endereco;
		}
		if(length == STREET_ONENUMB_NEIGHBORHOOD){
			String[] ruaSplit = endereco.split(","); 
			list[0] = ruaSplit[0];
	    	String[] bairroSplit = ruaSplit[1].split("-");
	    	list[1] = bairroSplit[0];
	    	list[2] = bairroSplit[1];
		}
		if(length == STREET_TWONUMB_NEIGHBORHOOD){
			String[] ruaSplit = endereco.split(","); 
			list[0] = ruaSplit[0];
	    	String[] bairroSplit = ruaSplit[1].split("-");
	    	list[1] = bairroSplit[0]+"-"+bairroSplit[1];
	    	list[2] = bairroSplit[2];
		}
		return list;
	}
	
	public int getLengthList(String endereco){
		String[] list = endereco.split("-");
		int lengthList = list.length;
		return lengthList;
	}
	
	public void addUriList(){
		if(this.imgC1 != false){
			Infracao.setFt1(this.uriImg1.toString());
		}
		if(this.imgC2 != false){
			Infracao.setFt2(this.uriImg2.toString());
		}
		if(this.imgC3 != false){
			Infracao.setFt3(this.uriImg3.toString());
		}
		if(this.imgC4 != false){
			Infracao.setFt4(this.uriImg4.toString());
		}
	}
	
		
}
