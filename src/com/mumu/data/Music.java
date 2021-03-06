package com.mumu.data;

import java.util.ArrayList;
import java.util.List;



public class Music {

	private int musicIndex;
	private String track;
	private String artist;
	private String album;
	
	private List<User> userList = new ArrayList<User>();


	private Music(int musicIndex, String track,
			String artist, String album){
		this.musicIndex = musicIndex;
		this.track = track;
		this.artist = artist;
		this.album = album;

	}
	
	public static Music create(int musicIndex, String track,
			String artist, String album) {
		return new Music(musicIndex, track, artist, album);
	}
	
	public int getMusicIndex(){
		return this.musicIndex;
	}
	
	public String getTrack(){
		return this.track;
	}
	
	public String getArtist(){
		return this.artist;
	}
	
	public String getAlbum(){
		return this.album;
	}
	
	public List<User> getUserList(){
		return userList;
	}
	
	public void addUserList(User user){
		userList.add(user);
	}

	public List<User> compareUser(Music compareMusic) {
		List<User> sameUser = new ArrayList<User>();
		
		for (User user : compareMusic.getUserList()){
			if(isSameUser(user)){
				sameUser.add(user);
			}
		}
		return sameUser;
	}

	private boolean isSameUser(User user) {
		return this.getUserList().contains(user);
	}
	
}

	