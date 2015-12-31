package com.hugstudio.chuyenbenlycafe;

import java.util.ArrayList;
import java.util.List;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubeApiServiceUtil;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private GridView photoGrid;
	private int mPhotoSize, mPhotoSpacing;
	private ImageAdapter imageAdapter;
	private List<YoutubeObj> lstVideo = new ArrayList<YoutubeObj>();
	private int count = 0;
	InterstitialAd mInterstitialAd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);
		
		YoutubeDatabaseHelper db = new YoutubeDatabaseHelper(this);
		lstVideo = new ArrayList<YoutubeObj>(db.getAllVideo());
		db.close();
		
		// get the photo size and spacing
		mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
		mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);

		// initialize image adapter
		imageAdapter = new ImageAdapter();

		photoGrid = (GridView) findViewById(R.id.albumGrid);

		// set image adapter to the GridView
		photoGrid.setAdapter(imageAdapter);

		// get the view tree observer of the grid and set the height and numcols
		// dynamically
		photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(
				new ViewTreeObserver.OnGlobalLayoutListener() {
					@Override
					public void onGlobalLayout() {
						if (imageAdapter.getNumColumns() == 0) {
							final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
							if (numColumns > 0) {
								final int columnWidth = (photoGrid.getWidth() / numColumns)	- mPhotoSpacing;
								imageAdapter.setNumColumns(numColumns);
								imageAdapter.setItemHeight(columnWidth);

							}
						}
					}
				});
		mInterstitialAd = new InterstitialAd(this);
		mInterstitialAd.setAdUnitId("ca-app-pub-4481753127919607/3276353513");
		AdRequest adRequest = new AdRequest.Builder().build();
		mInterstitialAd.loadAd(adRequest);
	}

	// ///////// ImageAdapter class /////////////////
	public class ImageAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private int mItemHeight = 0;
		private int mNumColumns = 0;
		private RelativeLayout.LayoutParams mImageViewLayoutParams;

		public ImageAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		}

		public int getCount() {
			 //return CONTENT.length;
			return lstVideo.size();
		}

		// set numcols
		public void setNumColumns(int numColumns) {
			mNumColumns = numColumns;
		}

		public int getNumColumns() {
			return mNumColumns;
		}

		// set photo item height
		public void setItemHeight(int height) {
			if (height == mItemHeight) {
				return;
			}
			mItemHeight = height;
			mImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, mItemHeight);
			notifyDataSetChanged();
		}

		public Object getItem(int position) {
			return position;
		}

		public long getItemId(int position) {
			return position;
		}

		@SuppressLint("InflateParams")
		public View getView(final int position, View view, ViewGroup parent) {

			if (view == null)
				view = mInflater.inflate(R.layout.photo_item, null);

			ImageView cover = (ImageView) view.findViewById(R.id.cover);
			TextView title = (TextView) view.findViewById(R.id.title);

			cover.setLayoutParams(mImageViewLayoutParams);

			// Check the height matches our calculated column width
			if (cover.getLayoutParams().height != mItemHeight) {
				cover.setLayoutParams(mImageViewLayoutParams);
			}

			 //cover.setImageResource(ICONS[position % ICONS.length]);
			 //title.setText(CONTENT[position % CONTENT.length]);
			cover.setImageBitmap(ImageUtilities.createBitmapFromByteArray(lstVideo.get(position).getImg()));
			title.setText(lstVideo.get(position).getSubject());
			
			//set OnClick for image
			cover.setOnClickListener(new View.OnClickListener() {
				
				@Override
				public void onClick(View v) {
					// TODO Auto-generated method stub
					//check if youtube app available
					//call Youtube Activity to play video
					final YouTubeInitializationResult result = YouTubeApiServiceUtil.isYouTubeApiServiceAvailable(getApplicationContext());

					if (result != YouTubeInitializationResult.SUCCESS) {
					    //If there are any issues we can show an error dialog.
					    result.getErrorDialog(MainActivity.this, 0).show();
					}
					else{
						Intent intent = new Intent(getApplicationContext(), YouTubeFragmentActivity.class);
						intent.putExtra("videoID", lstVideo.get(position).getUrl());
						intent.putExtra("videoTitle", lstVideo.get(position).getSubject());
						startActivity(intent);
					}
				}
			});
			
			return view;
		}
	}
	
	@Override
	public void onBackPressed(){
		if(count ==0){
			Toast.makeText(this, "Press Back again to exit!", Toast.LENGTH_LONG).show();
			count++;
		}
		else{
			if (mInterstitialAd.isLoaded()) {
	            mInterstitialAd.show();
			}
			finish();
		}
	}

	

}
