package com.mumu.engine;

import com.mumu.data.Database;
import com.mumu.data.Music;
import com.mumu.data.User;

public class Engine {

	private Matrix matrix;
	
	private static Engine var = new Engine();
	
	private Engine(){
		matrix = Matrix.create();
	}
	public static Engine getInstance(){
		return var;
	}
	
	public void makeUserMatrix(Database db){
		matrix.makeUserMatrix(db);
	}

	public void makeMusicMatrix(Database db){
		matrix.makeMusicMatrix(db);
	}
	
	//노래추천
	public Music recommendMusic(int standardNumber, Database db, User standardUser){
		if (standardNumber == 1){
			return recommendMusic1(db, standardUser);
		}

		if (standardNumber == 2){
			return recommnedMusic2(db, standardUser);
		}
		return null;
	}
	
	//추천 기준1 : 나와 유사한 사람 -> 그 사람이 최근들은 곡
	//들었던 곡일 경우 다음 최근 재생목록의 곡 추천 
	public Music recommendMusic1(Database db, User standardUser){
		User relationUser = matrix.relationUser(standardUser.getUserIndex());	
		Music recommendMusic = relationUser.getRecomendMusic1(standardUser);
	
		return recommendMusic;
	}
	
	//추천기준 2 : 최근에 들은 곡 -> 그 곡과 유사한 곡
	//들었던 곡일 경우 나의 다음 최신곡으로 추천 
	public Music recommnedMusic2(Database db, User user){
		Music recommendMusic = user.getRecomendMusic2(user, matrix);
		return recommendMusic;
	}
}
