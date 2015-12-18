package com.hugstudio.kanjiflashcard;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Flipped_Activity extends Activity {

	KanjiWord kanji, kanji1, kanji2;
	String[] sampleList;
	public Flipped_Activity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.layout_flip);
		
		Intent intent = getIntent();
		kanji = (KanjiWord)intent.getSerializableExtra("kanji");
		kanji1 = (KanjiWord)intent.getSerializableExtra("kanji1");
		kanji2 = (KanjiWord)intent.getSerializableExtra("kanji2");
		sampleList = (String[])intent.getStringArrayExtra("sample");
		
		TextView tv_On = (TextView)findViewById(R.id.tvOn);
		TextView tv_Kun = (TextView)findViewById(R.id.tvKun);
		TextView tv_LongMeanning = (TextView)findViewById(R.id.tvLongMean);
		
		tv_On.setText("- "+kanji.getOn());
		tv_Kun.setText("- "+kanji.getKun());
		tv_LongMeanning.setText("- "+kanji.getLongMean());
		setContentToSampleTextView();
	}
	
	private void setContentToSampleTextView() {
		// TODO Auto-generated method stub
		KanjiDataSource dataSource = new KanjiDataSource(this);
		dataSource.open();
		String[] sampleRomanjiList = dataSource.getKanjiSample(Integer.parseInt(kanji.getName()),3);
		String[] sampleMeanningjiList = dataSource.getKanjiSample(Integer.parseInt(kanji.getName()),4);
		
		TextView tv_Sample1 = (TextView)findViewById(R.id.tvFlipSample1);
		TextView tv_Sample2 = (TextView)findViewById(R.id.tvFlipSample2);
		TextView tv_Sample3 = (TextView)findViewById(R.id.tvFlipSample3);
		TextView tv_Sample4 = (TextView)findViewById(R.id.tvFlipSample4);
		TextView tv_Sample5 = (TextView)findViewById(R.id.tvFlipSample5);
		TextView tv_Sample6 = (TextView)findViewById(R.id.tvFlipSample6);
		
		tv_Sample1.setText("1 - "+sampleRomanjiList[0]+": "+sampleMeanningjiList[0]);
		tv_Sample2.setText("2 - "+sampleRomanjiList[1]+": "+sampleMeanningjiList[1]);
		tv_Sample3.setText("3 - "+sampleRomanjiList[2]+": "+sampleMeanningjiList[2]);
		tv_Sample4.setText("4 - "+sampleRomanjiList[3]+": "+sampleMeanningjiList[3]);
		tv_Sample5.setText("5 - "+sampleRomanjiList[4]+": "+sampleMeanningjiList[4]);
		tv_Sample6.setText("6 - "+sampleRomanjiList[5]+": "+sampleMeanningjiList[5]);
		
		dataSource.close();
	}

	public void OnFlippedBackToMain(View view){
		Intent intent = new Intent(this, MainActivity.class);
		intent.putExtra("kanji",kanji);
		intent.putExtra("kanji1",kanji1);
		intent.putExtra("kanji2",kanji2);
		intent.putExtra("sample",sampleList);
		startActivity(intent);
	}

}
