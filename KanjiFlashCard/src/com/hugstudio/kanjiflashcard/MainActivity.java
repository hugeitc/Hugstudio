package com.hugstudio.kanjiflashcard;

import java.util.Random;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	KanjiDataSource dataSource;
	
	public MainActivity() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_main);
		
		dataSource = new KanjiDataSource(this);
		dataSource.open();
		/**
		 * random kanji in database
		 */
		int randomNum = new Random().nextInt((8) + 1) + 1;
		int randomNum1	 = new Random().nextInt((8) + 1) + 1;
		while(randomNum1==randomNum){
			randomNum1	 = new Random().nextInt((8) + 1) + 1;
		}
		int randomNum2 = new Random().nextInt((8) + 1) + 1;
		while(randomNum2==randomNum || randomNum2 == randomNum1){
			randomNum2 = new Random().nextInt((8) + 1) + 1;
		}
		KanjiWord kanji = new KanjiWord(dataSource.getKanjiWord(randomNum));
		KanjiWord kanji1 = new KanjiWord(dataSource.getKanjiWord(randomNum1));
		KanjiWord kanji2 = new KanjiWord(dataSource.getKanjiWord(randomNum2));
		setKanjiToView(kanji, kanji1, kanji2);
		dataSource.close();
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
		id = getResources().getIdentifier("img"+kanji1.getName(), "drawable", getPackageName());
		@SuppressWarnings("deprecation")
		Drawable drawable1 = getResources().getDrawable(id);
		id = getResources().getIdentifier("img"+kanji2.getName(), "drawable", getPackageName());
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
		int randomNum = new Random().nextInt((8) + 1) + 1;
		int randomNum1	 = new Random().nextInt((8) + 1) + 1;
		while(randomNum1==randomNum){
			randomNum1	 = new Random().nextInt((8) + 1) + 1;
		}
		int randomNum2 = new Random().nextInt((8) + 1) + 1;
		while(randomNum2==randomNum || randomNum2 == randomNum1){
			randomNum2 = new Random().nextInt((8) + 1) + 1;
		}
		KanjiWord kanji = new KanjiWord(dataSource.getKanjiWord(randomNum));
		KanjiWord kanji1 = new KanjiWord(dataSource.getKanjiWord(randomNum1));
		KanjiWord kanji2 = new KanjiWord(dataSource.getKanjiWord(randomNum2));
		setKanjiToView(kanji, kanji1, kanji2);
		dataSource.close();
	}
}

