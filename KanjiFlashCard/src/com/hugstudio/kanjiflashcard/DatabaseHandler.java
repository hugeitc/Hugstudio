package com.hugstudio.kanjiflashcard;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {

	private static final String DATABASE_NAME = "kanjiflashcard.db";
	private static final int DATABASE_VERSION = 1;
	
	public DatabaseHandler(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String cmd = "CREATE TABLE \'kanjiTable\' (\'stt\'	INTEGER NOT NULL,\'shortmean\'	TEXT,\'on\'	TEXT,\'kun\'	TEXT,\'longmean\'	TEXT,PRIMARY KEY(stt))";
		db.execSQL(cmd);
		cmd = "CREATE TABLE \'SampleTable\' (\'id\'	INTEGER NOT NULL,\'kanjiSTT\'	INTEGER NOT NULL,\'kanji\'	TEXT,\'romanji\'	TEXT,\'mean\'	INTEGER,PRIMARY KEY(id,kanjiSTT))";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES (1,\'I, Me\',\'シ\',\'わたくし、 わたし\',\'private, I, me\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(2,\'One\',\'イチ、 イツ\',\'ひと-、 ひと.つ\',\'one, one radical (no.1)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(3,\'Two\',\'ニ、 ジ\',\'ふた、 ふた.つ、 ふたたび\',\'two, two radical (no.2)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(4,\'Three\',\'サン、 ゾウ\',\'み、 み.つ、 みっ.つ\',\'three\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(5,\'Tree\',\'ボク、 モク\',\'き、 こ-\',\'tree, wood\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(6,\'Money\',\'キン、 コン、 ゴン\',\'かね、 かな-、 -がね\',\'gold, money,metal\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(7,\'Circle\',\'エン\',\'まる.い、 まる、 まど、 まど.か、 まろ.やか\',\'circle, yen, round\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(8,\'Person\',\'ジン、 ニン\',\'ひと、 -り、 -と\',\'man; person,human being; mankind; people\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(9,\'Now\',\'コン、 キン\',\'いま\',\'now; the present time; just now; soon; immediately; (one) more\')";
		db.execSQL(cmd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
