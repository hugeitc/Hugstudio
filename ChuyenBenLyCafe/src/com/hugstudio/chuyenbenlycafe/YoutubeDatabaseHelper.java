package com.hugstudio.chuyenbenlycafe;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class YoutubeDatabaseHelper extends SQLiteOpenHelper {

	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "chuyenbenlycafe";
	private static final String TAG = null;
	public static YoutubeDatabaseHelper sInstance;
	
	public static synchronized YoutubeDatabaseHelper getInstance(Context context){
		if(sInstance == null){
			sInstance = new YoutubeDatabaseHelper(context.getApplicationContext());
		}
		return sInstance;
	}

	public YoutubeDatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String _sql = "CREATE TABLE youtube(\'id\' INTEGER PRIMARY KEY AUTOINCREMENT, \'subject\' TEXT, \'url\' TEXT, \'visitor\' TEXT, \'thumbnail\' BLOB, \'status\' INTEGER)";
		db.execSQL(_sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		String query;
		query = "DROP TABLE IF EXISTS youtube";
		db.execSQL(query);
		onCreate(db);
	}
	
	public int getNumberOfVideo(){
		int sum = -1;
		
		SQLiteDatabase db = getReadableDatabase();
		String _sql = "SELECT * FROM youtube";
		Cursor cursor = db.rawQuery(_sql, null);
		if(cursor!=null){
			sum = cursor.getCount();
		}
		return sum;
	}
	
	public List<YoutubeObj> getAllVideo(){
		List<YoutubeObj> lstVideo = new ArrayList<YoutubeObj>();
		
		String _sql = "SELECT * FROM youtube ORDER BY id DESC";
		
		SQLiteDatabase db = getReadableDatabase();
		Cursor cursor = db.rawQuery(_sql, null);
		try{
			if(cursor.moveToFirst()){
				do{
					YoutubeObj video = new YoutubeObj();
					video.setSubject(cursor.getString(1));
					video.setUrl(cursor.getString(2));
					video.setVisitor(cursor.getString(3));
					video.setImg(cursor.getBlob(4));
					video.setStatus(cursor.getInt(5));
					lstVideo.add(video);
				}while(cursor.moveToNext());
			}
		}catch (Exception e) {
			// TODO: handle exception
			Log.d(TAG, "Error while trying to add post to database");
		}finally{
			if(cursor!=null && !cursor.isClosed()){
				cursor.close();
			}
		}
		db.close();
		return lstVideo;
	}
	
	public void insertVideo(YoutubeObj video){
		//String _sql = "INSERT INTO youtube(\'subject\',\'url\',\'visitor\',\'thumbnail\',\'status\') VALUES(\'"+video.getSubject()+"\',\'"+video.getUrl()+"\',\'"+video.getVisitor()+"\',?,0)";
		String _sql = "SELECT * FROM youtube WHERE \'url\' = \'"+video.getUrl()+"\'";
		SQLiteDatabase db  = getWritableDatabase();
		Cursor cursor = db.rawQuery(_sql, null);
		if(!(cursor.moveToFirst() && cursor.getCount()>0)){
			ContentValues values = new ContentValues();
			values.put("subject", video.getSubject());
			values.put("url", video.getUrl());
			values.put("visitor", video.getVisitor());
			values.put("thumbnail", video.getImg());
			values.put("status", 0);
			//db.execSQL(_sql,video.getImg());
			db.insert("youtube", null, values);
		}
		db.close();
	}
	public void updateVideoStatus(int fromStatus, int toStatus){
		String _sql = "UPDATE youtube SET \'status\' = "+toStatus +"WHERE \'status\' = "+fromStatus;
		
		SQLiteDatabase db = getWritableDatabase();
		db.execSQL(_sql);
		db.close();
	}

}
