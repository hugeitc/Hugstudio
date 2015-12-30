package com.hugstudio.chuyenbenlycafe;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class YouTubeFragmentActivity extends FragmentActivity  {

	public YouTubeFragmentActivity() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_youtube_fragment);
		Bundle bundle = getIntent().getExtras();
		
		String video_id = bundle.getString("videoID");
		String video_title = bundle.getString("videoTitle");
		
		YoutubeFragment youtubeFrag = (YoutubeFragment)getSupportFragmentManager().findFragmentById(R.id.fragment_youtube);
		youtubeFrag.setVideoID(video_id);
		youtubeFrag.setVideoTitle(video_title);
		
		//ads
		AdView mAdViewTop = (AdView) findViewById(R.id.adViewTop);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdViewTop.loadAd(adRequest);
        
        AdView mAdViewBottom = (AdView) findViewById(R.id.adViewBottom);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        mAdViewBottom.loadAd(adRequest1);
	}

}
