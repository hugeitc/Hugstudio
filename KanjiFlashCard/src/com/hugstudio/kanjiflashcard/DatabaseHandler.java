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
		cmd = "INSERT INTO SampleTable VALUES (1,1,\'私達\',\'わたしたち\',\'we; us\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (2,1,\'私宛\',\'わたしあて\',\'my address\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (3,1,\'私自身\',\'わたしじしん\',\'myself\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (4,1,\'私的\',\'わたしてき\',\'my style; my way; my opinion\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (5,1,\'私語り\',\'わたしがた\',\'first-person narrative\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (6,1,\'私も亦\',\'わたしまた\',\'me too; I also\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (7,2,\'一つ\',\'ひとつ\',\'one thing\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (8,2,\'一致\',\'いっち\',\'coincidence; agreement; union; match\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (9,2,\'一番\',\'いちばん\',\'number one; first; first place\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (10,2,\'一緒\',\'いっしょ\',\'together\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (11,2,\'一昨年\',\'いっさくねん\',\'year before last\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (12,2,\'一寸\',\'ちょっと\',\'just a minute;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (13,3,\'二十日\',\'はつか\',\'twentieth day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (14,3,\'二日\',\'ふつか\',\'second day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (15,3,\'二人\',\'ふたり\',\'two persons\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (16,3,\'二十歳\',\'はたち\',\'20 years old\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (17,3,\'二部\',\'にぶ\',\'two parts; two copies; the second part\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (18,3,\'二番\',\'にばん\',\'second; number two; runner-up\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (19,4,\'三日\',\'みっか\',\'the third day of the month\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (20,4,\'三鞭酒\',\'しゃんぺん\',\'champagne\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (21,4,\'三振\',\'さんしん\',\'strikeout; strike out; fanning out\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (22,4,\'三枚\',\'さんまい\',\'three flat objects (e.g. tickets, pieces of cloth, etc.)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (23,4,\'三日月\',\'みかずき\',\'new moon; crescent moon\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (24,4,\'三月\',\'さんがつ\',\'March\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (25,5,\'木曜日\',\'もくようび\',\'Thursday\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (26,5,\'木材\',\'もくざい\',\'lumber; timber; wood\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (27,5,\'木綿\',\'もめん\',\'cotton (material)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (28,5,\'木星\',\'もくせい\',\'Jupiter (planet)\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (29,5,\'植木\',\'うえき\',\'garden shrubs, trees, potted plant\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (30,5,\'並木\',\'なみき\',\'roadside tree; row of trees\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (31,6,\'金曜日\',\'きんようび\',\'Friday\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (32,6,\'金融\',\'きんゆう\',\'financing; credit transacting; loaning of money; circulation of money\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (33,6,\'金庫\',\'きんこ\',\'safe; strongbox; cashbox;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (34,6,\'奨学金\',\'しょうがくきん\',\'scholarship; stipend; bursary\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (35,6,\'賃金\',\'ちんぎん\',\'wages\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (36,6,\'預金\',\'よきん\',\'deposit; bank account\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (37,7,\'円満\',\'えんまん\',\'perfection; harmony; peace;\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (38,7,\'円柱\',\'えんちゅう\',\'column; shaft; cylinder\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (39,7,\'円形\',\'えんけい\',\'round shape; circle\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (40,7,\'楕円\',\'だえん\',\'ellipse\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (41,7,\'億円\',\'おくえん\',\'100,000,000 yen\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (42,7,\'魔法円\',\'まほうえん\',\'magic circle\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (43,8,\'人形\',\'にんぎょう\',\'doll; puppet; figure\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (44,8,\'人口\',\'じんこう\',\'population\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (45,8,\'人文科学\',\'じんぶんかがく\',\'humanities; social sciences; liberal arts\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (46,8,\'商人\',\'しょうにん\',\'trader; shopkeeper; merchant\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (47,8,\'恋人\',\'こいびと\',\'lover; sweetheart\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (48,8,\'殺人\',\'さつじん\',\'murder\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (49,9,\'今年\',\'ことし\',\'this year\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (50,9,\'今夏\',\'こんか\',\'this summer; next summer; last summer\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (51,9,\'昨今\',\'さっこん\',\'nowadays; recently\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (52,9,\'ただ今\',\'ただいま\',\'Here I am; I am home!\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (53,9,\'今にも\',\'いまにも\',\'at any time; soon\')";
		db.execSQL(cmd);
		cmd = "INSERT INTO SampleTable VALUES (54,9,\'今に\',\'いまに\',\'before long; even now\')";
		db.execSQL(cmd);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
