package com.hugstudio.chuyenbenlycafe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class MySAXParser extends DefaultHandler {

	public List<YoutubeObj> lstVideo = new ArrayList<YoutubeObj>();
	private YoutubeObj _video;
	private boolean video,title, url;
	public MySAXParser() {
		// TODO Auto-generated constructor stub
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes){
		
		if(qName.equalsIgnoreCase("title")){
			title = true;
		}
		if(qName.equalsIgnoreCase("url")){
			url = true;
		}
		if(qName.equalsIgnoreCase("video")){
			video = true;
		}
	}
	
	public void endElement(String uri, String localName, String qName){
		if(qName.equalsIgnoreCase("video")){
			lstVideo.add(_video);
		}
	}
	
	public void characters(char ch[], int start, int length){
		
		if(video){
			_video = new YoutubeObj();
			video = false;
		}
		if(title){
			String titleContent = new String(ch, start, length);
			String[] arrContent = titleContent.split("-");
			_video.setSubject(arrContent[2]);
			_video.setVisitor(arrContent[3]);
			_video.setStatus(0);
			title = false;
		}
		if(url){
			String content = new String (ch,start, length);
			_video.setUrl(content);
			try {
				_video.setImg(ImageUtilities.downloadBitmap(content));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			url = false;
		}
	}
}
