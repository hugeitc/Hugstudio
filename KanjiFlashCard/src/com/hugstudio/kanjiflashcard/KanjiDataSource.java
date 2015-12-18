package com.hugstudio.kanjiflashcard;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class KanjiDataSource {
	private SQLiteDatabase database;
	  private DatabaseHandler dbHelper;

	public KanjiDataSource(Context context) {
		// TODO Auto-generated constructor stub
		dbHelper = new DatabaseHandler(context);
	}
	
	public void open() throws SQLException{
		database = dbHelper.getWritableDatabase();
	}
	public void close() throws SQLException{
		dbHelper.close();
	}

	public KanjiWord getKanjiWord(int stt){
		
		Cursor cursor = database.rawQuery("Select * FROM kanjitable WHERE stt ="+stt, null);
		
		if(cursor!=null){
			cursor.moveToFirst();
		}
		
		KanjiWord kanji = new KanjiWord(cursor.getInt(0)+"", cursor.getString(1), cursor.getString(4), cursor.getString(2), cursor.getString(3));
		return kanji;
		
	}
	
	public String[] getKanjiSample(int stt, int colIndex){
		
		String[] kanjiList = new String[6];
		Cursor cursor = database.rawQuery("Select * FROM sampletable WHERE kanjistt ="+stt, null);
		
		if(cursor!=null){
			cursor.moveToFirst();
		}
		for(int i=0;i<cursor.getCount();i++){
			kanjiList[i] = cursor.getString(colIndex);
			cursor.moveToNext();
		}
		return kanjiList;
		
	}
}
