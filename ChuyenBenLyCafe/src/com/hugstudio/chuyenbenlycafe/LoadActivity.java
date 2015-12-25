package com.hugstudio.chuyenbenlycafe;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.content.Intent;
//import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;

public class LoadActivity extends Activity{

	//private List<YoutubeObj> lstVideo = new ArrayList<YoutubeObj>();
	
	public LoadActivity() {
		// TODO Auto-generated constructor stub
	}
	
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loading_layout);
		checkFirstRun();
		Intent intent = new Intent(this, MainActivity.class);

		startActivity(intent);
	}
	
	
	private void checkFirstRun() {

		/*final String PREFS_NAME = "MyPrefsFile";
		final String PREF_VERSION_CODE_KEY = "version_code";
		final int DOESNT_EXIST = -1;

		// Get current version code
		int currentVersionCode = 0;
		try {
			currentVersionCode = getPackageManager().getPackageInfo(
					getPackageName(), 0).versionCode;
		} catch (android.content.pm.PackageManager.NameNotFoundException e) {
			// handle exception
			e.printStackTrace();
			return;
		}

		// Get saved version code
		SharedPreferences prefs = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
		int savedVersionCode = prefs
				.getInt(PREF_VERSION_CODE_KEY, DOESNT_EXIST);

		// Check for first run or upgrade
		if (currentVersionCode == savedVersionCode) {
			// This is just a normal run
			YoutubeDatabaseHelper dataHelper = new YoutubeDatabaseHelper(this);
			lstVideo =  dataHelper.getAllVideo();

			return;

		} else if (savedVersionCode == DOESNT_EXIST) {
*/
			// TODO This is a new install (or the user cleared the shared
			// preferences)
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
				YoutubeDatabaseHelper dbHelper = new YoutubeDatabaseHelper(this);
				int recordCount = dbHelper.getNumberOfVideo();
				if(recordCount<lstVideo.size()){
					for(int i=recordCount;i<lstVideo.size();i++){
						dbHelper.insertVideo(lstVideo.get(i));
					}
				}
				dbHelper.close();
			}
			//YoutubeDatabaseHelper dataHelper = new YoutubeDatabaseHelper(this);
			//lstVideo = new ArrayList<YoutubeObj>(dataHelper.getAllVideo());
			

/*		} else if (currentVersionCode > savedVersionCode) {

			// TODO This is an upgrade

		}

		// Update the shared preferences with the current version code
		prefs.edit().putInt(PREF_VERSION_CODE_KEY, currentVersionCode).commit();
*/
	}

}
