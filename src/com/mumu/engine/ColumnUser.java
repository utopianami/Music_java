package com.mumu.engine;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import com.mumu.data.Music;
import com.mumu.data.User;

public class ColumnUser implements Comparator<ColumnUser> {

	private List<Music> sameMusic = new ArrayList<Music>();
	private User standardUser; // 행 
	private User compareUser; // 열 
	private int sameMusicCount;

	public void makeColumn(User standardUser, User compareUser) {
		this.sameMusic  = standardUser.compareMusic(compareUser); //두 유저간의 공통된 노래 리스트 
		this.sameMusicCount = sameMusic.size();
		this.standardUser = standardUser;
		this.compareUser = compareUser;
	}
	
	public User getStandardUser(){
		return standardUser;
	}
	
	public User getCompareUser(){
		return compareUser;
	}
	
	public List<Music> getSameMusic(){
		return sameMusic;
	}
	
	public int getSameMusicCount(){
		return sameMusicCount;
	}

	@Override
	public int compare(ColumnUser o1, ColumnUser o2) {
		return o2.sameMusicCount - o1.sameMusicCount;
	}

	
}
