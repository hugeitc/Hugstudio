package com.hugstudio.chuyenbenlycafe;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.StrictMode;

public class ChuyenBenLyCafeService extends Service {

	public ChuyenBenLyCafeService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate(){
		super.onCreate();
		if (android.os.Build.VERSION.SDK_INT > 9) {
			StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
					.permitAll().build();
			StrictMode.setThreadPolicy(policy);
		}
		MySAXParser myXMLHandler = null;
		try {
			/**
			 * Create a new instance of the SAX parser
			 **/
			SAXParserFactory saxPF = SAXParserFactory.newInstance();
			SAXParser saxP = saxPF.newSAXParser();
			XMLReader xmlR = saxP.getXMLReader();

			URL url = new URL("https://dl.dropboxusercontent.com/u/27529224/chuyenbenlycafe.xml"); 

			/**
			 * Create the Handler to handle each of the XML tags.
			 **/
			myXMLHandler = new MySAXParser();
			xmlR.setContentHandler(myXMLHandler);
			xmlR.parse(new InputSource(url.openStream()));

		} catch (Exception e) {
			System.out.println(e);
		} finally {
			List<YoutubeObj> lstVideo = new ArrayList<YoutubeObj>(myXMLHandler.lstVideo);
			YoutubeDatabaseHelper dbHelper = new YoutubeDatabaseHelper(getApplicationContext());
			int recordCount = dbHelper.getNumberOfVideo();
			if(recordCount<lstVideo.size()){
				for(int i=recordCount;i<lstVideo.size();i++){
					dbHelper.insertVideo(lstVideo.get(i));
				}
			}
			dbHelper.close();
		}
	}
}
