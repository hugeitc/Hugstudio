package com.hugstudio.kanjiflashcard;

public class KanjiWord {
	
	private String name,shortMean, longMean, on, kun; 
	
	public KanjiWord() {
		// TODO Auto-generated constructor stub
	}
	public KanjiWord(String _name, String _shortMean, String _longMean, String _on, String _kun){
		name = _name;
		shortMean = _shortMean;
		longMean = _longMean;
		on = _on;
		kun = _kun;
	}
		public KanjiWord(KanjiWord word){
		name = word.getName();
		shortMean = word.getShortMean();
		longMean = word.getLongMean();
		on = word.getOn();
		kun = word.getKun();
	}
	
	public void setName(String _name){
		name = _name;
	}
	public void setShortMean(String _shortMean){
		shortMean = _shortMean;
	}
	public void setLongMean(String _longMean){
		longMean = _longMean;
	}
	public void setOn(String _on){
		on = _on;
	}
	public void setKun(String _kun){
		kun = _kun;
	}
	public String getName(){
		return name;
	}
	public String getShortMean(){
		return shortMean;
	}
	public String getLongMean(){
		return longMean;
	}
	public String getOn(){
		return on;
	}
	public String getKun(){
		return kun;
	}

}
