package com.hugstudio.chuyenbenlycafe;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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

public class MainActivity extends Activity {

	private GridView photoGrid;
	private int mPhotoSize, mPhotoSpacing;
	private ImageAdapter imageAdapter;
	private List<YoutubeObj>lstVideo = new ArrayList<YoutubeObj>();
	private MySAXParser myXMLHandler;

// Some items to add to the GRID
	private static final String[] CONTENT = new String[] { "Akon", "Justin Bieber", "AlRight", "Big Sean",
	"Britney Spears", "Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean",
	"Britney Spears", "Hilary", "Micheal Buble", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
	"Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
	"Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Akon",
	"Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary", "Micheal Buble", "Britney Spears",
	"Hilary", "Micheal Buble", "Akon", "Justin Bieber", "AlRight", "Big Sean", "Britney Spears", "Hilary",
	"Micheal Buble" };
	private static final int[] ICONS = new int[] { R.drawable.cover_akon, R.drawable.cover_justin,
	R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
	R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
	R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
	R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
	R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
	R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin,
	R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary,
	R.drawable.cover_mb, R.drawable.cover_akon, R.drawable.cover_justin, R.drawable.cover_alright,
	R.drawable.cover_big_sean, R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb,
	R.drawable.cover_britney, R.drawable.cover_hilary, R.drawable.cover_mb, R.drawable.cover_akon,
	R.drawable.cover_justin, R.drawable.cover_alright, R.drawable.cover_big_sean, R.drawable.cover_britney,
	R.drawable.cover_hilary, R.drawable.cover_mb };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		try {   
		    /**
		    * Create a new instance of the SAX parser
		    **/
		    SAXParserFactory saxPF = SAXParserFactory.newInstance();
		    SAXParser saxP = saxPF.newSAXParser();
		    XMLReader xmlR = saxP.getXMLReader();
		 
		         
		    URL url = new URL("https://dl.dropboxusercontent.com/u/27529224/chuyenbenlycafe.xml"); // URL of the XML
		         
		    /** 
		    * Create the Handler to handle each of the XML tags. 
		    **/
		    myXMLHandler = new MySAXParser();
		    xmlR.setContentHandler(myXMLHandler);
		    xmlR.parse(new InputSource(url.openStream()));
		         
		} catch (Exception e) {
		    System.out.println(e);
		}
		finally{
			lstVideo = new ArrayList<YoutubeObj>(myXMLHandler.lstVideo);
		}
		setContentView(R.layout.activity_main);
	
	// get the photo size and spacing
		mPhotoSize = getResources().getDimensionPixelSize(R.dimen.photo_size);
		mPhotoSpacing = getResources().getDimensionPixelSize(R.dimen.photo_spacing);
	
	// initialize image adapter
		imageAdapter = new ImageAdapter();
	
		photoGrid = (GridView) findViewById(R.id.albumGrid);
	
	// set image adapter to the GridView
		photoGrid.setAdapter(imageAdapter);
	
	// get the view tree observer of the grid and set the height and numcols dynamically
		photoGrid.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
			@Override
		public void onGlobalLayout() {
				if (imageAdapter.getNumColumns() == 0) {
					final int numColumns = (int) Math.floor(photoGrid.getWidth() / (mPhotoSize + mPhotoSpacing));
					if (numColumns > 0) {
						final int columnWidth = (photoGrid.getWidth() / numColumns) - mPhotoSpacing;
						imageAdapter.setNumColumns(numColumns);
						imageAdapter.setItemHeight(columnWidth);
	
					}
				}
			}
		});
		}

// ///////// ImageAdapter class /////////////////
	public class ImageAdapter extends BaseAdapter {
		private LayoutInflater mInflater;
		private int mItemHeight = 0;
		private int mNumColumns = 0;
		private RelativeLayout.LayoutParams mImageViewLayoutParams;
	
		public ImageAdapter() {
			mInflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			mImageViewLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT,	LayoutParams.MATCH_PARENT);
		}
	
		public int getCount() {
			return CONTENT.length;
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
	
			cover.setImageResource(ICONS[position % ICONS.length]);
			title.setText(CONTENT[position % CONTENT.length]);
	
			return view;
		}
	}

}
