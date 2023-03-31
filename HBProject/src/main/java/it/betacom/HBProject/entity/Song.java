package it.betacom.HBProject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Song {
	@Id
	private int id;
	private String songName;
	private String artist;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSongName() {
		return songName;
	}
	public void setSongName(String songName) {
		this.songName = songName;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	
	

}
