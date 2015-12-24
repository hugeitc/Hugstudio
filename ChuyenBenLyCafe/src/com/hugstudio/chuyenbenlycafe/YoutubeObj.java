package com.hugstudio.chuyenbenlycafe;

public class YoutubeObj {
	
	private String subject, url, visitor;
	private byte[] img;
	private boolean isNew, isWatched;

	public YoutubeObj() {
		// TODO Auto-generated constructor stub
		subject = "";
		url = "";
		visitor="";
	}
	
	public YoutubeObj(String content, String _url, byte[] _img, int status){
		//content have format:
		// VTV3 - Chuyen ben ly cafe - Subject - visitor - date
		
		url = _url;
		String[] arrContent = content.split("-");
		subject = arrContent[2];
		visitor = arrContent[3];
		img = _img;
		setStatus(status);
	}
	
	public YoutubeObj(YoutubeObj obj){
		url = obj.url;
		subject = obj.subject;
		visitor = obj.visitor;
		img = obj.img;
		isNew = obj.isNew;
		isWatched = obj.isWatched;
	}
	
	public void setStatus(int status){
		switch(status){
		case 0:
			isNew = true;
			isWatched = false;
		case 1:
			isNew = false;
			isWatched = false;
		case 2:
			isNew = false;
			isWatched = true;
		}
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVisitor() {
		return visitor;
	}

	public void setVisitor(String visitor) {
		this.visitor = visitor;
	}

	public byte[] getImg() {
		return img;
	}

	public void setImg(byte[] img) {
		this.img = img;
	}

	public boolean isNew() {
		return isNew;
	}

	public void setNew(boolean isNew) {
		this.isNew = isNew;
	}

	public boolean isWatched() {
		return isWatched;
	}

	public void setWatched(boolean isWatched) {
		this.isWatched = isWatched;
	}

}
