package com.hugstudio.kanjiflashcard;

import java.util.Random;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	KanjiDataSource dataSource;
	KanjiWord kanji,kanji1,kanji2;
	int randomNum,randomNum1,randomNum2;
	String[] sampleList;
	
	public MainActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		dataSource = new KanjiDataSource(this);
		if(savedInstanceState==null){
			Intent intent = getIntent();
			Bundle bd = intent.getExtras();
			if(bd == null){
				
				dataSource.open();
				/**
				 * random kanji in database
				 */
				randomNum = new Random().nextInt((8) + 1) + 1;
				randomNum1	 = new Random().nextInt((8) + 1) + 1;
				while(randomNum1==randomNum){
					randomNum1	 = new Random().nextInt((8) + 1) + 1;
				}
				randomNum2 = new Random().nextInt((8) + 1) + 1;
				while(randomNum2==randomNum || randomNum2 == randomNum1){
					randomNum2 = new Random().nextInt((8) + 1) + 1;
				}
				kanji = new KanjiWord(dataSource.getKanjiWord(randomNum));
				kanji1 = new KanjiWord(dataSource.getKanjiWord(randomNum1));
				kanji2 = new KanjiWord(dataSource.getKanjiWord(randomNum2));
				sampleList = dataSource.getKanjiSample(randomNum,2);
				dataSource.close();
			}
			else{
				kanji = (KanjiWord)intent.getSerializableExtra("kanji");
				kanji1 = (KanjiWord)intent.getSerializableExtra("kanji1");
				kanji2 = (KanjiWord)intent.getSerializableExtra("kanji2");
				sampleList = (String[])intent.getStringArrayExtra("sample");
			}
			setKanjiToView(kanji, kanji1, kanji2);
			setSimpleToView(sampleList);
		}
	}

	private void setSimpleToView(String[] sampleList) {
		// TODO Auto-generated method stub
		TextView tvSample1 = (TextView)findViewById(R.id.tvSample1);
		TextView tvSample2 = (TextView)findViewById(R.id.tvSample2);
		TextView tvSample3 = (TextView)findViewById(R.id.tvSample3);
		TextView tvSample4 = (TextView)findViewById(R.id.tvSample4);
		TextView tvSample5 = (TextView)findViewById(R.id.tvSample5);
		TextView tvSample6 = (TextView)findViewById(R.id.tvSample6);
		
		tvSample1.setText("1 - "+sampleList[0]);
		tvSample2.setText("2 - "+sampleList[1]);
		tvSample3.setText("3 - "+sampleList[2]);
		tvSample4.setText("4 - "+sampleList[3]);
		tvSample5.setText("5 - "+sampleList[4]);
		tvSample6.setText("6 - "+sampleList[5]);
	}
	private void setKanjiToView(KanjiWord kanji,KanjiWord kanji1,KanjiWord kanji2) {
		// TODO Auto-generated method stub
		ImageView img_Main = (ImageView)findViewById(R.id.img_Main);
		ImageView img_Sub1 = (ImageView)findViewById(R.id.img_Sub1);
		ImageView img_Sub2 = (ImageView)findViewById(R.id.img_Sub2);
		TextView tv_MainMeanning = (TextView)findViewById(R.id.tvMainImage_Meaning);
		TextView tv_Sub1Meanning = (TextView)findViewById(R.id.tvSub1Image_Meaning);
		TextView tv_Sub2Meanning = (TextView)findViewById(R.id.tvSub2Image_Meaning);
		
		int id = getResources().getIdentifier("img"+kanji.getName(), "drawable", getPackageName());
		@SuppressWarnings("deprecation")
		Drawable drawable = getResources().getDrawable(id);
		id = getResources().getIdentifier("small_"+kanji1.getName(), "drawable", getPackageName());
		@SuppressWarnings("deprecation")
		Drawable drawable1 = getResources().getDrawable(id);
		id = getResources().getIdentifier("small_"+kanji2.getName(), "drawable", getPackageName());
		@SuppressWarnings("deprecation")
		Drawable drawable2 = getResources().getDrawable(id);
		img_Main.setImageDrawable(drawable);
		img_Sub1.setImageDrawable(drawable1);
		img_Sub2.setImageDrawable(drawable2);
		tv_MainMeanning.setText(kanji.getShortMean());
		tv_Sub1Meanning.setText(kanji1.getShortMean());
		tv_Sub2Meanning.setText(kanji2.getShortMean());
	}
	public void onRandomKanji(View view){
		dataSource.open();
		randomNum = new Random().nextInt((8) + 1) + 1;
		randomNum1	 = new Random().nextInt((8) + 1) + 1;
		while(randomNum1==randomNum){
			randomNum1	 = new Random().nextInt((8) + 1) + 1;
		}
		randomNum2 = new Random().nextInt((8) + 1) + 1;
		while(randomNum2==randomNum || randomNum2 == randomNum1){
			randomNum2 = new Random().nextInt((8) + 1) + 1;
		}
		kanji = new KanjiWord(dataSource.getKanjiWord(randomNum));
		kanji1 = new KanjiWord(dataSource.getKanjiWord(randomNum1));
		kanji2 = new KanjiWord(dataSource.getKanjiWord(randomNum2));
		setKanjiToView(kanji, kanji1, kanji2);
		sampleList = dataSource.getKanjiSample(randomNum,2);
		setSimpleToView(sampleList);
		dataSource.close();
	}
	
	public void OnFlipped(View view){
		Intent intent = new Intent(this, Flipped_Activity.class);
		intent.putExtra("kanji",kanji);
		intent.putExtra("kanji1",kanji1);
		intent.putExtra("kanji2",kanji2);
		intent.putExtra("sample",sampleList);
		startActivity(intent);
	}
	
	public void OnSubClick(View view){
		dataSource.open();
		int id = view.getId();
		switch(id){
			case R.id.img_Sub1:
				randomNum = randomNum1;
				randomNum1	 = new Random().nextInt((8) + 1) + 1;
				while(randomNum1==randomNum){
					randomNum1	 = new Random().nextInt((8) + 1) + 1;
				}
				randomNum2 = new Random().nextInt((8) + 1) + 1;
				while(randomNum2==randomNum || randomNum2 == randomNum1){
					randomNum2 = new Random().nextInt((8) + 1) + 1;
				}
				kanji = new KanjiWord(kanji1);
				break;
			case R.id.img_Sub2:
				randomNum = randomNum2;
				randomNum1	 = new Random().nextInt((8) + 1) + 1;
				while(randomNum1==randomNum){
					randomNum1	 = new Random().nextInt((8) + 1) + 1;
				}
				randomNum2 = new Random().nextInt((8) + 1) + 1;
				while(randomNum2==randomNum || randomNum2 == randomNum1){
					randomNum2 = new Random().nextInt((8) + 1) + 1;
				}
				kanji = new KanjiWord(kanji2);
				break;
		}
		kanji1 = new KanjiWord(dataSource.getKanjiWord(randomNum1));
		kanji2 = new KanjiWord(dataSource.getKanjiWord(randomNum2));
		setKanjiToView(kanji, kanji1, kanji2);
		sampleList = dataSource.getKanjiSample(randomNum,2);
		setSimpleToView(sampleList);
		dataSource.close();
	}
}

