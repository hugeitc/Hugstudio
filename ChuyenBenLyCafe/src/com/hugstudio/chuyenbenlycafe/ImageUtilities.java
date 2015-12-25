package com.hugstudio.chuyenbenlycafe;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ImageUtilities {

	public ImageUtilities() {
		// TODO Auto-generated constructor stub
	}
	
	public static byte[] downloadBitmap(String _url) throws IOException{

		URL url = new URL("http://img.youtube.com/vi/"+_url+"/hqdefault.jpg");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		con.setReadTimeout(10000);
		con.setConnectTimeout(10000);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
			Bitmap b = BitmapFactory.decodeStream(con.getInputStream());
			b.compress(Bitmap.CompressFormat.JPEG, 100, bos);
		} finally {
			con.disconnect();
		}
		return bos.toByteArray();
	}
	
	public static Bitmap createBitmapFromByteArray(byte[] data){
		Bitmap bmp;
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inMutable = true;
		bmp = BitmapFactory.decodeByteArray(data, 0, data.length, options);
		return bmp;
	}

}
