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
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES (1,\'I, Me\',\'�V\',\'�킽�����A �킽��\',\'private, I, me\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(2,\'One\',\'�C�`�A �C�c\',\'�Ђ�-�A �Ђ�.��\',\'one, one radical (no.1)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(3,\'Two\',\'�j�A �W\',\'�ӂ��A �ӂ�.�A �ӂ�����\',\'two, two radical (no.2)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(4,\'Three\',\'�T���A �]�E\',\'�݁A ��.�A �݂�.��\',\'three\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(5,\'Tree\',\'�{�N�A ���N\',\'���A ��-\',\'tree, wood\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(6,\'Money\',\'�L���A �R���A �S��\',\'���ˁA ����-�A -����\',\'gold, money,metal\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(7,\'Circle\',\'�G��\',\'�܂�.���A �܂�A �܂ǁA �܂�.���A �܂�.�₩\',\'circle, yen, round\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(8,\'Person\',\'�W���A �j��\',\'�ЂƁA -��A -��\',\'man; person,human being; mankind; people\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO kanjiTable(stt,shortmean,\'on\',kun,longmean) VALUES(9,\'Now\',\'�R���A �L��\',\'����\',\'now; the present time; just now; soon; immediately; (one) more\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (1,1,\'���B\',\'�킽������\',\'we; us\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (2,1,\'����\',\'�킽������\',\'my address\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (3,1,\'�����g\',\'�킽��������\',\'myself\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (4,1,\'���I\',\'�킽���Ă�\',\'my style; my way; my opinion\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (5,1,\'�����\',\'�킽������\',\'first-person narrative\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (6,1,\'������\',\'�킽���܂�\',\'me too; I also\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (7,2,\'���\',\'�ЂƂ�\',\'one thing\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (8,2,\'��v\',\'������\',\'coincidence; agreement; union; match\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (9,2,\'���\',\'�����΂�\',\'number one; first; first place\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (10,2,\'�ꏏ\',\'��������\',\'together\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (11,2,\'���N\',\'���������˂�\',\'year before last\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (12,2,\'�ꐡ\',\'�������\',\'just a minute;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (13,3,\'��\��\',\'�͂�\',\'twentieth day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (14,3,\'���\',\'�ӂ�\',\'second day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (15,3,\'��l\',\'�ӂ���\',\'two persons\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (16,3,\'��\��\',\'�͂���\',\'20 years old\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (17,3,\'��\',\'�ɂ�\',\'two parts; two copies; the second part\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (18,3,\'���\',\'�ɂ΂�\',\'second; number two; runner-up\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (19,4,\'�O��\',\'�݂���\',\'the third day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (20,4,\'�O�ڎ�\',\'�����؂�\',\'champagne\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (21,4,\'�O�U\',\'���񂵂�\',\'strikeout; strike out; fanning out\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (22,4,\'�O��\',\'����܂�\',\'three flat objects (e.g. tickets, pieces of cloth, etc.)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (23,4,\'�O����\',\'�݂�����\',\'new moon; crescent moon\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (24,4,\'�O��\',\'���񂪂�\',\'March\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (25,5,\'�ؗj��\',\'�����悤��\',\'Thursday\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (26,5,\'�؍�\',\'��������\',\'lumber; timber; wood\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (27,5,\'�ؖ�\',\'���߂�\',\'cotton (material)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (28,5,\'�ؐ�\',\'��������\',\'Jupiter (planet)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (29,5,\'�A��\',\'������\',\'garden shrubs, trees, potted plant\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (30,5,\'����\',\'�Ȃ݂�\',\'roadside tree; row of trees\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (31,6,\'���j��\',\'����悤��\',\'Friday\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (32,6,\'���Z\',\'����䂤\',\'financing; credit transacting; loaning of money; circulation of money\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (33,6,\'����\',\'����\',\'safe; strongbox; cashbox;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (34,6,\'���w��\',\'���傤��������\',\'scholarship; stipend; bursary\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (35,6,\'����\',\'���񂬂�\',\'wages\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (36,6,\'�a��\',\'�悫��\',\'deposit; bank account\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (37,7,\'�~��\',\'����܂�\',\'perfection; harmony; peace;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (38,7,\'�~��\',\'���񂿂イ\',\'column; shaft; cylinder\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (39,7,\'�~�`\',\'���񂯂�\',\'round shape; circle\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (40,7,\'�ȉ~\',\'������\',\'ellipse\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (41,7,\'���~\',\'��������\',\'100,000,000 yen\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (42,7,\'���@�~\',\'�܂ق�����\',\'magic circle\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (43,8,\'�l�`\',\'�ɂ񂬂傤\',\'doll; puppet; figure\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (44,8,\'�l��\',\'���񂱂�\',\'population\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (45,8,\'�l���Ȋw\',\'����Ԃ񂩂���\',\'humanities; social sciences; liberal arts\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (46,8,\'���l\',\'���傤�ɂ�\',\'trader; shopkeeper; merchant\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (47,8,\'���l\',\'�����т�\',\'lover; sweetheart\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (48,8,\'�E�l\',\'������\',\'murder\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (49,9,\'���N\',\'���Ƃ�\',\'this year\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (50,9,\'����\',\'����\',\'this summer; next summer; last summer\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (51,9,\'����\',\'��������\',\'nowadays; recently\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (52,9,\'������\',\'��������\',\'Here I am; I am home!\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (53,9,\'���ɂ�\',\'���܂ɂ�\',\'at any time; soon\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (54,9,\'����\',\'���܂�\',\'before long; even now\')";
		db.execSQL(cmd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
