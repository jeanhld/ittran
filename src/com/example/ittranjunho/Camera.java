package com.example.ittranjunho;

import java.io.File;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

public class Camera extends Activity {
	
	static int PHOTO_ID = 0; 
	final String FOLDER = "Imagens Ittran";
	String PHOTO_NAME;
	
	Camera(String name){
		this.PHOTO_NAME = name;
	}
	
	public static void nextPhotoID(){
		PHOTO_ID += 1;
		
	}
	
	public String getPhotoName(){
		return this.PHOTO_NAME+"_"+PHOTO_ID;
	}
	
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		Intent imageIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
		File imagesFolder = new File(Environment.getExternalStorageDirectory(), FOLDER);
	    imagesFolder.mkdirs();
	    File image = new File(imagesFolder, getPhotoName());
	    Uri uriSavedImage = Uri.fromFile(image);
	    imageIntent.putExtra(MediaStore.EXTRA_OUTPUT, uriSavedImage);
	    startActivityForResult(imageIntent,0);
	
	}
	
}
