package com.company;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Note {

	private String poznamka;
	private long second;
	
	public Note(String poznamka){
		this.poznamka = poznamka;
		second = System.currentTimeMillis();
	}
	public Note(String poznamka, long time){
		this.poznamka = poznamka;
		second = time;
	}
	public void setPoznamka(String text){
		poznamka = text;
	}
	public String getPoznamka(){
		return poznamka;
	}
	public String getDatum(){
		Date date = new Date(second);
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/LL/yyyy");
		return dateFormat.format(date);
	}
	public String getCas(){
		Date date = new Date(second);
		SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
		return dateFormat.format(date);
	}

	public long getSecond() {
		return second;
	}

	public void setSecond(long second) {
		this.second = second;
	}

	@Override
	public String toString(){
		return getPoznamka();
	}
}
